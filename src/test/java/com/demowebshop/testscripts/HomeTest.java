package com.demowebshop.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.listener.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utilities.ExcelUtility;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeTest extends Base {
    HomePage home;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1, enabled = true, description = "Verification of Home Page Title")
    public void verifyHomePageTitle() throws IOException {
        extentTest.get().assignCategory("Regression");
        home = new HomePage(driver);
        String expectedTitle = home.getHomePageExpectedTitle();
        extentTest.get().log(Status.PASS, "Successfully got expected result");
        String actualTitle = home.getHomePageActualTitle();
        extentTest.get().log(Status.PASS, "Actual result captured Successfully");
        Assert.assertEquals(actualTitle, expectedTitle, "ERROR : INVALID HOME PAGE TITLE FOUND");
        extentTest.get().log(Status.PASS, "verify title test case passed");
    }
}
