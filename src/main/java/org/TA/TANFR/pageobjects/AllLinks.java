package org.TA.TANFR.pageobjects;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.TA.TANFR.setup.TestSetUp;
import org.TA.TANFR.testutils.DriverManager;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllLinks extends TestSetUp {
	public AllLinks(WebDriver driver) {
		/*
		 * TestBase.driver = driver; PageFactory.initElements(driver, this);
		 */
	}

	public List<WebElement> getAllLinks() {
		List<WebElement> allLinks = DriverManager.getDriver().findElements(By.tagName("a"));
		int totalUrls = allLinks.size();
		System.out.println(totalUrls);
		int rowNum = 2;
		for (int i = 0; i < totalUrls; i++) {
			excel.setCellData("TestData", "AllLinks", rowNum + i, allLinks.get(i).getText());
			excel.setCellData("TestData", "hrefs", rowNum + i, allLinks.get(i).getAttribute("href"));
			excel.getCellData("TestData", "hrefs", rowNum + i);

		}

		return allLinks;

	}
	/*
	 * public String guidelineErrors() { int wcagListSize=wcagAAList.length;
	 * finList = new ArrayList<String>(); List<WebElement> allLinks =
	 * driver.findElements(By.tagName("h3")); int linkCnt = allLinks.size();
	 * System.out.println("total h3 tags :" +linkCnt); for(int
	 * l=0;l<linkCnt;l++) { String tagTxt =
	 * driver.findElements(By.tagName("h3")).get(l).getText(); for(int
	 * list=0;list<wcagListSize;list++) { String listVal = wcagAAList[list];
	 * try{ if(tagTxt.contains(listVal)) { finList.add(listVal);
	 * System.out.println("WCAG Guideline :" +tagTxt); } }catch(Exception e){
	 * System.out.println("Possible Error in List Value"); } } } return
	 * finList.toString(); } //Method to capture accessability categories public
	 * String wacCategories(String xpathStr) {
	 * 
	 * int ctA=0; int ctAA=0; int ctAAA=0;
	 * 
	 * //int wcagCatListSize=wcagAAList.length; //finList = new
	 * ArrayList<String>(); List<WebElement> catAllLinks =
	 * driver.findElements(By.tagName("h4")); int catLinkCnt =
	 * catAllLinks.size(); System.out.println("total h4 tags :" +catLinkCnt);
	 * 
	 * for(int ct=1;ct<=catLinkCnt;ct++) { String ctTagTxt=""; String
	 * xpathSt="//*[@id='"+xpathStr+"']/h4["+ct+"]"; try {
	 * ctTagTxt=DriverManager.getDriver().findElement(By.xpath(xpathSt)).getText
	 * (); //String ctTagTxt = catAllLinks.get(ct).getText();
	 * System.out.println(ctTagTxt); }catch(Exception e) {
	 * System.out.println("May be no xpath element"); }
	 * 
	 * try{ if(ctTagTxt.contains("(A)")) { ctA ++; } else
	 * if(ctTagTxt.contains("(AA)")) { ctAA ++; } else
	 * if(ctTagTxt.contains("(AAA)")) { ctAAA ++; } else { break; }
	 * }catch(Exception e) { System.out.println(); } } catAllLinks.clear();
	 * String totCts = ctA +"-A, " + ctAA + "-AA, " + ctAAA + "-AAA"; return
	 * totCts; } public void verifyAccessibilityURLs() throws
	 * InterruptedException {
	 * 
	 * Program loops through all the URL's in the Excel Sheet and input's them
	 * to accessibility tool one after the other try{ int
	 * totalRows=testDataXls.getRowCount("TestData");
	 * System.out.println("No of Rows: " +totalRows); for (int
	 * row=2;row<=totalRows;row++){ //String Title = null; resultsDisplay=false;
	 * 
	 * String urlContent=testDataXls.getCellData("TestData", "InputURL", row);
	 * System.out.println("URL is: " +urlContent);
	 * if(urlContent.contains("http")) {
	 * driver.findElement(By.id("checkuri")).clear();
	 * driver.findElement(By.id("checkuri")).sendKeys(urlContent);
	 * Thread.sleep(1000);
	 * 
	 * try{ driver.findElement(By.id("validate_uri")).click();
	 * Thread.sleep(500);
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(
	 * "spinner_export"))); }catch(Exception sp1) { sp1.printStackTrace();
	 * System.out.println("May be taking too long to gather WCAG information :"
	 * +sp1); } String knwProb =
	 * driver.findElement(By.id("AC_num_of_errors")).getText(); String
	 * likelyProb = driver.findElement(By.id("AC_num_of_likely")).getText();
	 * String potnProb =
	 * driver.findElement(By.id("AC_num_of_potential")).getText();
	 * 
	 * 
	 * driver.findElement(By.id("AC_num_of_errors")).click();
	 * Thread.sleep(1000); String knwPthSt="AC_errors"; String
	 * knwnCts=wacCategories(knwPthSt); String KnwnErrStr=guidelineErrors();
	 * 
	 * testDataXls.setCellData("TestData", "Known Problems", row,
	 * knwProb+" ("+knwnCts+")"); Thread.sleep(500);
	 * testDataXls.setCellData("TestData", "Known Problems Error Categories",
	 * row, KnwnErrStr); System.out.println(KnwnErrStr);
	 * 
	 * finList.removeAll(finList);
	 * 
	 * Thread.sleep(500); driver.findElement(By.id("AC_num_of_likely")).click();
	 * Thread.sleep(1000); String lklPthSt="AC_likely_problems"; String
	 * lklyCts=wacCategories(lklPthSt); String LiklyErrStr=guidelineErrors();
	 * 
	 * testDataXls.setCellData("TestData", "Likely Problems", row,
	 * likelyProb+" ("+lklyCts+")"); Thread.sleep(500);
	 * testDataXls.setCellData("TestData", "Likely Problems Error Categories",
	 * row, LiklyErrStr); System.out.println(LiklyErrStr);
	 * 
	 * finList.removeAll(finList);
	 * 
	 * Thread.sleep(500);
	 * driver.findElement(By.id("AC_num_of_potential")).click();
	 * Thread.sleep(1000); String ptnPthSt="AC_potential_problems"; String
	 * potnCts=wacCategories(ptnPthSt); String PotnErrStr=guidelineErrors();
	 * 
	 * testDataXls.setCellData("TestData", "Potential Problems", row,
	 * potnProb+" ("+potnCts+")"); Thread.sleep(500);
	 * testDataXls.setCellData("TestData",
	 * "Potential Problems Error Categories", row, PotnErrStr);
	 * System.out.println(PotnErrStr);
	 * 
	 * finList.removeAll(finList);
	 * 
	 * Thread.sleep(500);
	 * 
	 * WebElement exportList = driver.findElement(By.id("fileselect")); Select
	 * items= new Select(exportList);
	 * 
	 * items.selectByValue("pdf"); try{
	 * driver.findElement(By.id("validate_file_button")).click();
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(
	 * "spinner_export"))); }catch(Exception f1) { f1.printStackTrace();
	 * System.out.println("May be file download taking too long :" +f1); }
	 * 
	 * Thread.sleep(2000); }
	 * 
	 * else { System.out.println("Could be empty data or invalid input URL"); }
	 * } }catch(Exception e){ e.printStackTrace(); return; } //driver.quit();
	 * System.out.println("Execution Completed !!!"); }
	 */

	/**
	 * @param links
	 * @return
	 */
	public Set<String> getAllLinksSorted(List<WebElement> links) {

		Set<String> sortedLinks = new ConcurrentSkipListSet<>();
		for (WebElement link : links) {
			if (StringUtils.isNotBlank(link.getAttribute("href"))) {
				sortedLinks.add(link.getAttribute("href"));
			}
		}
		System.out.println("Final no of links found >> " + sortedLinks.size());
		return sortedLinks;
	}

	/**
	 * @param sortedLinks
	 * @return
	 */
	public Set<String> getSecuredLinks(Set<String> sortedLinks) {
		Set<String> securedLinks = new ConcurrentSkipListSet<>();
		for (String link : sortedLinks) {
			if (StringUtils.isNotBlank(link) && link.contains("https")) {
				securedLinks.add(link);
			}
		}
		System.out.println("Final no of secured links found >> " + securedLinks.size());
		return securedLinks;
	}

	/**
	 * @param sortedLinks
	 * @return
	 */
	public Set<String> getNonSecuredLinks(Set<String> sortedLinks) {
		Set<String> nonsecuredLinks = new ConcurrentSkipListSet<>();
		for (String link : sortedLinks) {
			if (!StringUtils.isNotBlank(link) && !link.contains("https")) {
				nonsecuredLinks.add(link);
			}
		}
		System.out.println("Final no of insecured links found >> " + nonsecuredLinks.size());
		return nonsecuredLinks;
	}

	public double getLoadTime(WebDriver driver) {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		return (Double) js.executeScript(
				"return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
	}

	public String getRequestCount(WebDriver driver) {
		String scriptToExecute = "var totalNoOfRequests = window.performance.getEntries().length; return totalNoOfRequests;";
		return ((JavascriptExecutor) driver).executeScript(scriptToExecute).toString();
	}

	public String getTransferedData(WebDriver driver) {
		String loadData = "document.performance.timing.loadEventEnd-performance.timing.navigationStart";
		return ((JavascriptExecutor) driver).executeScript(loadData).toString();

	}

}
