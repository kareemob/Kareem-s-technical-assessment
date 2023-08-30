package com.demo.orangehr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {
    //Elements
    private final By adminModuleButton = By.xpath("(//a[@class=\"oxd-main-menu-item\"])[1]");
    private final By leaveModuleButton = By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[3]");
    private final By myInfoButton = By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[6]");

    private final By buzzButton = By.xpath("(//a[@class=\"oxd-main-menu-item\"])[11]");
    private final By userDropdownMenu = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private final By logoutButton = By.xpath("(//a[@class=\"oxd-userdropdown-link\"])[4]");
    private final By successMessage = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
    private static DashboardPage dashboardPage;

    //Constructor
    private DashboardPage(){}

    //Methods
    public static DashboardPage getInstance(){
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public void clickAdmin(WebDriver driver){
        driver.findElement(adminModuleButton).click();
    }

    public void clickLeave(WebDriver driver){
        driver.findElement(leaveModuleButton).click();
    }

    public void clickMyInfo(WebDriver driver){
        driver.findElement(myInfoButton).click();
    }

    public void clickBuzz(WebDriver driver){
        driver.findElement(buzzButton).click();
    }

    public void logout(WebDriver driver){
        driver.findElement(userDropdownMenu).click();
        driver.findElement(logoutButton).click();
    }

    public Boolean getMessage(WebDriver driver){
        return driver.findElement(successMessage).isDisplayed();
    }
}
