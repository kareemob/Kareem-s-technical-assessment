package com.demo.orangehr.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class AdminPage {

    //Elements
    private final By addButton = By.xpath("//button[.=' Add ']");
    private final By userRoleDropDown = By.xpath("(//div[@class='oxd-select-wrapper'])[1]");
    private final By statusDropDawn = By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
    private final By employeeNameInput = By.xpath("//input[@placeholder=\"Type for hints...\"]");
    private final By passwordInput = By.xpath("(//input[@type=\"password\"])[1]");
    private final By confirmPasswordInput = By.xpath("(//input[@type=\"password\"])[2]");
    private final By saveButton = By.xpath("//button[.=' Save ']");
    private final By dropDownNames = By.xpath("(//div[@role='option'])[2]");
    private final By usernameInput = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");

    private static AdminPage adminPage;

    //Constructor
    private AdminPage(){}

    //Methods

    public static AdminPage getInstance(){
        if (adminPage == null) {
            adminPage = new AdminPage();
        }
        return adminPage;
    }

    public void clickAdd(WebDriver driver){
        driver.findElement(addButton).click();
    }



    public void createUser(WebDriver driver){
        Faker faker = new Faker();
        WebElement userRole = driver.findElement(userRoleDropDown);
        userRole.click();
        Actions actionsRole = new Actions(driver);
        actionsRole.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();


        WebElement status = driver.findElement(statusDropDawn);
        status.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        WebElement nameInput = driver.findElement(employeeNameInput);
        nameInput.sendKeys("a");


        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(dropDownNames));

        element.click();


        driver.findElement(usernameInput).sendKeys(faker.name().username());
        driver.findElement(passwordInput).sendKeys("Test123!");
        driver.findElement(confirmPasswordInput).sendKeys("Test123!");
        driver.findElement(saveButton).click();
    }


}
