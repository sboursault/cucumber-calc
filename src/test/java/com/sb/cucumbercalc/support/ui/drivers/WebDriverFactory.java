package com.sb.cucumbercalc.support.ui.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by sboursault on 28/03/16.
 */
public class WebDriverFactory {

    public WebDriver newDriver() {
        return new IOSDriver();
    }

    //private static PhantomJSDriverService phantomJsService(DesiredCapabilities capabilities) {
    //    try {
    //        return ResolvingPhantomJSDriverService.createDefaultService(capabilities);
    //    } catch (IOException e) {
    //        throw new RuntimeException("failed to create the phantomJS service", e);
    //    }
    //}
}
