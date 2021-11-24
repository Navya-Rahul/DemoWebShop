package com.demowebshop.testscripts;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
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
    ExcelUtility excel = new ExcelUtility();
    @Test(priority = 2,enabled = true,description = "Verification of User Registration")
    public void verifyUserRegistration() throws IOException {
        List<String> excelList = excel.readDataFromExcel(Constants.FILE_PATH,Constants.REGISTER_SHEET_NAME);
        home = new HomePage(driver);
        register = home.clickOnRegisterMenu();
        String email = register.randomStringGeneration();
        register.selectGender(excelList.get(0));
        register.enterFirstName(excelList.get(1));
        register.enterLastName(excelList.get(2));
        register.enterEmail(email);
        register.enterPassword(excelList.get(4));
        register.enterConfirmPassword(excelList.get(5));
        userAccount = register.clickOnRegisterButton();
        test.log(LogStatus.PASS, "SUCCESSFULLY NAVIGATED TO USER ACCOUNT PAGE");
        String actualUserName = userAccount.getUserName();
        String expectedUserName = email;
        Assert.assertEquals(actualUserName,expectedUserName,"ERROR : REGISTRATION FAILED");
        test.log(LogStatus.PASS, "USERNAME SUCCESSFULLY ASSERTED");
    }
}
