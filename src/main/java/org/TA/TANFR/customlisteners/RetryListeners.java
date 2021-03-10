/**
 ******************************************************************************
 * 							  	STAYING SHARP
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.customlisteners;

import org.TA.TANFR.setup.TestSetUp;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * The Class RetryListeners.
 */
public class RetryListeners implements IRetryAnalyzer {

	/** The count. */
	private int count = 0;
	
	/** The max count. */
	private int maxCount = 0;

	/* 
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 */
	@Override
	public boolean retry(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Throwable ex = result.getThrowable();
			if (ex != null && ex.getClass() == UnreachableBrowserException.class) {
				TestSetUp.appLogs.debug("UnreachableBrowserException");
			}
			if (count < maxCount) {
				count++;
				result.setStatus(ITestResult.SUCCESS_PERCENTAGE_FAILURE);
				String message = Thread.currentThread().getName() + " Error in "
						+ result.getName() + " with status "
						+ result.getStatus() + " Retry attempt # " + count;
				TestSetUp.appLogs.debug(message);
				return true;
			}

		}
		return false;
	}	
}