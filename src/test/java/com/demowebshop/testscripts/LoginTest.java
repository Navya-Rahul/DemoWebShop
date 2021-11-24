package com.demowebshop.testscripts;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    HomePage home;
    LoginPage login;
    UserAccountPage userAccount;
    @Test(priority = 3,enabled = true,description = "Verification of User Login")
    public void verifyUserLogin()
    {
        home = new HomePage(driver);
        login = home.clickOnLoginMenu();
        login.enterLoginEmail("navyanaveenam@gmail.com");
        login.enterLoginPassword("Rithul@12");
        userAccount = login.clickOnLoginButton();
        String actualUserName = userAccount.getUserName();
        String expectedUserName = "navyanaveenam@gmail.com";
        Assert.assertEquals(actualUserName,expectedUserName,"ERROR : LOGIN FAILED");
    }
}
