# cucumber-calc

Cucumber is an open-source tool for executable specification.

For this example project, I wrote a feature file to verify the behavior of the google calculator.

##  Running tests

To run the project with maven, go to you project's folder and run :

    mvn clean test

## Writing features files

Cucumber was designed to help tech and business people to work together.

Practically, this means tech people should never modify a feature file without validation from the PO - otherwise, this is not collaboration ;)

Also, we should spend time to make feature files easy to read.

Convention:
- Feature files are placed in the folder /features.
- They are named using snake case (https://en.wikipedia.org/wiki/Snake_case).

### Feature description

The feature description is the text just under the feature name. This description can make a useful documentation.

It should at least answer these questions:
- What is the goal of this feature ?
- Why should we spend time on it ?

### Scenario names

Scenario names help to read the feature file and they are the first thing we'll see when a scenario comes to fail.

They must be both concise and expressive. The trick is to summarize the context and event (the Given and When parts) and avoid mentionning the outcoume of the scenario.

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

We want our test suite to run fast, and when it raises an error, it's because a bug was introduced in the production code.

### Run fast

If the tests run fast, we'll be able to run them more often, and to give feedback earlier.

This is very important because the sooner you discover a bug, the  less it will cost.

### Isolation

Each test must be able to run in isolation, so that it never depends on the result of previous tests. Isolated tests will be less brittle.

### Eliminate non determinism

"A test is non-deterministic when it passes sometimes and fails sometimes, without any noticeable change in the code, tests, or environment. Such tests fail, then you re-run them and they pass. Test failures for such tests are seemingly random." - Martin Fowler.

The problem with non-deterministism is that people will lose confidence in the test suite. This is the last thing we want.

This post gives tracks on how to fight against them : http://martinfowler.com/articles/nonDeterminism.html

### Interacting with UI

Tests based on ui can be quite brittle. A simple change in the look and feel can break many tests.

Remember: we write tests to facilitate change, not to slow them.

To facilitate ui refactoring, all the glue code related to page details (e.g. dom resolutions) should be hidden in the package support.ui, organized in classes which represents the pages of the ui (or the parts of some pages).

More on the subject : http://martinfowler.com/bliki/PageObject.html (yep, him again!)

### Understanding spring scopes

Most of the objects (steps, hooks and support objects) are instanciated in the cucumber scope. This means they are relaoded at the beginning of each scenario.

This helps to write isolated tests.

The web driver is an exception, because this one would be to costly to reload again and again.



