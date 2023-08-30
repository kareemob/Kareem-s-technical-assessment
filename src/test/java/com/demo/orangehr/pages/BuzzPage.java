package com.demo.orangehr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BuzzPage {
    //Elements
    private static BuzzPage buzzPage;

    private final By postInput = By.xpath("//textarea[@class=\"oxd-buzz-post-input\"]");
    private final By postButton = By.xpath("//button[@type=\"submit\"]");
    private final By messageAlert = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");

    //Constructor
    private BuzzPage(){}


    //Methods
    public static BuzzPage getInstance(){
        if (buzzPage == null) {
            buzzPage = new BuzzPage();
        }
        return buzzPage;
    }

    public void post(WebDriver driver){
        driver.findElement(postInput).sendKeys("Hello World!");
        driver.findElement(postButton).click();
    }

    public Boolean getMessage(WebDriver driver){
        return driver.findElement(messageAlert).isDisplayed();

    }

}
