package com.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException, IOException {

        logger = report.createTest("Login Test");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login();

        Thread.sleep(4000);
//        loginPage.takeScreenshot();

        logger.pass("The title verified");

        Assert.assertEquals(loginPage.getTitle(), "Cogmento CRM");
    }

}
