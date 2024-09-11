package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//div[@class ='errortext']")
    public WebElement errorMessage;

    @FindBy(id = "USER_REMEMBER")
    public WebElement rememberMe;

    @FindBy(name="USER_LOGIN")
    public WebElement inputUsername;

    @FindBy(name="USER_PASSWORD")
    public WebElement inputPassword;

    @FindBy(className="login-btn")
    public WebElement submitButton;

    @FindBy(xpath = "(//span[@class='menu-popup-item-text'])[5]")
    public WebElement logOutButton;

    @FindBy(className = "log-popup-header")
    public WebElement authorization;



    public void login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        BrowserUtils.sleep(1);
        submitButton.click();
    }

    public void login(String userType){
        String username = ConfigurationReader.getProperty(userType+ "_username");
        String password = ConfigurationReader.getProperty(userType + "_password");
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        submitButton.click();

    }

}
