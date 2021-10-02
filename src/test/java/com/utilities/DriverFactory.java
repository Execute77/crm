package com.utilities;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static WebDriver driver;

    private static WebDriver startBrowser(String browserName) {

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/vijaykumarb/Documents/Products/ACM2/ACM2.0/ChromeDriver/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {

        } else if (browserName.equals("IE")) {

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }

    public static WebDriver getDriver(String browserName) {
        try {
            if (driver == null) {
                createDriver(browserName);
            }
            if (driver != null && driver.manage().getCookies() == null) ;
        } catch (NoSuchSessionException e) {
            createDriver(browserName);
        }
        return driver;
    }

    private static void createDriver(String browserName) {
        startBrowser(browserName);
    }

}
