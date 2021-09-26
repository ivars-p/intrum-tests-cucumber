package com.intrum.tests.constants.contactUs;

public enum RowButtons {

    CONTACT_ROW_FORM_BUTTON("Forma");

    private final String button;

    RowButtons(String value) {
        button = value;
    }

    public String toString() {
        return this.button;
    }
}
