package com.sb.cucumbercalc.support.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

/**
 * Created by me on 26/02/16.
 */
public class WebElementMatchers {

    public static Matcher<WebElement> isDisplayed() {
        return new BaseMatcher<WebElement>() {

            public boolean matches(Object actualValue) {
                return ((WebElement) actualValue).isDisplayed();
            }

            public void describeTo(Description description) {
                description.appendText("element to be displayed");
            }

            @Override
            public void describeMismatch(Object item, Description description) {
                description.appendText("was not");
            }
        };
    }
}
