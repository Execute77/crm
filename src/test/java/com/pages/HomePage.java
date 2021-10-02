package com.pages;

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

    public HomePage(WebDriver lDriver){
        try {
            driver = lDriver;
            driver.get("https://freecrm.com/");
        }catch (NoSuchSessionException e){
            driver = DriverFactory.createDriver();
            driver.get("https://freecrm.com/");
        }
        PageFactory.initElements(driver, this);


    }

    public LoginPage clickLogin(){
        loginLink.click();
        return new LoginPage(driver);
    }

}
