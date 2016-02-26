package com.sb.cucumbercalc.support;

import static com.sb.cucumbercalc.support.matchers.WebElementMatchers.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
@Scope("cucumber-glue")
public class GoogleInterface {

    @Resource
    private EventFiringWebDriver webDriver;

    public void search(String str) {

        webDriver.get("http://www.google.com");
        WebElement searchField = webDriver.findElement(By.id("lst-ib"));
        searchField.sendKeys(str);
        searchField.submit();
    }

    public void calculatorShouldBeDisplayed() {
        By locator = By.id("cwtlbb");
        webDriverWait().until(presenceOfElementLocated(locator));
        WebElement resultField = webDriver.findElement(locator);
        assertThat(resultField, isDisplayed());
    }

    private FluentWait<WebDriver> webDriverWait() {
        return new WebDriverWait(webDriver, 2)
                .pollingEvery(200, TimeUnit.MILLISECONDS);
    }

}
