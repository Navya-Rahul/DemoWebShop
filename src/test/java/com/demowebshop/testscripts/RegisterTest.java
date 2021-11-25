package com.demowebshop.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
import com.demowebshop.listener.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterTest extends Base {
    HomePage home;
    RegisterPage register;
    UserAccountPage userAccount;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    ExcelUtility excel = new ExcelUtility();
    @Test(priority = 2,enabled = true,description = "Verification of User Registration")
    public void verifyUserRegistration() throws IOException {
        List<String> excelList = excel.readDataFromExcel(Constants.FILE_PATH,Constants.REGISTER_SHEET_NAME);
        home = new HomePage(driver);
        register = home.clickOnRegisterMenu();
        String email = register.randomStringGeneration();
        register.selectGender(excelList.get(0));
        extentTest.get().log(Status.PASS, "Gender Entered Successfully");
        register.enterFirstName(excelList.get(1));
        extentTest.get().log(Status.PASS, "First name Entered Successfully");
        register.enterLastName(excelList.get(2));
        extentTest.get().log(Status.PASS, "Last name Entered Successfully");
        register.enterEmail(email);
        extentTest.get().log(Status.PASS, "Email Entered Successfully");
        register.enterPassword(excelList.get(4));
        extentTest.get().log(Status.PASS, "Password Entered Successfully");
        register.enterConfirmPassword(excelList.get(5));
        extentTest.get().log(Status.PASS, "Confirm password Entered Successfully");
        userAccount = register.clickOnRegisterButton();
        String actualUserName = userAccount.getUserName();
        extentTest.get().log(Status.PASS, "Actual user name successfully generated");
        String expectedUserName = email;
        extentTest.get().log(Status.PASS, "Expected user name successfully generated");
        Assert.assertEquals(actualUserName,expectedUserName,"ERROR : REGISTRATION FAILED");
        extentTest.get().log(Status.PASS, "verify user registration test case passed");
    }
}
