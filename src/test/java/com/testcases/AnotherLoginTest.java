package com.testcases;

import com.pages.HomePage;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnotherLoginTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {

        logger = report.createTest("Another Test");
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickLogin();
        loginPage.login();

        Thread.sleep(4000);

        Assert.assertEquals(loginPage.getTitle(), "Cogmento CRM");

    }

    @Test
    public void sample2(){
        System.out.println("The message 2");
    }
}
