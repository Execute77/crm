package com.pages;

import com.utilities.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    TestDataProvider testDataProvider = new TestDataProvider();

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[contains(@class, 'submit button')]")
    private WebElement submitButton;

    LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        email.sendKeys(testDataProvider.getStringData("Login", 0,0));
        password.sendKeys(testDataProvider.getStringData("Login", 0,1));
        submitButton.click();
    }
}
