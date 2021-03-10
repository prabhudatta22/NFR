/**
 ******************************************************************************
 * 							  	STAYING SHARP
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.TA.TANFR.testutils.Constants;
import org.TA.TANFR.testutils.DriverFactory;
import org.TA.TANFR.testutils.DriverManager;
import org.TA.TANFR.testutils.ExcelReader;
import org.TA.TANFR.testutils.ExtentManager;
import org.TA.TANFR.testutils.TestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import atu.testrecorder.ATUTestRecorder;

/**
 * The Class TestSetUp.
 */
public class TestSetUp {

	/** The recorder. */
	ATUTestRecorder recorder;

	/** The config property. */
	public static Properties configProperty;

	/** The extent. */
	public static ExtentReports extent;

	/** The parent test. */
	public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	/** The test case logger. */
	public static ThreadLocal<ExtentTest> testCaseLogger = new ThreadLocal<ExtentTest>();

	/** The app logs. */
	public static Logger appLogs = Logger.getLogger("devpinoyLogger");

	/** The Constant excel. */
	public static final ExcelReader excel = new ExcelReader(
			System.getProperty(Constants.ROOT_DIR) + "/src/test/resources/testData/Demo.xlsx");

	public static ExcelReader excelWriter = null;

	public static String applicationUderTest = null;

	public static String getTimeStamp() {

		SimpleDateFormat sdf = new SimpleDateFormat("MMddYYYY_HHmmss");
		System.out.println("File to be written >>> " + System.getProperty(Constants.ROOT_DIR) + "/Reports/"
				+ sdf.format(new Date(System.currentTimeMillis())) + "_NFR_Report.xlsx");
		return sdf.format(new Date(System.currentTimeMillis()));

	}

	/**
	 * Navigate back and refresh.
	 */
	public void navigateBackAndRefresh() {
		DriverManager.getDriver().navigate().back();
		DriverManager.getDriver().navigate().refresh();
		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			appLogs.error("Exception occured while executing navigateBackAndRefresh: " + e);
		}
	}

	public void recursiveDelete(File file) { // to end the recursive loop
		if (!file.exists())
			return;
		{
			// if directory, go inside and call recursively
			if (file.isDirectory()) {
				for (File f : file.listFiles()) { // call recursively
					f.delete();
				}
			}
		}
	}

	/**
	 * Before suite.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@BeforeSuite
	public synchronized void beforeSuite() throws IOException {

		try {

			File file = new File(System.getProperty(Constants.ROOT_DIR) + "/src/test/resources/testData/NFR/");
			if (file.isDirectory() && file.exists()) {
				recursiveDelete(file);
			}

			File file2 = new File(System.getProperty(Constants.ROOT_DIR) + "/Reports");
			if (file2.isDirectory() && file2.exists()) {
				recursiveDelete(file2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		TestUtils.moveReportsToArchiveFolder();
		TestUtils.deleteVideos(System.getProperty("user.dir") + "/ScriptVideos");
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(new File(
					System.getProperty(Constants.ROOT_DIR) + "/src/test/resources/PropertyFiles/config.properties"));

			configProperty = new Properties();
			configProperty.load(fi);

		} catch (FileNotFoundException e) {
			appLogs.debug("config.properties file is not found. " + e);

		} finally {
			if (fi != null) {
				fi.close();
				extent = ExtentManager.getExtent();

			}
		}

		applicationUderTest = System.getProperty("url");
		System.out.println("Application under test is >> " + applicationUderTest);
	}

	/**
	 * Before test.
	 */
	@BeforeTest
	public void beforeTest() {

		/* Before Test code comes here. */
	}

	/**
	 * Before class.
	 */
	@BeforeClass
	public void beforeClass() {
		/* Extent Reporting */
		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		parentTest.set(parent);
		testCaseLogger.set(parent);
	}

	/**
	 * Before method.
	 *
	 * @param method
	 *            the method
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */

	@BeforeMethod
	public synchronized void beforeMethod(Method method) throws MalformedURLException {
		appLogs.debug("Starting exection of test case: " + method.getName());
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd  HH-mm-ss");
		Date date = new Date();
		try {
			recorder = new ATUTestRecorder(System.getProperty("user.dir") + "/ScriptVideos/",
					method.getName() + "-" + dateFormat.format(date), false);
		} catch (Exception e) {
			appLogs.debug("Error in finding the location of the video.");
		}
		// To start video recording.
		try {
			recorder.start();
		} catch (Exception e) {
			appLogs.debug("Error in starting the video.");
		}

		String cmdBrowser = System.getProperty("browser");
		String browser = StringUtils.isEmpty(cmdBrowser) ? configProperty.getProperty("browser") : cmdBrowser;

		WebDriver driver = null;

		if (driver == null) {
			DriverFactory.createDriverInstance(browser);
			DriverManager.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Before method URL " + configProperty.getProperty("url"));
			DriverManager.getDriver().get(configProperty.getProperty("url"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * After method.
	 *
	 * @param result
	 *            the result
	 */
	@AfterMethod
	public void afterMethod(ITestResult result) {
		extent.flush();
		DriverFactory.destroyDriver();
		try {
			recorder.stop();
		} catch (Exception e) {
			appLogs.info("Unable to stop the screen recording.");
		}
	}

	/**
	 * After class.
	 */
	@AfterClass
	public void afterClass() {
		/* After Class code comes here. */
	}

	/**
	 * After test.
	 */
	@AfterTest
	public void afterTest() {
		/* After Test code comes here. */

	}

	/**
	 * After suite.
	 */
	@AfterSuite
	public void afterSuite() {
		/* After Suite code comes here. */
	}

	/**
	 * Assign author.
	 *
	 * @param authorName
	 *            the author name
	 */
	public void assignAuthor(String authorName) {
		testCaseLogger.get().assignAuthor(authorName);
	}

	/**
	 * Assign category.
	 *
	 * @param category
	 *            the category
	 */
	public void assignCategory(String category) {
		testCaseLogger.get().assignCategory(category);
	}

	/**
	 * Navigate to base URL.
	 */
	public void navigateToBaseURL() {
		DriverManager.getDriver().navigate().to(configProperty.getProperty("url"));
		appLogs.debug("Navigating to BaseURL");
		Reporter.log(" Navigating to BaseURL:- " + configProperty.getProperty("url") + ". ");
		testCaseLogger.get().info("Navigating to BaseURL:- " + "<b>" + "<font color=blue>"
				+ configProperty.getProperty("url") + "</font>" + "</b>");

	}

	/**
	 * My wait.
	 */
	public void myWait() {
		try {
			Thread.sleep(5000L);
		} catch (Exception e) {
			appLogs.debug(e);

		}
	}

	/**
	 * Custom wait.
	 *
	 * @param time
	 *            the time
	 */
	public void CustomWait(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			appLogs.debug(e);

		}
	}

	/**
	 * Wait for video to play.
	 */
	public void waitForVideoToPlay() {
		try {
			Thread.sleep(20000L);
		} catch (Exception e) {
			appLogs.debug(e);

		}
	}
}
