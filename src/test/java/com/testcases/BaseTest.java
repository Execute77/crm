package com.testcases;

import com.utilities.ConfigFactory;
import com.utilities.ConfigProvider;
import com.utilities.DriverFactory;
import com.utilities.TestDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    ConfigFactory config;

    @BeforeSuite
    public void initialSetup(){
        config = new ConfigFactory();
//       new TestDataProvider().getWorkbook();
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before test");
        driver = DriverFactory.getDriver(config.getBrowser(), config.getURL());
    }

    @AfterTest
    public void tearDown(){
        DriverFactory.quitBrowser(driver);
    }


//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("Before method driver is "+driver);
//    }
//
//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("After method driver is - "+driver);
//    }
}
