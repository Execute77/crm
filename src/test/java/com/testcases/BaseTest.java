package com.testcases;

import com.utilities.ConfigFactory;
import com.utilities.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    static ExtentReports report;
    static ExtentTest logger;
    static WebDriver driver;
    static ConfigFactory config;

    @BeforeSuite
    public void initialSetup(){

        System.out.println("The browser from maven is - "+System.getProperty("browserFromMaven"));
        System.out.println("The url from maven is - "+System.getProperty("urlToBeTested"));

        config = new ConfigFactory();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/testReport.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
        driver = DriverFactory.getDriver(config.getBrowser());

    }

//    @BeforeMethod
//    public void setUp() {
//        System.out.println("Before Method");;
//        driver = DriverFactory.getDriver(config.getBrowser());
//
//    }

    @AfterTest
    public void tearDown() {
        DriverFactory.quitBrowser(driver);
    }


    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            new SeleniumHelper(driver).takeScreenshot();
            logger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("usr.dir")+"/screenshots/test.png").build());
        }
        report.flush();
    }
}