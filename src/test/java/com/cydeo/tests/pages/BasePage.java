package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//div[@class='user-block']")
    public WebElement userProfile;

    @FindBy(className = "header-search-input")
    public WebElement searchBox;

    @FindBy(xpath = "//span[contains(@class,'menu-popup-item-text')]")
    public List<WebElement> userProfileDropdownOption;

    @FindBy(id = "logo_24_a")
    public WebElement pageTitle;


    public void clickProfileOptionWithText(String text) {
        BrowserUtils.sleep(1);
        BrowserUtils.clickWithText(userProfileDropdownOption, text);
    }

    public void selectOption(String option) {

        String locator = "(//td[@class='bx-layout-inner-left'])[1]//li//a[contains(.,'" + option + "')]";

        WebElement optionEl = Driver.getDriver().findElement(By.xpath(locator));
        optionEl.click();


    }
}
