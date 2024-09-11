package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompanyPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'main-buttons-item-link')]")
    public List<WebElement> modules;

    public void selectModule(String module) {

        String locator = "//*[contains(@class, 'main-buttons-item-link')]//*[.='" + module + "']";

        WebElement optionEl = Driver.getDriver().findElement(By.xpath(locator));
        optionEl.click();

    }
}