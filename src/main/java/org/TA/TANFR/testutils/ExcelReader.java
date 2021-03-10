/**
 ******************************************************************************
 * 							  	TADIGITAL
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.TA.TANFR.accessibility.Result;
import org.TA.TANFR.pojo.AccesibilityPojo;
import org.TA.TANFR.pojo.CodeSniffer;
import org.TA.TANFR.setup.TestSetUp;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import oeg.TA.TANFR.Sonar.SonarMapPojo;

/**
 * The Class ExcelReader.
 */
public class ExcelReader {

	/** The path. */
	public String path;

	/** The fis. */
	public FileInputStream fis = null;

	/** The file out. */
	public FileOutputStream fileOut = null;

	/** The workbook. */
	private XSSFWorkbook workbook = null;

	/** The sheet. */
	private XSSFSheet sheet = null;

	/** The row. */
	private XSSFRow row = null;

	/** The cell. */
	private XSSFCell cell = null;

	public ExcelReader(String path, String sheetName) {

		try {

			try {

				fis = new FileInputStream(new File(path));
				workbook = new XSSFWorkbook(fis);
			} catch (FileNotFoundException fe) {
				workbook = new XSSFWorkbook(path);
			}

			boolean isSheetPresent = false;
			int totalsheets = workbook.getNumberOfSheets();

			for (int i = 0; i < totalsheets; i++) {
				if (sheetName.equalsIgnoreCase(workbook.getSheetName(i))) {
					isSheetPresent = true;
					sheet = workbook.getSheetAt(i);
				}
			}

			if (!isSheetPresent) {
				sheet = workbook.createSheet(sheetName);
			}
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			TestSetUp.appLogs.debug(ex);
		}
	}

	/**
	 * Instantiates a new excel reader.
	 *
	 * @param path
	 *            the path
	 */
	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(new File(path));
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception ex) {
			TestSetUp.appLogs.debug(ex);
		}
	}

	/**
	 * Gets the row count.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @return the row count
	 */
	// returns the row count in a sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			return sheet.getLastRowNum() + 1;
		}
	}

	/**
	 * Gets the cell data.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colName
	 *            the col name
	 * @param rowNum
	 *            the row num
	 * @return the cell data
	 */
	// returns the data from a cell
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					colNum = i;
			}
			if (colNum == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					double d = cell.getNumericCellValue();
					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
				}
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception exc) {
			TestSetUp.appLogs.debug(exc);
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	/**
	 * Gets the cell data.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colNum
	 *            the col num
	 * @param rowNum
	 *            the row num
	 * @return the cell data
	 */
	// returns the data from a cell
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();
					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
				}
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			TestSetUp.appLogs.debug(e);
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	/**
	 * Sets the cell data.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colName
	 *            the col name
	 * @param rowNum
	 *            the row num
	 * @param data
	 *            the data
	 * @return true, if successful
	 */
	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			if (rowNum <= 0)
				return false;
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);

			System.out.println(cell.getStringCellValue());
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception exep) {
			TestSetUp.appLogs.debug(exep);
			return false;
		}
		return true;
	}

	/**
	 * Sets the cell data.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colName
	 *            the col name
	 * @param rowNum
	 *            the row num
	 * @param data
	 *            the data
	 * @param url
	 *            the url
	 * @return true, if successful
	 */
	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url) {

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			if (rowNum <= 0)
				return false;
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			XSSFCreationHelper createHelper = workbook.getCreationHelper();
			// cell style for hyperlinks
			CellStyle hlinkStyle = workbook.createCellStyle();
			XSSFFont hlinkFont = workbook.createFont();
			hlinkFont.setUnderline(XSSFFont.U_SINGLE);
			hlinkFont.setColor(IndexedColors.BLUE.getIndex());
			hlinkStyle.setFont(hlinkFont);
			XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
			link.setAddress(url);
			cell.setHyperlink(link);
			cell.setCellStyle(hlinkStyle);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception exept) {
			TestSetUp.appLogs.debug(exept);
			return false;
		}
		return true;
	}

	/**
	 * Adds the sheet.
	 *
	 * @param sheetname
	 *            the sheetname
	 * @return true, if successful
	 */
	// returns true if sheet is created successfully else false
	public boolean addSheet(String sheetname) {
		try {
			workbook.createSheet(sheetname);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			TestSetUp.appLogs.debug(e);
			return false;
		}
		return true;
	}

	// returns true if sheet is removed successfully else false if sheet does
	/**
	 * Removes the sheet.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @return true, if successful
	 */
	// not exist
	public boolean removeSheet(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return false;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			TestSetUp.appLogs.debug(e);
			return false;
		}
		return true;
	}

	/**
	 * Adds the column.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colName
	 *            the col name
	 * @return true, if successful
	 */
	// returns true if column is created successfully
	public boolean addColumn(String sheetName, String colName) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return false;
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);
			if (row.getFirstCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());
			cell.setCellValue(colName);
			cell.setCellStyle(style);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception err) {
			TestSetUp.appLogs.debug(err);
			return false;
		}
		return true;
	}

	/**
	 * Removes the column.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colNum
	 *            the col num
	 * @return true, if successful
	 */
	// removes a column and all the contents
	public boolean removeColumn(String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName))
				return false;
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			workbook.getCreationHelper();
			style.setFillPattern(HSSFCellStyle.NO_FILL);
			for (int i = 0; i < getRowCount(sheetName); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = row.getCell(colNum);
					if (cell != null) {
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception exeption) {
			TestSetUp.appLogs.debug(exeption);
			return false;
		}
		return true;
	}

	/**
	 * Checks if is sheet exist.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @return true, if is sheet exist
	 */
	// find whether sheets exists
	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	/**
	 * Gets the column count.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @return the column count
	 */
	// returns number of columns in a sheet
	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		if (row == null)
			return -1;
		return row.getLastCellNum();

	}

	// String sheetName, String testCaseName,String keyword ,String URL,String
	/**
	 * Adds the hyper link.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param screenShotColName
	 *            the screen shot col name
	 * @param testCaseName
	 *            the test case name
	 * @param index
	 *            the index
	 * @param url
	 *            the url
	 * @param message
	 *            the message
	 * @return true, if successful
	 */
	// message
	public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url,
			String message) {
		url = url.replace('\\', '/');
		if (!isSheetExist(sheetName))
			return false;
		sheet = workbook.getSheet(sheetName);
		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)) {
				setCellData(sheetName, screenShotColName, i + index, message, url);
				break;
			}
		}
		return true;
	}

	/**
	 * Gets the cell row num.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colName
	 *            the col name
	 * @param cellValue
	 *            the cell value
	 * @return the cell row num
	 */
	public int getCellRowNum(String sheetName, String colName, String cellValue) {
		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;
	}

	public void addColumns(String path, String sheetName, String colName) {

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception fe) {
			workbook = new XSSFWorkbook();
		}

		int totalsheets = workbook.getNumberOfSheets();

		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		boolean sheetpresented = false;
		for (int i = 0; i < totalsheets; i++) {
			if (sheetName.equalsIgnoreCase(workbook.getSheetName(i))) {
				sheetpresented = true;
				sheet = workbook.getSheetAt(i);
			}
		}

		if (!sheetpresented) {
			sheet = workbook.createSheet(sheetName);
		}

		XSSFCell cell = null;
		XSSFRow row = sheet.getRow(0);

		if (row == null)
			row = sheet.createRow(0);
		if (row.getFirstCellNum() == -1)
			cell = row.createCell(0);
		else
			cell = row.createCell(row.getLastCellNum());

		cell.setCellValue(colName);
		cell.setCellStyle(style);
		System.out.println(row.getCell(0).getStringCellValue());
	}

	/**
	 * Sets the cell data.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colName
	 *            the col name
	 * @param rowNum
	 *            the row num
	 * @param data
	 *            the data
	 * @return true, if successful
	 */
	// returns true if data is set successfully else false
	public boolean setCellsData(String path, String sheetName, String colName, int rowNum, String data) {
		try {
			try {
				fis = new FileInputStream(path);
				workbook = new XSSFWorkbook(fis);
			} catch (Exception fe) {
				workbook = new XSSFWorkbook();
			}

			if (rowNum <= 0)
				return false;
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);

			if (row == null)
				row = sheet.createRow(0);
			if (row.getFirstCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());

			cell.setCellValue(colName);
			cell.setCellValue(data);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				colNum = i;
			}
			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);

			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception exep) {
			TestSetUp.appLogs.debug(exep);
			return false;
		}
		return true;
	}

	public void createSheetColumn(String[] columns, String sheetName, String filename) {
		try {
			fis = new FileInputStream(filename);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception fe) {
			workbook = new XSSFWorkbook();
		}
		boolean isSheetPresent = false;
		int totalsheets = workbook.getNumberOfSheets();

		for (int i = 0; i < totalsheets; i++) {
			if (sheetName.equalsIgnoreCase(workbook.getSheetName(i))) {
				isSheetPresent = true;
				sheet = workbook.getSheetAt(i);
			}
		}

		if (!isSheetPresent) {
			sheet = workbook.createSheet(sheetName);
		}

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToReprot(String[] columns, String sheetName, AccesibilityPojo acspojo, String filename) {
		int rowNum = 1;

		try {
			fis = new FileInputStream(filename);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception fe) {
			workbook = new XSSFWorkbook();
		}
		boolean isSheetPresent = false;
		int totalsheets = workbook.getNumberOfSheets();

		for (int i = 0; i < totalsheets; i++) {
			if (sheetName.equalsIgnoreCase(workbook.getSheetName(i))) {
				isSheetPresent = true;
				sheet = workbook.getSheetAt(i);
			}
		}

		if (!isSheetPresent) {
			sheet = workbook.createSheet(sheetName);
		}

		if ((acspojo != null)) {

			if (!(acspojo.getAllCodeSnifferDetails().isEmpty())) {
				for (CodeSniffer cd : acspojo.getAllCodeSnifferDetails()) {

					Row row = sheet.createRow(rowNum++);

					row.createCell(0).setCellValue(acspojo.getUrl());

					row.createCell(1).setCellValue(cd.getError_summary());

					row.createCell(2).setCellValue(cd.getCode_snippet());

					row.createCell(3).setCellValue(cd.getSuggested_tech());
				}
			}
		}
		// Resize all columns to fit the content size
		for (

				int i = 1; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "unused" })
	public void writeAccessibilityReprot(String[] columns, String sheetName, Set<String> sortedLinks,
			Map<String, Object> audit_report, String filename) {

		try {
			fis = new FileInputStream(filename);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception fe) {
			workbook = new XSSFWorkbook();
		}
		boolean isSheetPresent = false;
		int totalsheets = workbook.getNumberOfSheets();

		for (int i = 0; i < totalsheets; i++) {
			if (sheetName.equalsIgnoreCase(workbook.getSheetName(i))) {
				isSheetPresent = true;
				sheet = workbook.getSheetAt(i);
			}
		}

		if (!isSheetPresent) {
			sheet = workbook.createSheet(sheetName);
		}

		int rowNum = 1;

		for (String link : sortedLinks) {

			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(link);

			for (String key : audit_report.keySet()) {
				row = sheet.createRow(rowNum++);
				List<Result> result = (List<Result>) audit_report.get("Error");
				System.out.println(result.get(0).getElements().toString());
				System.out.println(result.get(0).getElements());
				row.createCell(1).setCellValue(result.get(0).getElements().toString());
				row.createCell(2).setCellValue(result.get(0).getRule().toString());
				result = (List<Result>) audit_report.get("Warning");
				row.createCell(3).setCellValue(result.get(0).getElements().toString());
				row.createCell(4).setCellValue(result.get(0).getRule().toString());

			}

		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeSonarReprot(String[] columnsonar, String sheetName, List<SonarMapPojo> snmp, String fileName) {

		try {
			fis = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception fe) {
			workbook = new XSSFWorkbook();
		}
		boolean isSheetPresent = false;
		int totalsheets = workbook.getNumberOfSheets();

		for (int i = 0; i < totalsheets; i++) {
			if (sheetName.equalsIgnoreCase(workbook.getSheetName(i))) {
				isSheetPresent = true;
				sheet = workbook.getSheetAt(i);
			}
		}

		if (!isSheetPresent) {
			sheet = workbook.createSheet(sheetName);
		}

		int rowNum = 1;

		for (SonarMapPojo sn : snmp) {

			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(sn.getSeverity());
			row = sheet.createRow(rowNum++);
			row.createCell(1).setCellValue(sn.getType());
			row.createCell(2).setCellValue(sn.getViolation_details().trim());
			row.createCell(3).setCellValue(sn.getComponent().trim());
			row.createCell(4).setCellValue(sn.getLineNo());

		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columnsonar.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(fileName);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param columnurl
	 * @param string
	 * @param nonsecuredLinks
	 * @param fileName
	 */
	public void writeToReport(String[] columnurl, String sheetName, Set<String> nonsecuredLinks, String fileName) {
		int rowNum = 1;
		try {
			fis = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception fe) {
			workbook = new XSSFWorkbook();
		}
		boolean isSheetPresent = false;
		int totalsheets = workbook.getNumberOfSheets();

		for (int i = 0; i < totalsheets; i++) {
			if (sheetName.equalsIgnoreCase(workbook.getSheetName(i))) {
				isSheetPresent = true;
				sheet = workbook.getSheetAt(i);
			}
		}

		if (!isSheetPresent) {
			sheet = workbook.createSheet(sheetName);
		}

		if (nonsecuredLinks != null) {

			for (String links : nonsecuredLinks) {

				Row row = sheet.createRow(rowNum++);
				System.out.println(links);
				row.createCell(0).setCellValue(links);
			}
		}
		// Resize all columns to fit the content size
		for (int i = 1; i < columnurl.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(fileName);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
