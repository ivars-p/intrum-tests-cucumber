package com.intrum.tests.stepDefinitions.homePageSteps;

import com.intrum.tests.pages.homePage.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.intrum.tests.constants.navigation.MenuSections.CONTACT_US_MENU_SECTION;

public class HomePageSteps {

    private final HomePage homePage;

    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    @Given("User starts Intrum Latvia home page UI test")
    public void startIntrumTest() {
        this.homePage.startHomePageTest();
    }

    @When("User navigates from home to contact us page")
    public void navigatesToContacts() {
        this.homePage.navigateToPage(CONTACT_US_MENU_SECTION).andGetContactUsPage();
    }
}
