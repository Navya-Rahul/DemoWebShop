package com.demowebshop.pages;

import com.demowebshop.constants.Constants;
import com.demowebshop.utilities.ExcelUtility;
import com.demowebshop.utilities.PageUtility;
import com.demowebshop.utilities.TestHelper;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HomePage extends TestHelper {
    WebDriver driver;
    //PageUtility page = new PageUtility();
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    /*private final String _registerMenu = "//a[@class='ico-register']";
    private WebElement registerMenu = driver.findElement(By.xpath(_registerMenu));

    private final String _loginMenu = "//a[@class='ico-login']";
    private final WebElement loginMenu = driver.findElement(By.xpath(_loginMenu));*/

    private final String _registerMenu = "//a[@class='ico-register']";
    @FindBy(xpath=_registerMenu)
    private WebElement registerMenu;

    private final String _loginMenu = "//a[@class='ico-login']";
    @FindBy(xpath=_loginMenu)
    private WebElement loginMenu;

    public String getHomePageActualTitle()
    {
        return page.getPageTitle(driver);
    }
    /*public String getHomePageExpectedTitle() throws IOException {
        List<String> excelList = new ArrayList<String>();
        ExcelUtility excel = new ExcelUtility();
        excelList = excel.readDataFromExcel(Constants.FILE_PATH,Constants.SHEET_NAME);
        return excelList.get(0);
    }*/
    public RegisterPage clickOnRegisterMenu()
    {
        page.clickOnElement(registerMenu);
        return new RegisterPage(driver);
    }
    public LoginPage clickOnLoginMenu()
    {
        page.clickOnElement(loginMenu);
        return new LoginPage(driver);
    }
}
