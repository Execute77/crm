package com.pages;

import com.utilities.SeleniumHelper;
import com.utilities.TestDataProvider;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends SeleniumHelper {

    TestDataProvider testDataProvider = new TestDataProvider();

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[contains(@class, 'submit button')]")
    private WebElement submitButton;


    LoginPage(WebDriver lDriver) {
        super(lDriver);
        driver = lDriver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        enterText(email, testDataProvider.getStringData("Login", 0,0));
        enterText(password, testDataProvider.getStringData("Login", 0,1));
        click(submitButton);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
