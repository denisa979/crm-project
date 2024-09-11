package com.cydeo.tests.stepDefinition;

import com.cydeo.tests.pages.LoginPage;
import com.cydeo.tests.pages.ProfilePage;
import com.cydeo.tests.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();


    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        System.out.println("DONE IN HOOKS");
    }

    @When("user logs in as {string}")
    public void userLogsInAs(String userType) {
        loginPage.login(userType);
    }

    @Then("user should be able to see {string} as page title")
    public void userShouldBeAbleToSeeAsPageTitle(String title) {
        BrowserUtils.verifyTitleContains(title);
    }

    @When("user logged in withe username as {string} and password as {string}")
    public void userLoggedInWitheUsernameAsAndPasswordAs(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.errorMessage.getText());
    }

    @Then("user should be able to see remember me box")
    public void userShouldBeAbleToSeeRememberMeBox() {
        Assert.assertTrue(loginPage.rememberMe.isDisplayed());
    }

    @When("user clicks Remember me checkbox")
    public void userClicksRememberMeCheckbox() {
        loginPage.rememberMe.click();
    }

    @Then("user should be able to see Remember me checkbox clicked")
    public void userShouldBeAbleToSeeRememberMeCheckboxClicked() {
        Assert.assertTrue(loginPage.rememberMe.isSelected());
    }

    @Then("user should be able to see password is in bullet signs by default")
    public void userShouldBeAbleToSeePasswordIsInBulletSignsByDefault() {
        Assert.assertEquals("password", BrowserUtils.getAttributeValue(loginPage.inputPassword, "type"));
    }
}