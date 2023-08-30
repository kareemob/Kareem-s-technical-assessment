package com.demo.orangehr.testcases;
import com.demo.orangehr.base.BaseTest;
import com.demo.orangehr.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserFlowTest extends BaseTest {

    @Test
    public void userShouldBeAbleToLogin() {
        LoginPage.getInstance().load(driver);
        LoginPage.getInstance().login(driver, "Admin", "admin123");
        Assert.assertTrue(LoginPage.getInstance().getName(driver));
    }

    @Test
    public void addUser() {
        LoginPage.getInstance().load(driver);
        LoginPage.getInstance().login(driver, "Admin", "admin123");
        DashboardPage.getInstance().clickAdmin(driver);
        AdminPage.getInstance().clickAdd(driver);
        AdminPage.getInstance().createUser(driver);
        Assert.assertTrue(DashboardPage.getInstance().getMessage(driver));
    }

    @Test
    public void usersShouldBeAbleToApplyForALeave(){
        LoginPage.getInstance().load(driver);
        LoginPage.getInstance().login(driver, "Admin", "admin123");
        DashboardPage.getInstance().clickLeave(driver);
        LeavePage.getInstance().setDate(driver);
        LeavePage.getInstance().swipeUp(driver);
        LeavePage.getInstance().setToDate(driver);
        LeavePage.getInstance().swipeUp(driver);
        LeavePage.getInstance().setLeaveStatus(driver);
        LeavePage.getInstance().setSubUnit(driver);
        LeavePage.getInstance().setLeaveType(driver);
        LeavePage.getInstance().setEmployeeName(driver);
        LeavePage.getInstance().includePastEmployee(driver);
        Assert.assertTrue(LeavePage.getInstance().getInfoAlert(driver));
    }


    @Test
    public void usersShouldBeAbleToUploadAFile() {
        LoginPage.getInstance().load(driver);
        LoginPage.getInstance().login(driver, "Admin", "admin123");
        DashboardPage.getInstance().clickMyInfo(driver);
        MyInfoPage.getInstance().clickImmigration(driver);
        MyInfoPage.getInstance().addFile(driver);
        Assert.assertTrue(MyInfoPage.getInstance().getSuccessMessage(driver));
    }

    @Test
    public void userShouldBeAbleToAddAPost(){
        LoginPage.getInstance().load(driver);
        LoginPage.getInstance().login(driver, "Admin", "admin123");
        DashboardPage.getInstance().clickBuzz(driver);
        BuzzPage.getInstance().post(driver);
        Assert.assertTrue(BuzzPage.getInstance().getMessage(driver));
    }

    @Test
    public void userShouldBeAbleToLogOut(){
        LoginPage.getInstance().load(driver);
        LoginPage.getInstance().login(driver, "Admin", "admin123");
        DashboardPage.getInstance().logout(driver);
        Assert.assertTrue(LoginPage.getInstance().validate(driver));
    }
}