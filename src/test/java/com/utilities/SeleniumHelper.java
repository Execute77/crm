package com.utilities;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class SeleniumHelper {

    public WebDriver driver;

    public SeleniumHelper(WebDriver driver){
        this.driver = driver;
    }

    public void click(WebElement element){
        element.click();
    }

    public void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public void takeScreenshot() throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File(new File(System.getProperty("user.dir"))+"/screenshots/test.png"));
    }

}
