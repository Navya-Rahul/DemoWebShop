package com.demowebshop.pages;

import com.demowebshop.utilities.PageUtility;
import com.demowebshop.utilities.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestHelper {
    WebDriver driver;
    //PageUtility page = new PageUtility();
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*private final String _loginEmail = "Email";
    private final WebElement loginEmail = driver.findElement(By.id(_loginEmail));

    private final String _loginPassword = "Password";
    private final WebElement loginPassword = driver.findElement(By.id(_loginPassword));

    private final String _loginButton = "//input[@class='button-1 login-button']";
    private final WebElement loginButton = driver.findElement(By.xpath(_loginButton));*/

    private final String _loginEmail = "Email";
    @FindBy(id=_loginEmail)
    private WebElement loginEmail;

    private final String _loginPassword = "Password";
    @FindBy(id=_loginPassword)
    private WebElement loginPassword;

    private final String _loginButton = "//input[@class='button-1 login-button']";
    @FindBy(xpath=_loginButton)
    private WebElement loginButton;

    public void enterLoginEmail(String emailToEnter)
    {
        page.enterText(loginEmail,emailToEnter);
    }
    public void enterLoginPassword(String passwordToEnter)
    {
        page.enterText(loginPassword,passwordToEnter);
    }

    public UserAccountPage clickOnLoginButton()
    {
        page.clickOnElement(loginButton);
        return new UserAccountPage(driver);
    }
}
