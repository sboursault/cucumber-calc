# cucumber-calc

##  Running tests

    mvn clean test

## Writing Features

Cucumber is a collaboration tool. Do never modify a feature without validation from your PO.

### Feature description

The feature description is the text just under the feature name. They can make useful documentation.
They should at least answer these questions :
- What is the goal of this feature ?
- Why shoudl we spend time on it ?

### Scenario names

Scenario names seems a waste of time when you start writing features. But it's not. It's the first thing you'll see when a scenario comes to fail.
Also, they help to read the feature file.
They must be concise and expressive.
The trick is to summarize the context and event (the given and when parts) and avoid mentionning the outcoume of the scenario.

### Steps

Use these tenses to write your steps

Given -> present perfect
When -> present
Then -> conditional
    
Example :

    Given I have opened the calculator
    When I add 5 to 6
    Then the result should be 11

This is important to avoid ambiguity about the intent of each step.
