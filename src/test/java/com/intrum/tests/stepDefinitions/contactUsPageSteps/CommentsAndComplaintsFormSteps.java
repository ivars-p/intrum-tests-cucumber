package com.intrum.tests.stepDefinitions.contactUsPageSteps;

import com.intrum.tests.constants.contactUs.commentAndcomplaintForm.FormsFields;
import com.intrum.tests.pages.contactUsPage.CommentsAndComplaintsForm;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;

import static com.intrum.tests.constants.contactUs.commentAndcomplaintForm.FormsResponseTypes.RESPONSE_TYPE_EMPTY;

public class CommentsAndComplaintsFormSteps {

    private final CommentsAndComplaintsForm commentsAndComplaintsForm;

    public CommentsAndComplaintsFormSteps() {
        this.commentsAndComplaintsForm = new CommentsAndComplaintsForm();
    }

    @Then("User validates comments and complaints forms content")
    public void validateCommentsAndComplaintsForm() {
        this.commentsAndComplaintsForm.verifyFormsContent();
    }

    @And("User fills in comments and complaints form")
    public void fillInCommentsAndComplaintsForm() {
        this.commentsAndComplaintsForm.fillCommentsAndComplaintsForm();
    }

    @And("User submits the comments and complaints form")
    public void SubmitCommentsAndComplaintsForm() {
        this.commentsAndComplaintsForm.submitForm();
    }

    @Then("User validates that comments and complaints form is submitted successfully")
    public void validateComplaintsFormIsSubmitted() {
        this.commentsAndComplaintsForm.verifyFormSubmittedSuccessfully();
    }

    @Then("User validates comments and complaints forms empty field notifications")
    public void validateComplaintsFormsEmptyFields() {
        this.commentsAndComplaintsForm.verifyMandatoryEmptyFieldsNotifications();
    }

    @But("Changes the {} input field to negative value {}")
    public void changesInputFieldToNegativeValue(FormsFields field, String value) {
        this.commentsAndComplaintsForm.clearInputField(field).fillInInputField(field, value);
    }

    @But("Changes the {} text area to negative value {}")
    public void changesTextAreaToNegativeValue(FormsFields field, String value) {
        this.commentsAndComplaintsForm.clearTextArea(field).fillInTextAreaField(field, value);
    }

    @But("Changes the {} to empty value")
    public void changesDropdownToEmptyValue(FormsFields field) {
        this.commentsAndComplaintsForm.setDropDown(field, RESPONSE_TYPE_EMPTY.toString());
    }

    @Then("User validates forms {} empty field notifications - {}")
    public void validateEmptyFiledNotification(FormsFields field, String expectation) {
            this.commentsAndComplaintsForm.verifyEmptyFieldNotification(field, expectation);
    }
}
