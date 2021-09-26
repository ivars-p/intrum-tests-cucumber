Test automation project for web-site: 'https://www.intrum.lv/'
=======================================

The following tests are automated:
----------------------------------

- STORY: CF01 - Validate Contact form and its functionality
  - TC01: Validate contact forms section and its elements  - L1
  - TC02: Submit form - happy path - L1
  - TC03: Submit form - empty - L1
  - TC04: Validate name and surname input field - L2
  - TC05: Validate personal code input field - L2
  - TC06: Validate case number input field - L2
  - TC07: Validate phone number input field - L2
  - TC08: Validate email input field - L2
  - TC09: Validate physical address input field - L2
  - TC10: Validate comment/complaint input field - L2
  - TC11: Validate response type selection dropdown - L2


Scenario test case can be found here:
```
src/test/resources/features/ContactForm.feature
```

Requirements
-------------
- Java
- Maven
- Browser on which to execute tests 'chrome' preferably
- Driver for used browser in this case 'chromedriver' - has to be compatible with 'chrome' version
 
Quick start
-------------

After installing all the dependencies the tests can be ran executing command:

- Run - [TestNG](TestNg.xml) - configuration file

By default, tests are executed in headless mode using chrome in parallel mode using "4" threads


Report generation
-------------

After tests are finished report can be generated executing command :
```maven
mvn allure:serve
```

Troubleshooting
---------------

There can be a situation where chromedriver is not recognized automatically by the system or is missing,
if this is the case please follow the instructions written here:
`https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver`


Note
---------------
I specifically commented out all form submissions where invalid input validation
is not implemented, test steps are implemented correctly and can be uncommented and used.