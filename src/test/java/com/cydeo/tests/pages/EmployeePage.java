package com.cydeo.tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeePage extends BasePage {


    @FindBy(xpath = "//div[@id='top_menu_id_company']//span[@class='main-buttons-item-text']/spa")
    public List<WebElement> employeeModules;


    @FindBy(xpath = "//div[@id='bx_visual_structure']//table[2]/tbody/tr[1]/td/span//a")
    public List<WebElement> allDepartments;

}
