Feature: Tests regards validating the functionality of Intrum Latvia "Contact Us" page contact form.

  @contactForm @l1 @CF01TC01
  Scenario: CF01 TC01: Validate contact forms section and its elements
    Given User starts Intrum Latvia home page UI test
    When User navigates from home to contact us page
    Then User validates contacts row in contact us page
    When User opens comments and complaints form in contact us page
    Then User validates comments and complaints forms content


  @contactForm @l1 @CF01TC02
  Scenario: CF01 TC02: Submit form - happy path - L1
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User fills in comments and complaints form
#    And User submits the comments and complaints form
#    Then User validates that comments and complaints form is submitted successfully


  @contactForm @l1 @CF01TC03
  Scenario: CF01 TC03: Submit form - empty - L1
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User submits the comments and complaints form
    Then User validates comments and complaints forms empty field notifications


  @contactForm @l2 @CF01TC04
  Scenario Outline: CF01 TC04: Validate name and surname input field - L2
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User fills in comments and complaints form
    But Changes the NAME_AND_SURNAME_FIELD input field to negative value <NAME AND SURNAME>
#    And User submits the comments and complaints form
#    Then User validates forms NAME_AND_SURNAME_FIELD empty field notifications - VISIBLE

    Examples:
      | NAME AND SURNAME |
      | ""               |
      | John1 Doe1       |
      | John* Doe*       |


  @contactForm @l2 @CF01TC05
  Scenario Outline: CF01 TC05: Validate personal code input field - L2
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User fills in comments and complaints form
    But Changes the PERSONAL_CODE_FIELD input field to negative value <PERSONAL CODE>
#    And User submits the comments and complaints form
#    Then User validates forms PERSONAL_CODE_FIELD empty field notifications - VISIBLE

    Examples:
      | PERSONAL CODE |
      | ""            |
      | XXXXXX-XXXXX  |
      | ******-*****  |


  @contactForm @l2 @CF01TC06
  Scenario Outline: CF01 TC06: Validate case number input field - L2
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User fills in comments and complaints form
    But Changes the CASE_NUMBER_FIELD input field to negative value <CASE NR>
#    And User submits the comments and complaints form
#    Then User validates forms CASE_NUMBER_FIELD empty field notifications - NOT VISIBLE

    Examples:
      | CASE NR |
      | ""      |


  @contactForm @l2 @CF01TC07
  Scenario Outline: TC07: Validate phone number input field - L2
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User fills in comments and complaints form
    But Changes the CONTACT_NUMBER_FIELD input field to negative value <PHONE NUMBER>
#    And User submits the comments and complaints form
#    Then User validates forms CONTACT_NUMBER_FIELD empty field notifications - VISIBLE

    Examples:
      | PHONE NUMBER |
      | ""           |
      | 1            |
      | ********     |


  @contactForm @l2 @CF01TC08
  Scenario Outline: TC08: Validate email input field - L2
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User fills in comments and complaints form
    But Changes the EMAIL_FIELD input field to negative value <EMAIL>
#    And User submits the comments and complaints form
#    Then User validates forms EMAIL_FIELD empty field notifications - VISIBLE

    Examples:
      | EMAIL                           |
      | ""                              |
      | a”b(c)d,e:f;gi[j\k]l@domain.com |
      | example.com                     |
      | A@b@c@domain.com                |


  @contactForm @l2 @CF01TC09
  Scenario Outline: CF01 TC09: Validate physical address input field - L2
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User fills in comments and complaints form
    But Changes the ADDRESS_FIELD input field to negative value <ADDRESS>
#    And User submits the comments and complaints form
#    Then User validates forms ADDRESS_FIELD empty field notifications - VISIBLE

    Examples:
      | ADDRESS |
      | ""      |


  @contactForm @l2 @CF01TC10
  Scenario Outline: CF01 TC10: Validate comment/complaint input field - L2
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User fills in comments and complaints form
    But Changes the COMMENT_AND_COMPLAINT_FIELD text area to negative value <COMPLAINT>
#    And User submits the comments and complaints form
#    Then User validates forms COMMENT_AND_COMPLAINT_FIELD empty field notifications - VISIBLE

    Examples:
      | COMPLAINT |
      | ""        |


  @contactForm @l2 @CF01TC11
  Scenario: CF01 TC11: Validate response type selection dropdown - L2
    Given User starts Intrum Latvia contact us UI test
    When User opens comments and complaints form in contact us page
    And User fills in comments and complaints form
    But Changes the RESPONSE_TYPE_FIELD to empty value
#    And User submits the comments and complaints form
#    Then User validates forms RESPONSE_TYPE_FIELD empty field notifications - VISIBLE



