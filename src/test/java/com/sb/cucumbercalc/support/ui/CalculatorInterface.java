package com.sb.cucumbercalc.support.ui;

import com.sb.cucumbercalc.support.ui.utils.EnhancedEventFiringWebDriver;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static org.junit.Assert.assertThat;

@Component
@Scope("cucumber-glue")
public class CalculatorInterface {

    // css selectors
    public static final String CALCULATOR_FIELD = "#cwos";

    @Resource
    private EnhancedEventFiringWebDriver webDriver;

    public void type(String operation) {
        for (int i = 0; i< operation.length(); i++) {
            getButton(operation.charAt(i)).click();
        }
    }

    public void resultShouldBe(int result) {
        getButton('=').click();
        WebElement calculatorField = webDriver.findElement(CALCULATOR_FIELD);
        assertThat(calculatorField.getText(), is(String.valueOf(result)));
    }


    // helpers

    private WebElement getButton(char input) {
        switch (input){
            case '0': return webDriver.findElement("#cwbt43");
            case '1': return webDriver.findElement("#cwbt33");
            case '2': return webDriver.findElement("#cwbt34");
            case '3': return webDriver.findElement("#cwbt35");
            case '4': return webDriver.findElement("#cwbt23");
            case '5': return webDriver.findElement("#cwbt24");
            case '6': return webDriver.findElement("#cwbt25");
            case '7': return webDriver.findElement("#cwbt13");
            case '8': return webDriver.findElement("#cwbt14");
            case '9': return webDriver.findElement("#cwbt15");
            case '.': return webDriver.findElement("#cwbt44");
            case ',': return webDriver.findElement("#cwbt44");
            case '+': return webDriver.findElement("#cwbt46");
            case '-': return webDriver.findElement("#cwbt36");
            case '*': return webDriver.findElement("#cwbt26");
            case '/': return webDriver.findElement("#cwbt16");
            case '=': return webDriver.findElement("#cwbt45");
            default: throw new IllegalArgumentException("wrong input : " + input);
        }
    }
}
