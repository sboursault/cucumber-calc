Feature: Google calculator

  Google provides a calculator within it's search engine interface. It's pretty useful !

  Scenario: the calculator appears when asked by user
    When I search for calc in google
    Then the calculator is displayed

  Scenario: the calculator manages additions
    When I add 1 to 5
    Then the result displayed is 6