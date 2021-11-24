package com.demowebshop.pages;

import com.demowebshop.utilities.PageUtility;
import com.demowebshop.utilities.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage extends TestHelper {
    WebDriver driver;
    //PageUtility page = new PageUtility();
    public UserAccountPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*private final String _userName = "//div[@class='header-links']//a[@class='account']";
    private final WebElement userName = driver.findElement(By.xpath(_userName));*/

    private final String _userName = "//div[@class='header-links']//a[@class='account']";
    @FindBy(xpath=_userName)
    private WebElement userName;

    public String getUserName()
    {
        return page.getElementText(userName);
    }
}
