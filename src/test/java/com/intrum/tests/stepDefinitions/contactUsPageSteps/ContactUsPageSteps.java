package com.intrum.tests.stepDefinitions.contactUsPageSteps;

import com.intrum.tests.pages.contactUsPage.ContactUsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {

    private final ContactUsPage contactUsPage;

    public ContactUsPageSteps() {
        this.contactUsPage = new ContactUsPage();
    }


    @Then("User validates contacts row in contact us page")
    public void validateContactsRow() {
        this.contactUsPage.verifyContactsRowContent();
    }

    @When("User opens comments and complaints form in contact us page")
    public void opensCommentsAndComplaintsForm() {
        this.contactUsPage.openCommentsAndComplaintsForm();
    }

    @Given("User starts Intrum Latvia contact us UI test")
    public void startIntrumContactUsUITest() {
        this.contactUsPage.startContactUsPageTest();
    }
}
