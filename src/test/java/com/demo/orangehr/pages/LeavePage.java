package com.demo.orangehr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LeavePage {

    //Elements
    private final By leaveListButton = By.xpath("//li[.='Leave List']");
    private final By setFromDateClick =By.xpath("(//div[@class='oxd-date-input'])[1]");
    private final By arrowMonth = By.xpath("//div[@class='oxd-calendar-selector-month-selected']//i[@class='oxd-icon bi-caret-down-fill oxd-icon-button__icon']");

    private final By setMonthInput = By.xpath("//li[normalize-space()='April']");
    private final By setDay = By.xpath("//div[@class='oxd-calendar-date'][normalize-space()='1']");
    private final By setToDate = By.xpath("(//i[@class=\"oxd-icon bi-calendar oxd-date-input-icon\"])[2]");

    private final By leaveStatusCheckBox = By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]");
    private final By leaveStatusOption = By.xpath("(//div[@role='option'])[2]");

    private final By subUnit = By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[3]");
    private final By subUnitOption = By.xpath("(//div[@role='option'])[4]");

    private final By leaveTypeDropDown = By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]");

    private final By nameSuggestion = By.xpath("//input[@placeholder=\"Type for hints...\"]");

    private final By checkBox = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");
    private final By searchClick = By.cssSelector(".orangehrm-left-space");
    private final By info = By.cssSelector(".oxd-toast-content-text");
    private static LeavePage leavePage;

    //Constructor
    private LeavePage(){}


    //Methods
    public static LeavePage getInstance(){
        if (leavePage == null) {
            leavePage = new LeavePage();
        }
        return leavePage;
    }

    public void addLeave(WebDriver driver){
        driver.findElement(leaveListButton).click();

    }

    public void setDate(WebDriver driver){

        driver.findElement(setFromDateClick).click();

        driver.findElement(arrowMonth).click();
        driver.findElement(setMonthInput).click();
        driver.findElement(setDay).click();





    }

    public void setToDate(WebDriver driver){
        driver.findElement(setToDate).click();
        driver.findElement(arrowMonth).click();
        driver.findElement(setMonthInput).click();
        driver.findElement(setDay).click();

    }



    public void setLeaveStatus(WebDriver driver){
        WebElement leaveStatus = driver.findElement(leaveStatusCheckBox);
        leaveStatus.click();
        driver.findElement(leaveStatusOption).click();
    }

    public void setSubUnit(WebDriver driver){
        WebElement setSubUnit = driver.findElement(subUnit);
        setSubUnit.click();
        driver.findElement(subUnitOption).click();
    }

    public void setLeaveType(WebDriver driver){
        WebElement leaveType = driver.findElement(leaveTypeDropDown);
        leaveType.click();
        driver.findElement(subUnitOption).click();
    }

    public void setEmployeeName(WebDriver driver){
        WebElement nameInput = driver.findElement(nameSuggestion);
        nameInput.sendKeys("a");
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(leaveStatusOption));
        element.click();
    }

    public void includePastEmployee(WebDriver driver){
        WebElement includeAll = driver.findElement(checkBox);
        includeAll.click();
        driver.findElement(searchClick).click();
    }

    public void swipeUp(WebDriver driver){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, -1200);");
    }

    public boolean getInfoAlert(WebDriver driver){
        return driver.findElement(info).isDisplayed();
    }




}
