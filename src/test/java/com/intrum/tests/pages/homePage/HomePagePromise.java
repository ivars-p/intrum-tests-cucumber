package com.intrum.tests.pages.homePage;

import com.intrum.tests.pages.contactUsPage.ContactUsPage;

public class HomePagePromise {

    public HomePagePromise() {}

    public ContactUsPage andGetContactUsPage() {
        return new ContactUsPage().verify();
    }
}
