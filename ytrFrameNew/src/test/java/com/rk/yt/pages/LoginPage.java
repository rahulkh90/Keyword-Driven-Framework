package com.rk.yt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rk.yt.utilities.Helper;

public class LoginPage extends TestBase{
	
	//WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//div[@id='buttons']/ytd-button-renderer/a/paper-button")
	WebElement signinbutt;

	@FindBy(name = "identifier")
	WebElement uname;

	@FindBy(xpath = "//span[contains(text(), 'Next')]")
	WebElement nxtuser;

	@FindBy(name = "password")
	WebElement pword;

	@FindBy(xpath = "//span[@class='CwaK9']/span")
	WebElement nxtlog;

	public void login(String username, String password) {

		Helper.waitForElementClickable(driver, signinbutt);
		uname.sendKeys(username);
		nxtuser.click();
		//pword.sendKeys(password);
		Helper.waitForElementVisibility(driver, pword).sendKeys(password);
		Helper.handleStale(driver, nxtlog);

	}

}
