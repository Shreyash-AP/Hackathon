Feature: Finding Hospitals

  @sanity @regression
  Scenario: displays Doctors
    Given User present on practo.com Website_one
    When User enters city Mumbai in seachbox
    And User clicks on Mumbai option
    And User enters Medical specialist Cardiologist in seachbox
    And User clicks on Cardiologist option
    And User applies filters
    Then User displays the first five Doctors
    When User clicks on Surgeries
    Then User displays the Surgeries list

  @sanity
  Scenario: Fill Form
    Given Navigate to Health & Wellness Plans Page
    When the user click on health and wellness plans under for corporates
    And the user fill the form by reading input from excel
    And scrolls the page and passes the invalid email
    Then user validates whether the button is disabled
    When the user refresh the health and wellness page
    And scrolls the page and passes the valid email
    Then user validates whether the button is enabled
    And capture the message displayed after successful form submission
