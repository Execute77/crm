package com.testcases;

import com.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.out.println("Before test");
        driver =  DriverFactory.startApplication(driver, "Chrome", "https://freecrm.com/");
    }

    @AfterTest
    public void tearDown(){
        System.out.println("After test");
       // DriverFactory.quitBrowser(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method driver is "+driver);
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method driver is - "+driver);
    }
}
