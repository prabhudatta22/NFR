package org.TA.TANFR.accessibility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.TA.TANFR.pageobjects.BasePage;
import org.TA.TANFR.pojo.AccesibilityPojo;
import org.TA.TANFR.pojo.CodeSniffer;
import org.TA.TANFR.setup.TestSetUp;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class AccessibilityScanner extends BasePage {

	@FindBy(xpath = "//*[@id='HTMLCS-settings-issue-count']/div[2]/div")
	private WebElement codeSnifferwarning;

	@FindBy(xpath = "//*[@id='HTMLCS-settings-issue-count']/div[1]/div")
	private WebElement errorCount;

	@FindBy(xpath = "//*[@id='HTMLCS-settings-issue-count']/div[3]/div")
	private WebElement notices;

	@FindBy(id = "HTMLCS-settings-view-report")
	private WebElement viewReport;

	@FindBy(id = "HTMLCS-issues")
	private WebElement issues;

	@FindBy(xpath = "//*[@id='HTMLCS-msg-0']/span[2]")
	private List<WebElement> issueTitle;

	private String summary = "//*[@id='HTMLCS-msg-detail-%d']/div[1]/div[1]";

	@FindBy(css = "#HTMLCS-settings-issue-count > div.HTMLCS-issue-tile.HTMLCS-error > label")
	private WebElement errorSlideBar;

	@FindBy(xpath = "//*[@id='HTMLCS-msg-detail-0']/div[1]/div[1]")
	private WebElement issueTitleText;

	private String criterion = "//*[@id='HTMLCS-msg-detail-%d']/div[1]/div[2]";

	private String codeSnippentText = "//*[@id='HTMLCS-msg-detail-%d']/div[2]/div[2]";

	@FindBy(xpath = "//*[@id='HTMLCS-issues-wrapper']/div[2]/span[2]")
	private WebElement pageNo;

	@FindBy(id = "HTMLCS-button-next-issue")
	private WebElement reportNextButton;

	// the below locators are for Site improve plugin

	/*
	 * @FindBy(id = "owuzh") private WebElement accessbility_issues;
	 * 
	 * @FindBy(css =
	 * "section > div.pane > div.pane-header > div.pull-left > div > button")
	 * private WebElement accessibility_backBtn;
	 * 
	 * @FindBy(className = "filter-toggle-title") private WebElement chooseFilter;
	 * 
	 * @FindBy(className = "radio") private List<WebElement> filtersBtns;
	 */

	@FindBy(className = "HTMLCS-checkbox-switch")
	private List<WebElement> vulnerabilityToggle;

	@FindBy(className = "HTMLCS-lineage-item")
	private List<WebElement> reportHeaderLink;

	private WebDriver driver;
	private JavascriptExecutor js;
	private Logger log = Logger.getLogger(AccessibilityScanner.class);
	private JsFactory jsFactory;

	public AccessibilityScanner(WebDriver driver) throws IOException {
		openPage(driver);
	}

	public void openPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		jsFactory = JsFactory.getInstance();
	}

	/*
	 * public Map<String, Object> runAccessibilityAudit(String url) {
	 * 
	 * Map<String, Object> audit_report = new HashMap<String, Object>(); String
	 * report = null; try { driver.manage().window().maximize();
	 * System.out.println(jsFactory.getAccessibility_content());
	 * js.executeScript(jsFactory.getAccessibility_content()); String
	 * accessibility_tests = "var auditConfig = new axs.AuditConfiguration(); " +
	 * "var results = axs.Audit.run(auditConfig);" +
	 * "var auditResults = axs.Audit.auditResults(results);" +
	 * "var report = axs.Audit.createReport(results);return report"; report =
	 * (String) js.executeScript(accessibility_tests);
	 * 
	 * log.info(report); TestSetUp.testCaseLogger.get().info(report);
	 * 
	 * log.info(js.executeScript("$.active;")); } catch (WebDriverException e) {
	 * TestSetUp.testCaseLogger.get().info("++++++++Injecting jQuery+++++++++++++");
	 * log.info("++++++++Injecting jQuery+++++++++++++"); js.executeScript(url); }
	 * 
	 * List<Result> errors = parseReport(report, "Error:"); List<Result> warnings =
	 * parseReport(report, "Warning:");
	 * 
	 * decorateElements(errors, "red"); decorateElements(warnings, "yellow"); final
	 * byte[] screenshot = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.BYTES); audit_report.put("Error", errors);
	 * audit_report.put("Warning", warnings); audit_report.put("screenshot",
	 * screenshot); audit_report.put("plain_report", report); return audit_report; }
	 */

	private void decorateElements(List<Result> results, String color) {
		for (Result result : results) {
			List<String> locators = result.getElements();
			addBorder(locators, result.getRule(), color);
		}
	}

	public List<Result> parseReport(String report, String filter_on) {
		if (filter_on.toLowerCase().contains("error"))
			filter_on = "Error:";
		else if (filter_on.toLowerCase().contains("warning"))
			filter_on = "Warning:";
		else
			throw new IllegalArgumentException("Currently only support filtering on Error: and Warning:");
		if (report == null)
			throw new NullPointerException("Report to parse cannot be null");
		List<Result> parsed_result = new ArrayList<Result>();
		int start_error = report.indexOf(filter_on);
		while (start_error > 0) {
			Result result = new Result();
			int end = report.indexOf("\n\n", start_error);
			String error = report.substring(start_error + filter_on.length(), end).trim();
			result.setRule(error.substring(0, error.indexOf("\n")));
			String link = null;
			String[] locators;
			int element_start = error.indexOf("\n") + 1;
			String element;
			if (error.indexOf("See") > 0) {
				element = error.substring(element_start, error.indexOf("See"));
				link = error.substring(error.indexOf("See"));
			} else {
				element = error.substring(element_start);
			}
			locators = element.split("\n");
			result.setElements(Arrays.asList(locators));
			result.setUrl(link);
			parsed_result.add(result);
			start_error = report.indexOf(filter_on, end);
		}
		return parsed_result;
	}

	private void addBorder(List<String> locators, String rule, String color) {
		for (String locator : locators) {
			rule = "<p>" + rule + "</p>";
			String script = "$(\"" + locator + "\").css(\"border\",\"5px solid " + color + "\")";
			js.executeScript(script);
		}
	}

	public static void click(int x, int y) throws AWTException {
		Robot bot = new Robot();
		bot.mouseMove(x, y);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	public AccesibilityPojo runHTMLCodeSniffer(String link) {

		AccesibilityPojo acs = new AccesibilityPojo();
		List<CodeSniffer> cdsList = new CopyOnWriteArrayList<>();

		log.info("Selecting technique WCAG2AA.");

		String[] category = TestSetUp.configProperty.getProperty("accessbilityCategory").split(",");

		try {
			((JavascriptExecutor) driver).executeScript(
					"javascript:(function() {var _p='//squizlabs.github.io/HTML_CodeSniffer/build/';var _i=function(s,cb) "
							+ "{var sc=document.createElement('script');sc.onload = function() {sc.onload = null;sc.onreadystatechange = null;"
							+ "cb.call(this);};sc.onreadystatechange = function(){if(/^(complete|loaded)$/.test(this.readyState) ===  true)"
							+ "{sc.onreadystatechange = null;sc.onload();}};sc.src=s;if (document.head) {document.head.appendChild(sc);} "
							+ "else {document.getElementsByTagName('head')[0].appendChild(sc);}}; "
							+ "var options={path:_p};_i(_p+'HTMLCS.js',function(){HTMLCSAuditor.run('WCAG2AA',null,options);});})();");

			int totalWarning = 0;

			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			totalWarning = Integer.parseInt(codeSnifferwarning.getText().split("\n")[0]);
			acs.setWarning_count(totalWarning);
			int totalError = Integer.parseInt(errorCount.getText().split("\n")[0]);
			acs.setError_count(totalError);

			cdsList.addAll(getCodeSnifferDetails("Error", totalError));
			cdsList.addAll(getCodeSnifferDetails("Warning", totalWarning));

			acs.setAllCodeSnifferDetails(cdsList);
		} catch (Exception e) {
			return acs;
		}
		return acs;
	}

	/**
	 * @param string
	 * @param totalWarning
	 * @return
	 */
	private List<CodeSniffer> getCodeSnifferDetails(String vulenrabilityType, int totalWarning) {

		String summ = "";
		String tech = "";
		String cs = "";
		List<CodeSniffer> cdsList = new CopyOnWriteArrayList<>();

		if (vulenrabilityType.equalsIgnoreCase("Error")) {

			vulnerabilityToggle.get(1).click();
		}
		if (vulenrabilityType.equalsIgnoreCase("Warning")) {

			vulnerabilityToggle.get(0).click();
		}

		viewReport.click();
		issueTitle.get(0).click();
		for (int i = 0; i < totalWarning; i++) {
			try {
				CodeSniffer cds = new CodeSniffer();

				if (issues.isDisplayed()) {

					summ = this.driver.findElement(By.xpath(this.summary.replace("%d", String.valueOf(i)))).getText();
					tech = this.driver.findElement(By.xpath(this.criterion.replace("%d", String.valueOf(i)))).getText();
					cs = this.driver.findElement(By.xpath(this.codeSnippentText.replace("%d", String.valueOf(i))))
							.getText();

				}

				cds.setError_text(tech);
				cds.setError_summary(summ);
				cds.setSuggested_tech(tech);
				cds.setCode_snippet(cs);
				cds.setCategory(vulenrabilityType);

				cdsList.add(cds);

				if (reportNextButton.isEnabled()) {
					reportNextButton.click();
				}
				summ = null;
				tech = null;
				cs = null;
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				break;
			}
			PageFactory.initElements(driver, this);
		}
		((JavascriptExecutor) driver)
				.executeScript("javascript:(function() {var _p='//squizlabs.github.io/HTML_CodeSniffer/build/';"
						+ "var _i=function(s,cb) {var sc=document.createElement('script');sc.onload = function() {sc.onload = null;sc.onreadystatechange = null;cb.call(this);};"
						+ "sc.onreadystatechange = function(){if(/^(complete|loaded)$/.test(this.readyState) ===  true){sc.onreadystatechange = null;sc.onload();}};sc.src=s;"
						+ "if (document.head) {document.head.appendChild(sc);} "
						+ "else {document.getElementsByTagName('head')[0].appendChild(sc);}}; var options={path:_p};"
						+ "_i(_p+'HTMLCS.js',function(){HTMLCSAuditor.run('WCAG2AA',null,options);});})();");

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cdsList;
	}

	public void getPageLoadInfo() {
		String script = "var perfromance = window.performance || window.mozPerformance";
		this.js.executeScript(script);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.TA.TANFR.pageobjects.BasePage#getPageLoadCondition()
	 */
	@Override
	public ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
