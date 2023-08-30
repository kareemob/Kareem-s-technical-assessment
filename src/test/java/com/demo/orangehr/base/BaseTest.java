package com.demo.orangehr.base;

import com.demo.orangehr.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends DriverFactory {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
