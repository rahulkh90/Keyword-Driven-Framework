package com.rk.yt.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.rk.yt.utilities.ConfigDataProvider;
import com.rk.yt.utilities.ExcelDataProvider;

@Test
public class FlipKartCase1 {
	
	
	public static WebDriver driver;

	public static  ExcelDataProvider ep;
	public static ConfigDataProvider cd;
	
	public static void loginSearch() throws IOException, InterruptedException {
		
		 //driver = BrowserFactory.launch(driver, cd.getBrowser(), cd.getUrl());
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		 
		 driver.get("https://www.flipkart.com/");
		 WebElement log= driver.findElement(By.xpath(("//input[@class='_2zrpKA _1dBPDZ']")));
		 if(log.isEnabled()) {
			 log.sendKeys("8800337686");;
		 }
		 else
			 System.out.println("Not able to click");
		 driver.findElement(By.xpath("//input[@type='password' and @class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys("khurana@90");
		 driver.findElement(By.xpath("//button[@type='submit' and @class='_2AkmmA _1LctnI _7UHT_c']")).click();
		 
	}

}
