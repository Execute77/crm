package com.testcases;

import com.utilities.ConfigFactory;
import com.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    static WebDriver driver;
    static ConfigFactory config;

    @BeforeSuite
    public void initialSetup() {
        config = new ConfigFactory();
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
}
