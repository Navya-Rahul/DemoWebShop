package com.demowebshop.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
import com.demowebshop.listener.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginTest extends Base {
    HomePage home;
    LoginPage login;
    UserAccountPage userAccount;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    ExcelUtility excel = new ExcelUtility();
    @Test(priority = 3,enabled = true,description = "Verification of User Login",groups = {"Sanity"})
    public void verifyUserLogin() throws IOException {
        extentTest.get().assignCategory("Sanity");
        home = new HomePage(driver);
        login = home.clickOnLoginMenu();
        List<String> excelList = excel.readDataFromExcel(Constants.FILE_PATH,Constants.LOGIN_SHEET_NAME);
        login.enterLoginEmail(excelList.get(0));
        extentTest.get().log(Status.PASS, "Email Entered Successfully");
        login.enterLoginPassword(excelList.get(1));
        extentTest.get().log(Status.PASS, "Password Entered Successfully");
        userAccount = login.clickOnLoginButton();
        String actualUserName = userAccount.getUserName();
        extentTest.get().log(Status.PASS, "Actual user name successfully generated");
        String expectedUserName = excelList.get(0);
        extentTest.get().log(Status.PASS, "Expected user name successfully generated");
        Assert.assertEquals(actualUserName,expectedUserName,"ERROR : LOGIN FAILED");
        extentTest.get().log(Status.PASS, "verify user login test case passed");
    }
}
