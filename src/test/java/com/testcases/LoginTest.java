package com.testcases;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {

        driver.get("https://freecrm.com/");
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickLogin();
        loginPage.login();

        Thread.sleep(4000);

        System.out.println("The page title is " + driver.getTitle());
    }

    @Test
    public void sample1(){
        System.out.println("The message 1");
    }
}
