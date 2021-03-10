/**
 * 
 */
package org.TA.TANFR.accessibility;

import org.TA.TANFR.pageobjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * @author Prabhudatta.C
 *
 */
@SuppressWarnings("rawtypes")
public class LoginPage extends BasePage {

	@FindBy(id = "txtUsername")
	private WebElement username;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(id = "btnLogin")
	private WebElement loginBtn;

	@FindBy(id = "welcome")
	private WebElement welcomeMSg;

	@SuppressWarnings("unchecked")
	public LoginPage getLoginPage() {

		return (LoginPage) openPage(LoginPage.class);
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

	public void login(String userName, String pwd) {

		sendKeys(username, userName, "Username");
		sendKeys(password, pwd, "password");
		jsClick(loginBtn, "Login");
		clickAction(loginBtn, "Login");

	}

}
