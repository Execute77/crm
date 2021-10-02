package com.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    ConfigFactory config;
    ExtentReports report;
    ExtentTest logger;

    @BeforeSuite
    public void initialSetup(){
        config = new ConfigFactory();
//       new TestDataProvider().getWorkbook();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/testReport.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
        driver = DriverFactory.getDriver(config.getBrowser(), config.getURL());
    }

    @AfterTest
    public void tearDown(){
        //DriverFactory.quitBrowser(driver);
    }


//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("Before method driver is "+driver);
//    }

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