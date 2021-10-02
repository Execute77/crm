package com.testcases;

import com.utilities.ConfigFactory;
import com.utilities.ConfigProvider;
import com.utilities.DriverFactory;
import com.utilities.TestDataProvider;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    static WebDriver driver;
    static ConfigFactory config;
    static XSSFWorkbook testData;

    @BeforeSuite
    public void initialSetup() {
        config = new ConfigFactory();
//        driver = DriverFactory.getDriver(config.getBrowser(), config.getURL());
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before test");
        driver = DriverFactory.getDriver(config.getBrowser(), config.getURL());
//        driver = DriverFactory.getDriver(config.getBrowser(), config.getURL());
    }

//    @AfterTest
//    public void tearDown() {
//        DriverFactory.quitBrowser(driver);
//    }


//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("Before method driver is "+driver);
//    }
//
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method driver is - "+driver);
        DriverFactory.quitBrowser(driver);
    }
}
