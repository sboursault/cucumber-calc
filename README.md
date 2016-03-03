# cucumber-calc

Cucumber is an open-source tool for executable specification.

##  Running tests

Using maven, go to you project's folder and run :

    mvn clean test

## Writing features files

Cucumber was designed to help tech and business people to work together.

Practically, this means tech people should never modify a feature file without validation from the PO (otherwise, there's no collaboration ;) )

Also, we should spend time to make them easy to read.

Feature files are placed in a folder "features" at the root of the project. They are named using snake case (https://en.wikipedia.org/wiki/Snake_case).

### Feature description

The feature description is the text just under the feature name. They can make useful documentation.

They should at least answer these questions :
- What is the goal of this feature ?
- Why shoudl we spend time on it ?

### Scenario names

Scenario names help to read the feature file and they are the first thing you'll see when a scenario comes comes to fail.

They must be concise and expressive. The trick is to summarize the context and event (the Given and When parts) and avoid mentionning the outcoume of the scenario.

### Steps

Use these tenses to write your steps
- Given -> present perfect
- When -> present
- Then -> conditional
    
Example :

    Given I have opened the calculator
    When I add 5 to 6
    Then the result should be 11

This is important to avoid ambiguity about the intent of each step.


## Implementing glue code

TODO
