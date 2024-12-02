package com.cydeo.step_definitions;

import com.cydeo.pages.HomePage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
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
        BrowserUtils.waitFor(2);
      loginPage.login(userType);
    }

    @Then("user should be able to see {string} as page title")
    public void userShouldBeAbleToSeeAsPageTitle(String title) {
        BrowserUtils.verifyTitleContains(title);
    }

    @When("user log in with incorrect username as {string} and password as {string}")
    public void userLogInWithIncorrectUsernameAsAndPasswordAs(String username, String password) {
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

    @Then("user should be able to see {string} checkbox clicked")
    public void userShouldBeAbleToSeeCheckboxClicked(String checkbox) {

        Assert.assertTrue(loginPage.rememberMe.isSelected());
    }

    @Then("user should be able to see password is in bullet signs by default")
    public void userShouldBeAbleToSeePasswordIsInBulletSignsByDefault() {
        Assert.assertEquals("password", BrowserUtils.getAttributeValue(loginPage.inputPassword, "type"));
    }



}