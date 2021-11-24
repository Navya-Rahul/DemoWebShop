package com.demowebshop.testscripts;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends Base {
    HomePage home;
    RegisterPage register;
    UserAccountPage userAccount;
    @Test(priority = 2,enabled = true,description = "Verification of User Registration")
    public void verifyUserRegistration()
    {
        home = new HomePage(driver);
        register = home.clickOnRegisterMenu();
        register.selectGender("Female");
        register.enterFirstName("Navya");
        register.enterLastName("Rahul");
        register.enterEmail("rithu1234@gmail.com");
        register.enterPassword("Ri@123");
        register.enterConfirmPassword("Ri@123");
        userAccount = register.clickOnRegisterButton();
        String actualUserName = userAccount.getUserName();
        String expectedUserName = "rithu1234@gmail.com";
        Assert.assertEquals(actualUserName,expectedUserName,"ERROR : REGISTRATION FAILED");
    }
}
