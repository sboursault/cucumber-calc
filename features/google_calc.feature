Feature: Google calculator

  Google provides a calculator within it's search engine interface. It's pretty useful !

  Scenario: the calculator appears when asked by user
    When I search for "calculatrice" in google
    Then the calculator should be displayed

  Scenario Outline: the calculator manages additions
    Given I have opened the calculator
    When I add <a> to <b>
    Then the result should be <result>

    Examples:
      |  a  |  b | result |
      | 16  |  5 |    21  |
      | 13  | 25 |    38  |
