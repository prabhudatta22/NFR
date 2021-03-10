/**
 ******************************************************************************
 * 							  	TADIGITAL
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.testutils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.TA.TANFR.setup.TestSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * A factory for creating Driver objects.
 */
public class DriverFactory {

	static String targetUrl = "";
	static DesiredCapabilities caps = null;

	/**
	 * Instantiates a new driver factory.
	 */
	private DriverFactory() {
	}

	/**
	 * This method is to create a driver instance for what is configured in
	 * configuration file.
	 *
	 * @param browserName
	 *            the browser name
	 * @return the web driver
	 * @throws MalformedURLException
	 */
	public static WebDriver createDriverInstance(String browserName) throws MalformedURLException {
		WebDriver driver = null;
		@SuppressWarnings("unused")
		String portNo = "5555";
		String downloadFilepath = System.getProperty("user.dir") + "/Download";

		if (browserName.equalsIgnoreCase("firefox")) {

			FirefoxProfile profile = new FirefoxProfile();
			profile.setAssumeUntrustedCertificateIssuer(false);

			// Download setting
			profile.setPreference("browser.download.folderlist", 2);
			profile.setPreference("browser.helperapps.neverAsk.saveToDisk", "jpeg");
			profile.setPreference("browser.download.dir", downloadFilepath);

			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);

			caps = DesiredCapabilities.firefox();
			caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/SeleniumGRID/geckodriver.exe");
			System.out.println(System.getProperty("user.dir") + "/SeleniumGRID");
			caps = DesiredCapabilities.firefox();
			// caps.setCapability("binary", Constants.firefoxInstallation);
			caps.setBrowserName("FireFox");
			caps.setCapability("marionette", true);

			WebDriverManager.firefoxdriver().setup();
			portNo = "5555";

		} else if (browserName.equalsIgnoreCase("chrome")) {

			caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
			caps.setCapability("disable-popup-blocking", true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			// caps.setCapability("chrome.prefs", chromePrefs);
			caps.setCapability("chrome.setProxyByServer", false);
			caps.setCapability("Connnection", "keep-alive");
			// caps.setCapability(ChromeOptions.CAPABILITY, options);
			WebDriverManager.chromedriver().setup();

			portNo = "5566";
		} else if (browserName.equalsIgnoreCase("ie")) {
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			portNo = "5577";

		}

		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/MicrosoftWebDriver.exe");
			portNo = "5588";

			caps = DesiredCapabilities.edge();
			caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		}

		targetUrl = TestSetUp.configProperty.getProperty("Selenium_GRID_URL");// Constants.GRID_URL;

		System.out.println("Test is running in zalenium node >> " + targetUrl);
		driver = new RemoteWebDriver(new URL(targetUrl), caps);
		DriverManager.setDriver(driver);
		DriverManager.maximizeBrowser(driver);
		DriverManager.pageLoadTimeout(driver);
		DriverManager.setImplicitWait(driver);
		System.out.println("Driver created " + driver);

		/**
		 * Additional execution environments can be added here.
		 */
		return DriverManager.getDriver();
	}

	/**
	 * This method is to kill the driver.
	 */
	public static void destroyDriver() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
		}
	}
}
