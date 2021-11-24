package com.demowebshop.pages;

import com.demowebshop.constants.Constants;
import com.demowebshop.utilities.PageUtility;
import com.demowebshop.utilities.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class RegisterPage extends TestHelper {
    WebDriver driver;
    //PageUtility page = new PageUtility();

    /*** Page constructor ***/
    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*** Web elements ***/
    /*private final String _genders = "//div[@class='gender']//label";
    private final List<WebElement> genders = driver.findElements(By.xpath(_genders));

    private final String _fName = "FirstName";
    private final WebElement fName = driver.findElement(By.id(_fName));

    private final String _lName = "LastName";
    private final WebElement lName = driver.findElement(By.id(_lName));

    private final String _email = "Email";
    private final WebElement email = driver.findElement(By.id(_email));

    private final String _password = "Password";
    private final WebElement password = driver.findElement(By.id(_password));

    private final String _confirmPassword = "ConfirmPassword";
    private final WebElement confirmPassword = driver.findElement(By.id(_confirmPassword));

    private final String _registerButton = "register-button";
    private final WebElement registerButton = driver.findElement(By.id(_registerButton));*/

    private final String _genders = "//div[@class='gender']//label";
    @FindBy(xpath=_genders)
    private List<WebElement> genders;

    private final String _fName = "FirstName";
    @FindBy(id=_fName)
    private WebElement fName;

    private final String _lName = "LastName";
    @FindBy(id=_lName)
    private WebElement lName;

    private final String _email = "Email";
    @FindBy(id=_email)
    private WebElement email;

    private final String _password = "Password";
    @FindBy(id=_password)
    private WebElement password;

    private final String _confirmPassword = "ConfirmPassword";
    @FindBy(id=_confirmPassword)
    private WebElement confirmPassword;

    private final String _registerButton = "register-button";
    @FindBy(id=_registerButton)
    private WebElement registerButton;

    /*** User action methods ***/
    public void selectGender(String genderToSelect)
    {
        for (int i = 0;i<genders.size();i++)
        {
            String value = page.getElementText(genders.get(i));
            if(value.equals(genderToSelect))
            {
                page.clickOnElement(genders.get(i));
            }
        }
    }
    public void enterFirstName(String fNameToEnter)
    {
        page.enterText(fName,fNameToEnter);
    }
    public void enterLastName(String lNameToEnter)
    {
        page.enterText(lName,lNameToEnter);
    }
    public void enterEmail(String emailToEnter)
    {
        page.enterText(email,emailToEnter);
    }
    public void enterPassword(String passwordToEnter)
    {
        page.enterText(password,passwordToEnter);
    }
    public void enterConfirmPassword(String confirmPasswordToEnter)
    {
        page.enterText(confirmPassword,confirmPasswordToEnter);
    }
    public UserAccountPage clickOnRegisterButton()
    {
        page.clickOnElement(registerButton);
        return new UserAccountPage(driver);
    }
    public String randomStringGeneration(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 5;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomStringEmail = sb.toString()+"@gmail.com";
        return randomStringEmail;
    }

}
