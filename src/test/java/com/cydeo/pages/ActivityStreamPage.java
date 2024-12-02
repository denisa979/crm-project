package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

import static com.cydeo.utilities.BrowserUtils.switchToDefaultContent;
import static com.cydeo.utilities.BrowserUtils.switchToFrame;
import static com.cydeo.utilities.CrmUtils.getFakeMessage;

public class ActivityStreamPage extends BasePage {


    @FindBy(xpath = "//span[@class='feed-add-post-form-link feed-add-post-form-link-active']")
    public WebElement message;


    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement messageBoxFrame;


    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageBox;


    @FindBy(xpath = "(//a[@href='#'])[1]")
    public WebElement addMoreMessages;


    @FindBy(xpath = "(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[1]")
    public WebElement sendButton;

    @FindBy(css = ".feed-post-text-block a")
    private List<WebElement> linksInMessages;

    @FindBy(xpath = "//div[@class='feed-post-text-block']/div/div")
    public List<WebElement> messages;


    @FindBy(xpath = "//*[text()='The message title is not specified']")
    public WebElement emptyMessageError;


    @FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement toSendAllEmployees;


    @FindBy(xpath = "(//span[@class='feed-add-post-form-but feed-add-file'])[1]")
    public WebElement uploadFile;


    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']")
    public WebElement link;


    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-video']")
    public WebElement insertVideo;


    @FindBy(xpath = "(//input[@class='diskuf-fileUploader wd-test-file-light-inp '])[1]")
    public WebElement uploadFilesAndImages;


    @FindBy(xpath = "//*[contains(@id, 'blog-submit-button-cancel')]")
    public WebElement cancelButton;


    @FindBy(xpath = "//span[@class='feed-add-post-form-link-text']")
    public WebElement moreOptionButton;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    private WebElement btn_uploadedFile;

    @FindBy(xpath = "//div[@id='feed-add-post-form-tab']/span/span[1]")
    public List<WebElement> tabOptions;

    @FindBy(xpath = "//img")
    private WebElement picture;

    public void selectActivity(String activity) {
        String locator = "(//div[@class='microblog-top-tabs-visible']//span[contains(.,'" + activity + "')])[1]";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

    public void uploadFile(String fileName) {
        String fileSeparator = System.getProperty("file.separator");
        String path = System.getProperty("C:\\Users\\denisaPersonal\\crm-project\\src\\test\\resources\\files\\TestDocx.docx");
        btn_uploadedFile.sendKeys(path);
    }

    public String getMessage(int indexOfMessage) {
        return messages.get(indexOfMessage - 1).getText();
    }


    public String getFirstMessage(){
        return messages.get(0).getText();
    }

    public WebElement getFirstLink(){
        return linksInMessages.get(0);
    }
    public String sendMessage(String message){
        String expectedSentMessage = getFakeMessage(message);
        switchToFrame(messageBoxFrame);
        messageBox.clear();
        messageBox.sendKeys(expectedSentMessage);
        switchToDefaultContent();
        return expectedSentMessage;
    }
    public String getMessageContend(){
        switchToFrame(messageBoxFrame);
        String message = messageBox.getText();
        switchToDefaultContent();
        return message;
    }
    public String getPictureSrcFromMessage(){
        switchToFrame(messageBoxFrame);
        BrowserUtils.waitFor(5);
        String source = picture.getAttribute("src");
        switchToDefaultContent();
        return source;
    }
    public void selectMoreOption(String option){
        String locator="(//span[contains(.,' "+ option +"')])[2]/..";
        WebElement element= Driver.getDriver().findElement(By.xpath(locator));
        element.click();
    }

}




