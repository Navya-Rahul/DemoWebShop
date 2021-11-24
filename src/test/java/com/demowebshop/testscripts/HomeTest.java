package com.demowebshop.testscripts;

import com.demowebshop.automationcore.Base;
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

    @Test(priority = 1, enabled = true, description = "Verification of Home Page Title")
    public void verifyHomePageTitle() throws IOException {
        String expectedTitle = "Demo Web Shop";
        home = new HomePage(driver);
        String actualTitle = home.getHomePageActualTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "ERROR : INVALID HOME PAGE TITLE FOUND");
        test.log(LogStatus.PASS, "HOME PAGE TITLE IS MATCHING");
    }
}
