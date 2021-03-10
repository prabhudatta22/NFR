/**
 ******************************************************************************
 * 							  	TADIGITAL
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.testutils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.TimeZone;

import org.TA.TANFR.setup.TestSetUp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

/**
 * The Class TestUtils.
 */
public class TestUtils extends TestSetUp {

	/** The screenshot path. */
	public static String screenshotPath;

	/** The screenshot name. */
	public static String screenshotName;

	/** The test sheet name. */
	public String testSheetName;

	/**
	 * Gets the data.
	 *
	 * @param method
	 *            the method
	 * @return the data
	 */
	/* Use this dataprovider when we have one excel sheet for one test case. */
	@DataProvider(name = "dp")
	public Object[][] getData(Method method) {
		/*
		 * 1. Sheet name same as the test case name 2. Returns the row count in
		 * the sheet 3. Returns the column count in the sheet
		 */
		String sheetName = method.getName();
		int rowCount = excel.getRowCount(sheetName);
		int columnCount = excel.getColumnCount(sheetName);

		/*
		 * We are using rowCount-1 as the first row in the excel will be header.
		 * We are using number of columns as 1 because we will be using
		 * Hashtable.
		 */
		Object[][] data = new Object[rowCount - 1][1];
		Hashtable<String, String> table = null;

		/* Creating one hashtable for each data row */
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			table = new Hashtable<>();
			for (int cellNum = 0; cellNum < columnCount; cellNum++) {
				table.put(excel.getCellData(sheetName, cellNum, 1), excel.getCellData(sheetName, cellNum, rowNum));
				appLogs.debug("Hashtable-->" + table);
				data[rowNum - 2][0] = table;
			}
		}

		appLogs.debug("Data-->" + data);
		return data;
	}

	/**
	 * Gets the datas.
	 *
	 * @param m
	 *            the m
	 * @return the datas
	 */
	/*
	 * Use this dataprovider when we have all test cases and test data in one
	 * excel sheet.
	 */
	@DataProvider(name = "dpone")
	public Object[][] getDatas(Method m) {

		/* Finding the sheet based on environment */

		String env = configProperty.getProperty("server").toUpperCase();
		switch (env) {
		case "PROD":
			testSheetName = configProperty.getProperty("prodTestSheetName");
			break;
		case "STAGE":
			testSheetName = configProperty.getProperty("stageTestSheetName");
			break;
		case "UAT":
			testSheetName = configProperty.getProperty("uatTestSheetName");
			break;
		case "QA":
			testSheetName = configProperty.getProperty("qaTestSheetName");
			break;
		default:
			break;
		}

		/* Number of rows in the excel sheet */
		int rows = excel.getRowCount(testSheetName);
		appLogs.debug("Total rows are : " + rows);

		/* Name of test case */
		String testName = m.getName();

		/* Find the test case start row */
		int testCaseRowNum = 1;
		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
			String testCaseName = excel.getCellData(testSheetName, 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName))
				break;
		}
		appLogs.debug("Test case starts from row num: " + testCaseRowNum);

		/* Checking total rows in test case */
		int dataStartRowNum = testCaseRowNum + 2;
		int testRows = 0;
		while (!excel.getCellData(testSheetName, 0, dataStartRowNum + testRows).equals("")) {
			testRows++;
		}
		appLogs.debug("Total rows of data are : " + testRows);

		/* Checking total columns in test case */
		int colStartColNum = testCaseRowNum + 1;
		int testCols = 0;
		while (!excel.getCellData(testSheetName, testCols, colStartColNum).equals("")) {
			testCols++;
		}
		appLogs.debug("Total cols are : " + testCols);

		/* Returning data */
		Object[][] data = new Object[testRows][1];
		int i = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {
			Hashtable<String, String> table = new Hashtable<>();
			for (int cNum = 0; cNum < testCols; cNum++) {
				String colName = excel.getCellData(testSheetName, cNum, colStartColNum);
				String testData = excel.getCellData(testSheetName, cNum, rNum);
				table.put(colName, testData);
			}
			data[i][0] = table;
			i++;
		}
		return data;
	}

	/**
	 * Capture screenshot.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	/* Capture Screenshot */
	public static final void captureScreenshot() throws IOException {
		screenshotPath = System.getProperty("user.dir") + "/Screenshots/";
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		/* This is used for Extent report */
		FileUtils.copyFile(scrFile, new File(screenshotPath + screenshotName));
	}

	/**
	 * Move Extent reports, Emailable reports, ReportNG reports to archive
	 * folder.
	 */
	public static void moveReportsToArchiveFolder() {

		String newFileName = "ExtentReport_";
		String emailableReport = "EmailableReport_";

		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timeStamp = f.format(new Date());

		newFileName = newFileName + timeStamp + ".html";
		emailableReport = emailableReport + timeStamp + ".html";

		File file = new File("./extentreport.html");
		File emailReport = new File(System.getProperty("user.dir") + "/target/surefire-reports/emailable-report.html");

		if (file.renameTo(new File("./src/test/resources/archivedReports/archivedExtentReports/" + newFileName))) {
			appLogs.debug("Extent report has been moved");
		} else {
			appLogs.debug("Extent report is not moved");
		}

		if (emailReport.renameTo(
				new File("./src/test/resources/archivedReports/archivedEmailableReports/" + emailableReport))) {
			appLogs.debug("Emailable report has been moved");
		} else {
			appLogs.debug("Emailable report is not moved");
		}

		String source = System.getProperty("user.dir") + "/target/surefire-reports/html";
		File srcDir = new File(source);

		String destination = System.getProperty("user.dir")
				+ "/src/test/resources/archivedReports/archivedReportNGReports/";
		String reportNGDestination = destination + "/ReportNG_" + timeStamp + "/";
		File destDir = new File(reportNGDestination);
		try {
			// Move the source directory to the destination directory.
			// The destination directory must not exists prior to the
			// move process.
			FileUtils.moveDirectory(srcDir, destDir);
			appLogs.debug("ReportNG report has been moved");
		} catch (IOException e) {
			appLogs.debug("ReportNG report has not been moved");
		}
	}

	/* Delete the old video recording of the test cases */
	public static void deleteVideos(String path) {
		File directory = new File(path);
		File[] files = directory.listFiles();
		for (File file : files) {
			file.delete();
		}
	}

}