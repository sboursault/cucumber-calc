package com.sb.cucumbercalc.support.ui.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by sboursault 27/02/16.
 */
public class EnhancedEventFiringWebDriver extends EventFiringWebDriver {

    private static Log LOGGER = LogFactory.getLog(EnhancedEventFiringWebDriver.class);

    public EnhancedEventFiringWebDriver(WebDriver driver, boolean closeBrowserAfterTests) {
        super(driver);

        if (closeBrowserAfterTests) {
            // a better way to implement this would be to define the destroy-method on the spring bean,
            // but I didn't find how to parameterize it.
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        quit();
                    } catch (Throwable t) {
                        LOGGER.warn(t.getMessage());
                    }
                }
            });
        }
    }

    public EnhancedEventFiringWebDriver(WebDriver driver) {
        this(driver, true);
    }

    /**
     * shortcut to find an element using a css selector
     */
    public WebElement findElement(String cssSelector) {
        return super.findElement(By.cssSelector(cssSelector));
    }

    /**
     * shortcut to find an ajax element using a css selector
     */
    public WebElement findAjaxElement(String cssSelector) {
        return findAjaxElement(By.cssSelector(cssSelector));
    }

    /**
     * This method is similar to #findElement, but it waits for the element to be present.
     * This can help to find elements loaded with ajax.
     */
    public WebElement findAjaxElement(By locator) {
        poll().until(presenceOfElementLocated(locator));
        return super.findElement(locator);
    }

    /**
     * <p>Factory method to build a WebDriverWait.</p>
     *
     * <p>Example :</p>
     * <pre>poll().until(ExpectedConditions.presenceOfElementLocated(By.id("my_div")));
     * </pre>
     */
    public FluentWait<WebDriver> poll() {
        return new WebDriverWait(this, 5)
                .pollingEvery(200, TimeUnit.MILLISECONDS);
    }
}
