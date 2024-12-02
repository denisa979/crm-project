package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{




    @FindBy(xpath = "//td[.='E-Mail:']/..//a")
    public WebElement userEmail;

    @FindBy(xpath = "(//span[@class='menu-popup-item-text'])[1]")
    public WebElement myProfileOptions;


}
