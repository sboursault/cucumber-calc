# cucumber-calc

Cucumber is an open-source tool for executable specification.

##  Running tests

Using maven, go to you project's folder and run :

    mvn clean test

## Writing features files

Cucumber was designed to help tech and business people to work together.

Practically, this means tech people should never modify a feature file without validation from the PO - otherwise, there's no collaboration ;)

Also, we should spend time to make feature files easy to read.

Feature files are placed in a folder "features" at the root of the project. They are named using snake case (https://en.wikipedia.org/wiki/Snake_case).

### Feature description

The feature description is the text just under the feature name. They can make useful documentation.

They should at least answer these questions :
- What is the goal of this feature ?
- Why should we spend time on it ?

### Scenario names

Scenario names help to read the feature file and they are the first thing you'll see when a scenario comes to fail.

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

We want our test suite to run fast, so that we can run it more often, and give feedback earlier when a bug appear.

In addition, a failing test should thell what went wrong



### Whenever you can, check 
You may think it's useless, but the day a test comes to fail, it'll help to understand the cause of the failure.


### Interacting with UI

All the glue code related to page details (e.g. dom resolutions) should be hidden in the support.ui package, in a class representing a particular page or a part of a page.
http://martinfowler.com/bliki/PageObject.html is a worth reading it.


### Understanding spring scopes

Most of the objects (steps, hooks and support objects) are instanciated in the cucumber scope. This means they are relaoded at the beginning of each scenario.
This helps to write isolated and more stable tests.
The web driver is an exception, because this one would be to costly to reload several times.
    

