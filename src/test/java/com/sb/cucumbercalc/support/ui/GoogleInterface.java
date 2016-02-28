package com.sb.cucumbercalc.support.ui;

import static com.sb.cucumbercalc.support.ui.utils.WebElementMatchers.*;
import static org.junit.Assert.*;

import com.sb.cucumbercalc.support.ui.utils.EnhancedEventFiringWebDriver;
import org.openqa.selenium.WebElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("cucumber-glue")
public class GoogleInterface {

    // urls
    public static final String GOOGLE_URL = "http://www.google.com";

    // css selectors
    public static final String SEARCH_FIELD = "#lst-ib";

    @Resource
    private EnhancedEventFiringWebDriver webDriver;

    @Resource
    private CalculatorInterface calculator;

    public void search(String keywords) {
        webDriver.get(GOOGLE_URL);
        WebElement searchField = webDriver.findElement(SEARCH_FIELD);
        searchField.sendKeys(keywords);
        searchField.submit();
    }

    public void calculatorShouldBeDisplayed() {
        WebElement resultField = webDriver.findAjaxElement(CalculatorInterface.CALCULATOR_FIELD);
        assertThat(resultField, isDisplayed());
    }

    public CalculatorInterface getCalculator() {
        calculatorShouldBeDisplayed();
        return calculator;
    }

}
