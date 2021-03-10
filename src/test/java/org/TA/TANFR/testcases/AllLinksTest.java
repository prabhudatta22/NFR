package org.TA.TANFR.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.TA.TANFR.accessibility.AccessibilityScanner;
import org.TA.TANFR.accessibility.LoginPage;
import org.TA.TANFR.pageobjects.AllLinks;
import org.TA.TANFR.pojo.AccesibilityPojo;
import org.TA.TANFR.setup.TestSetUp;
import org.TA.TANFR.testutils.Constants;
import org.TA.TANFR.testutils.DriverManager;
import org.TA.TANFR.testutils.ExcelReader;
import org.TA.TANFR.testutils.HTMLUpdateReport;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import oeg.TA.TANFR.Sonar.SonarIssues;
import oeg.TA.TANFR.Sonar.SonarMapPojo;

public class AllLinksTest extends TestSetUp {

	int i = 0;

	@Test()
	public void getAllLinksTest() throws IOException, AWTException {
		AllLinks allLinks = new AllLinks(DriverManager.getDriver());
		String url = (TestSetUp.applicationUderTest == null ? configProperty.getProperty("url")
				: TestSetUp.applicationUderTest);
		System.out.println("url under test is >> " + url);
		DriverManager.getDriver().navigate().to(url);
		Map<String, Object> audit_report = new ConcurrentHashMap<>();
		AccesibilityPojo acspojo = null;
		LoginPage loginp = new LoginPage().getLoginPage();
		// loginp.login("techadmin", "TechAspectTiBa&$1234");

		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<WebElement> links = allLinks.getAllLinks();

		Set<String> sortedLinks = allLinks.getAllLinksSorted(links);

		Set<String> securedLinks = allLinks.getSecuredLinks(sortedLinks);

		Set<String> nonsecuredLinks = allLinks.getNonSecuredLinks(sortedLinks);

		AccessibilityScanner acs = new AccessibilityScanner(DriverManager.getDriver());

		String timestamp = getTimeStamp();
		String fileName = System.getProperty(Constants.ROOT_DIR) + "/Reports/" + timestamp + "_NFR_Report.xlsx";
		String[] column = { "URL", "Error Element", "Rule Against Error", "Warning Element", "Rule Against Warning" };
		String[] columns = { "URL", "Error Summary", "Code snippet", "Suggested Tecchniques" };
		String[] columnsonar = { "Severity", "Violation Type", "Violation Details", " Component ", " line No " };
		String[] columnurl = { "Urls" };

		if (configProperty.getProperty("ExcelReport").equalsIgnoreCase("Yes")) {

			excelWriter = new ExcelReader(fileName, "Accessbility Report");
			excelWriter.createSheetColumn(columns, "Accessbility Report", fileName);

			// excelWriter = new ExcelReader(fileName, "Vulenrability Report");
			// excelWriter.createSheetColumn(columns, "Vulenrability Report", fileName);

			excelWriter = new ExcelReader(fileName, "Sonar Analysis Report");
			excelWriter.createSheetColumn(columnsonar, "Sonar Analysis Report", fileName);

			excelWriter = new ExcelReader(fileName, "InSeccured URLs");
			excelWriter.createSheetColumn(columnurl, "InSeccured URLs", fileName);
			excelWriter.writeToReport(columnurl, "InSeccured URLs", nonsecuredLinks, fileName);

		}

		String modules[] = configProperty.get("verificationModule").toString().split(",");

		for (String link : securedLinks) {
			for (String module : modules) {
				if (link.contains(module)) {
					i++;
					if (i == 2) {
						break;

					}
					System.out.println("Link covered under test >>> " + link);
					DriverManager.getDriver().get(link);
					// acs.runSiteImprove(link);
					/*
					 * try { if (link.contains("http")) { try { audit_report =
					 * acs.runAccessibilityAudit(link); System.out.println(audit_report); if
					 * (configProperty.getProperty("ExcelReport").equalsIgnoreCase("Yes")) {
					 * excelWriter.writeAccessibilityReprot(column, "Accessbility Report",
					 * sortedLinks, audit_report, fileName); }
					 * 
					 * } catch (Exception e) { audit_report.put(link, e.getMessage());
					 * testCaseLogger.get().warning(e.getMessage());
					 * testCaseLogger.get().warning("Getting the above exception for the url >>" +
					 * link); }
					 * 
					 * } else { testCaseLogger.get()
					 * .info("Could not access the link as ts not having proper syntax " + link); }
					 * }
					 * 
					 * catch (Exception e) { e.printStackTrace(); continue; }
					 */ new AccessibilityScanner(DriverManager.getDriver());
					acspojo = acs.runHTMLCodeSniffer(link);
					acspojo.setUrl(link);
					if (configProperty.getProperty("ExcelReport").equalsIgnoreCase("Yes")) {
						excelWriter.writeToReprot(columns, "Vulenrability Report", acspojo, fileName);
					}
				}
			}
			break;
		}

		List<SonarMapPojo> snmp = null;
		if (configProperty.get("Sonarvalidation").toString().equalsIgnoreCase("Yes")) {
			SonarIssues app = new SonarIssues();
			List<Map> jso = app.getAllIssues();
			snmp = app.processAllIssues(jso);
			app.writeToNotePad(snmp);
			if (configProperty.getProperty("ExcelReport").equalsIgnoreCase("Yes")) {
				excelWriter.writeSonarReprot(columnsonar, "Sonar Analysis Report", snmp, fileName);
			}
		}

		HTMLUpdateReport ureport = new HTMLUpdateReport();
		ureport.createHTMLReport(snmp, sortedLinks, audit_report, acspojo);
		DriverManager.getDriver().quit();
	}

}
