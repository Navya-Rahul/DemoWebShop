package com.demowebshop.testscripts;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
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
    ExcelUtility excel = new ExcelUtility();
    @Test(priority = 3,enabled = true,description = "Verification of User Login")
    public void verifyUserLogin() throws IOException {
        home = new HomePage(driver);
        login = home.clickOnLoginMenu();
        List<String> excelList = excel.readDataFromExcel(Constants.FILE_PATH,Constants.LOGIN_SHEET_NAME);
        login.enterLoginEmail(excelList.get(0));
        login.enterLoginPassword(excelList.get(1));
        userAccount = login.clickOnLoginButton();
        test.log(LogStatus.PASS, "SUCCESSFULLY NAVIGATED TO USER ACCOUNT PAGE");
        String actualUserName = userAccount.getUserName();
        String expectedUserName = excelList.get(0);
        Assert.assertEquals(actualUserName,expectedUserName,"ERROR : LOGIN FAILED");
        test.log(LogStatus.PASS, "USERNAME SUCCESSFULLY ASSERTED");
    }
}
