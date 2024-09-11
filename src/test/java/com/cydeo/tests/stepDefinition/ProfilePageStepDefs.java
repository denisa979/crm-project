package com.cydeo.tests.stepDefinition;

import com.cydeo.tests.pages.HomePage;
import com.cydeo.tests.pages.LoginPage;
import com.cydeo.tests.pages.ProfilePage;
import com.cydeo.tests.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProfilePageStepDefs {
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();
    LoginPage loginPage = new LoginPage();

    @When("user clicks profile dropdown")
    public void userClicksProfileDropdown() {
        homePage.userProfile.click();
    }

    @When("user clicks {string} option from profile options")
    public void userClicksOptionFromProfileOptions(String option) {
        homePage.clickProfileOptionWithText(option);
    }

    @When("user click navigate back button")
    public void userClickNavigateBackButton() {
        BrowserUtils.navigateToBack();
    }

    @When("user logged in with username as {string} and password as {string}")
    public void userLoggedInWithUsernameAsAndPasswordAs(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should be able to see {int} options under the profile name")
    public void userShouldBeAbleToSeeOptionsUnderTheProfileName(int expectedOptionNumber, List<String> expectedOptions) {
        Assert.assertEquals(expectedOptionNumber, homePage.userProfileDropdownOption.size());

        Assert.assertEquals(expectedOptions, BrowserUtils.getElementsText(homePage.userProfileDropdownOption));
    }

    @Then("user should be able to see the following options on My Profile page like {string}")
    public void userShouldBeAbleToSeeTheFollowingOptionsOnMyProfilePageLike(String options) {
        String[] optionArray = options.split(", ");
        List<String> expectedOptions = Arrays.stream(optionArray).collect(Collectors.toList());
        List<String> actualOptions = BrowserUtils.getElementsText((By) profilePage.myProfileOptions);
        Assert.assertEquals(expectedOptions, actualOptions);

    }

    @Then("user should be able to see the email {string} under the General tab is the same as the user’s account.")
    public void userShouldBeAbleToSeeTheEmailUnderTheGeneralTabIsTheSameAsTheUserSAccount(String expectedEmail) {
        String actualEmail = profilePage.userEmail.getText();
        Assert.assertEquals(expectedEmail, actualEmail);
    }
}
