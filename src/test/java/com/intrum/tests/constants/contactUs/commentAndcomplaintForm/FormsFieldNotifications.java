package com.intrum.tests.constants.contactUs.commentAndcomplaintForm;

public enum FormsFieldNotifications {

    EMPTY_FIELD_NOTIFICATION("Lūdzu, aizpildiet lauku");

    private final String notification;

    FormsFieldNotifications(String value) {
        this.notification = value;
    }

    public String toString() {
        return this.notification;
    }
}
