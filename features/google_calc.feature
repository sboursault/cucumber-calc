Feature: Google calculator

  Google provides a calculator within it's search engine interface. It's pretty useful !

  Scenario: the calculator appears when asked by user
    When I search for "calculatrice" in google
    Then the calculator should be displayed

  Scenario: the calculator manages additions
    When I add 1 to 5
    Then the result should be 6