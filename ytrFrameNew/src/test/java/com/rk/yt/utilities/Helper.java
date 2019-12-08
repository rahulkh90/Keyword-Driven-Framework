package com.rk.yt.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class Helper {

	public static WebDriverWait wait;

	public static void handleStale(WebDriver driver, WebElement ele) {

		wait = new WebDriverWait(driver, 20);

		// boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
				// result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	public static void waitForElementClickable(WebDriver driver, WebElement ele) {

		wait = new WebDriverWait(driver, 20);

		// System.out.println("Wait-------------------------"+wait);

		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		;
	}

	public static WebElement waitForElementVisibility(WebDriver driver, WebElement ele) {
		wait = new WebDriverWait(driver, 20);
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		;
	}

	public String getEditText(WebDriver driver, WebElement ele) {
		return ele.getAttribute("value");
	}

	public static String captureScreen(WebDriver driver, String name) {
		String path = System.getProperty("user.dir") + "./ScreenShots/" + name + "_" + getCurrentDateTime() + ".jpg";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Screenshot not taken" + e.getMessage());
		}
		return path;
	}

	public static String getCurrentDateTime() {
		DateFormat form = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date d = new Date();
		return form.format(d);
	}
	
	@DataProvider(name= "data")
	public static Object getTestData(Method m) throws Exception {
		Object testObj=  ExcelWithDataPro.getTableArray(m.getName());
		return testObj;
	}

}
