package com.testcases;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WithoutFrameworkLoginTest {

    @Test
    public void loginTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/vijaykumarb/Documents/Products/ACM2/ACM2.0/ChromeDriver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://freecrm.com/");

        driver.findElement(By.xpath("//*[text() = 'Log In']")).click();

        Thread.sleep(8000);

        driver.findElement(By.name("email")).sendKeys("admin@gmail.com");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//*[contains(@class, 'submit button')]")).click();

        Thread.sleep(4000);

        System.out.println("The page title is "+driver.getTitle());

        driver.quit();

    }
}
