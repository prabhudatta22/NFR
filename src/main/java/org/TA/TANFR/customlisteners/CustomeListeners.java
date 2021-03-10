/**
 ******************************************************************************
 * 							  	STAYING SHARP
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.customlisteners;

import java.io.IOException;
import java.util.Arrays;

import org.TA.TANFR.setup.TestSetUp;
import org.TA.TANFR.testutils.Constants;
import org.TA.TANFR.testutils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class CustomeListeners extends TestSetUp implements ITestListener, ISuiteListener, WebDriverEventListener {

	public void onFinish(ISuite arg0) {
		/* Code related to onFinish goes here */
	}

	public void onStart(ISuite arg0) {
		/* Code related to onStart goes here */
	}

	public void onFinish(ITestContext context) {
		/* Code related to onFinish goes here */
	}

	public void onStart(ITestContext arg0) {
		/* Code related to onStart goes here */
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		/* Code related to onTestFailedButWithinSuccessPercentage goes here */
	}

	public void onTestFailure(ITestResult arg0) {

		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			testCaseLogger.get().info("Unable to capture screenshot");
			appLogs.debug("Unable to capture screenshot. " + e);
		}
		String excepionMessage = arg0.getThrowable().getMessage();
		String excepionStackTrace = Arrays.toString(arg0.getThrowable().getStackTrace());
		try {
			testCaseLogger.get()
					.fail("<details>" + "<summary style='cursor: pointer;'>" + "<b>" + Constants.OR_START_FONT_TAG
							+ "red>" + "Exception Occured: Click to see" + Constants.OR_END_FONT_TAG + "</b >"
							+ "</summary>" + excepionMessage.replaceAll(",", "<br>") + "<br>"
							+ excepionStackTrace.replaceAll(",", "<br>") + "</details>" + " \n");

			testCaseLogger.get().fail(
					"<b>" + Constants.OR_START_FONT_TAG + "red>" + "ScreenShot of failure" + Constants.OR_END_FONT_TAG
							+ "</b><style>[data-featherlight]{cursor: pointer;}</style>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.screenshotPath + TestUtils.screenshotName)
							.build());
		} catch (IOException e) {
			testCaseLogger.get().info("Unable to create Screen Capture");
			appLogs.debug("Unable to create Screen Capture. " + e);
		}
		String failureLog = "This Test Case got Failed";
		Markup m = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
		testCaseLogger.get().log(Status.FAIL, m);

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<br>");
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href=" + System.getProperty(Constants.ROOT_DIR)
				+ Constants.SCREENSHOTS_FOLDER + TestUtils.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log(
				"<a target=\"_blank\" href=" + System.getProperty(Constants.ROOT_DIR) + Constants.SCREENSHOTS_FOLDER
						+ TestUtils.screenshotName + "><img src=" + System.getProperty(Constants.ROOT_DIR)
						+ Constants.SCREENSHOTS_FOLDER + TestUtils.screenshotName + " height=100 width=100></img></a>");
	}

	public void onTestSkipped(ITestResult arg0) {
		String methodName = arg0.getMethod().getMethodName();
		String logText = "<b>" + Constants.OR_START_FONT_TAG + "blue>" + "Test Case:- " + methodName + " Skipped"
				+ Constants.OR_END_FONT_TAG + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testCaseLogger.get().skip(m);
	}

	public void onTestStart(ITestResult arg0) {
		String methodName = arg0.getMethod().getMethodName();
		ExtentTest child = parentTest.get().createNode(methodName);
		testCaseLogger.set(child);
		Reporter.log(" Starting execution of Test Case:- " + methodName + ". ");
		testCaseLogger.get().info("<b>" + "Starting execution of Test Case:- " + methodName + "</b>");
	}

	public void onTestSuccess(ITestResult arg0) {
		String methodName = arg0.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Passed" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testCaseLogger.get().pass(m);
	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		/* Code related to afterAlertAccept goes here */
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		/* Code related to afterAlertDismiss goes here */
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		/* Code related to afterChangeValueOf goes here */
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver arg1) {
		testCaseLogger.get().info("Clicked on: " + element);
		appLogs.debug("Clicked on: " + element);

	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		/* Code related to afterFindBy goes here */
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		/* Code related to afterGetScreenshotAs goes here */
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		/* Code related to afterNavigateBack goes here */
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		/* Code related to afterNavigateForward goes here */
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		/* Code related to afterNavigateRefresh goes here */

	}

	private void highlightElement(By by) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		/* Code related to afterNavigateTo goes here */

		if (arg1.findElements(By.xpath(
				"//div[@class='acsFocusFirst acsClassicInvite']//a[@title='Click to close.'][contains(text(),'×')]"))
				.size() > 0) {
			highlightElement(By.xpath(
					"//div[@class='acsFocusFirst acsClassicInvite']//a[@title='Click to close.'][contains(text(),'×')]"));
			arg1.findElement(By.xpath(
					"//div[@class='acsFocusFirst acsClassicInvite']//a[@title='Click to close.'][contains(text(),'×')]"))
					.click();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeAlertAccept(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeAlertDismiss(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeNavigateTo(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeNavigateBack(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeNavigateForward(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeNavigateRefresh(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeFindBy(
	 * org.openqa.selenium.By, org.openqa.selenium.WebElement,
	 * org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeClickOn(
	 * org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeChangeValueOf(org.openqa.selenium.WebElement,
	 * org.openqa.selenium.WebDriver, java.lang.CharSequence[])
	 */
	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeScript(
	 * java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterScript(
	 * java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeSwitchToWindow(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * afterSwitchToWindow(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#onException(
	 * java.lang.Throwable, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeGetScreenshotAs(org.openqa.selenium.OutputType)
	 */
	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

}