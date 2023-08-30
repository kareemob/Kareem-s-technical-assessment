package com.demo.orangehr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //Elements
    private final By usernameInput = By.xpath("//input[@name='username']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[@type=\"submit\"]");

    private final By name = By.xpath("//span[@class=\"oxd-userdropdown-tab\"]");
    private final By text = By.xpath("//h5[contains(.,'Login')]");
    private static LoginPage loginPage;

    //Constructor
    private LoginPage(){}

    //Methods

    public static LoginPage getInstance(){
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public void load(WebDriver driver){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void login(WebDriver driver, String username, String password){
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean getName(WebDriver driver){
       return driver.findElement(name).isDisplayed();
    }

    public boolean validate(WebDriver driver){
        return driver.findElement(text).isDisplayed();
    }

}
