/**
 ******************************************************************************
 * 							  	TADIGITAL
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.testutils;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * The Class ExtentManager.
 */
public class ExtentManager {

	/**
	 * Instantiates a new extent manager.
	 */
	private ExtentManager() {
	}

	/** The extent. */
	private static ExtentReports extent;

	/** The file path. */
	private static String filePath = "./extentreport.html";

	/**
	 * Gets the extent.
	 *
	 * @return the extent
	 */
	public static ExtentReports getExtent() {
		if (extent != null) {
			return extent;
		} else {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());
			extent.setSystemInfo("Host Name", "Prabhudatta Choudhury");
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			return extent;
		}
	}

	/**
	 * Gets the html reporter.
	 *
	 * @return the html reporter
	 */
	public static ExtentHtmlReporter getHtmlReporter() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.setAppendExisting(false);
		htmlReporter.loadXMLConfig(
				System.getProperty(Constants.ROOT_DIR) + "/src/test/resources/extentConfig/ReportsConfig.xml");
		return htmlReporter;
	}

}
