package com.rk.yt.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.rk.yt.utilities.BrowserFactory;
import com.rk.yt.utilities.ConfigDataProvider;
import com.rk.yt.utilities.ExcelDataProvider;
import com.rk.yt.utilities.Helper;
import com.rk.yt.utilities.Logs;

public class TestBase {

	public static WebDriver driver;

	public ExcelDataProvider ep;
	public ConfigDataProvider cd;
	public ExtentReports report;
	public ExtentTest logger;
	public SoftAssert sa;
	public Logs lo;

	@BeforeSuite
	public void setUpSuite() {
		sa= new SoftAssert();
		ep = new ExcelDataProvider();
		cd = new ConfigDataProvider();
		lo= new Logs();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "./Reports/Report_" + Helper.getCurrentDateTime() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);

	}

	@BeforeTest
	public void setUp() {
		try {
			driver = BrowserFactory.launch(driver, cd.getBrowser(), cd.getUrl());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);

	}

	@AfterMethod
	public void failCaptureScreen(ITestResult res) throws IOException {
		if (res.getStatus() == ITestResult.FAILURE) {
			// Helper.captureScreen(driver, res.getName());
			logger.fail("Test Failed", MediaEntityBuilder
					.createScreenCaptureFromPath(Helper.captureScreen(driver, res.getName())).build());
		} else if (res.getStatus() == ITestResult.SUCCESS) {
			// Helper.captureScreen(driver, res.getName());
			logger.pass("Test Passed", MediaEntityBuilder
					.createScreenCaptureFromPath(Helper.captureScreen(driver, res.getName())).build());
		}
		report.flush();
	}

}
