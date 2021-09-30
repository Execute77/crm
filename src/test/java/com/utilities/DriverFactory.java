package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String url) {

        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/vijaykumarb/Documents/Products/ACM2/ACM2.0/ChromeDriver/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {

        } else if (browserName.equals("IE")) {

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://freecrm.com/");

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }

}
