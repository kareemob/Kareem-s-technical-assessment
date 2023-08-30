package com.demo.orangehr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInfoPage {
    //Elements
    private static MyInfoPage myInfoPage;

    private final By immigrationButtton = By.xpath("(//a[@class=\"orangehrm-tabs-item\"])[4]");
    private final By addButton = By.xpath("(//button[@type=\"button\"])[6]");
    private final By attachFile = By.xpath("//input[@class=\"oxd-file-input\"]");
    private final By saveButton = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");

    //Constructor
    private MyInfoPage(){}


    //Methods
    public static MyInfoPage getInstance(){
        if (myInfoPage == null) {
            myInfoPage = new MyInfoPage();
        }
        return myInfoPage;
    }

    public void clickImmigration(WebDriver driver){

        driver.findElement(immigrationButtton).click();
        driver.findElement(addButton).click();
    }

    public void addFile(WebDriver driver){


        WebElement fileInput = driver.findElement(attachFile);

        fileInput.sendKeys("C:\\Users\\karee\\.m2\\repository\\org\\apache\\maven\\maven\\techAssign\\src\\test\\java\\com\\demo\\orangehr\\resources\\Immigration.txt");
        driver.findElement(saveButton).click();
    }
    public boolean getSuccessMessage(WebDriver driver){
        return driver.findElement(By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")).isDisplayed();
    }
}
