package com.pages;

import com.utilities.ConfigFactory;
import com.utilities.DriverFactory;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[text() = 'Log In']")
    private WebElement loginLink;
    ConfigFactory configFactory = new ConfigFactory();

    public HomePage(WebDriver lDriver) {
        driver = lDriver;
        driver.get(configFactory.getURL());
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLogin() {
        loginLink.click();
        return new LoginPage(driver);
    }

}
