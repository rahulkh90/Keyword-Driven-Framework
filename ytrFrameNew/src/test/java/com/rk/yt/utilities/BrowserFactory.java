package com.rk.yt.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {



	public static WebDriver launch(WebDriver driver, String Browser, String Url)
			throws IOException, InterruptedException {

		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(Url);
		driver.manage().window().maximize();
		// wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(prop.getProperty("signinbutt"))))));
		// driver.findElement(By.xpath(prop.getProperty("signinbutt"))).click();

		// driver.findElement(By.xpath(prop.getProperty("nxtlog"))))

		return driver;
	}

	

		// Thread.sleep(5000);

	

	public static void quitBrowser(WebDriver driver) {
		driver.close();
	}

}
