/**
 ******************************************************************************
 * 							  	TADIGITAL
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.testutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * The Class DriverManager.
 */
public class DriverManager {

	/**
	 * Instantiates a new driver manager.
	 */
	private DriverManager() {
	}

	/** The driver. */
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/**
	 * This method is for getDriver.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return DriverManager.driver.get();
	}

	/**
	 * This method is for setDriver.
	 *
	 * @param driver
	 *            the new driver
	 */
	public static void setDriver(WebDriver driver) {
		DriverManager.driver.set(driver);
	}

	/**
	 * This method is for maximizing the browser.
	 *
	 * @param driver
	 *            the driver
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is for setting implicit wait.
	 *
	 * @param driver
	 *            the new implicit wait
	 */
	public static void setImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Page load timeout.
	 *
	 * @param driver
	 *            the driver
	 */
	public static void pageLoadTimeout(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
}
