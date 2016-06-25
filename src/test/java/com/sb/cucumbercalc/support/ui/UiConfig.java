package com.sb.cucumbercalc.support.ui;

import com.sb.cucumbercalc.support.ui.utils.EnhancedEventFiringWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by seb on 6/25/16.
 */
@Configuration
public class UiConfig {

    @Bean
    public EnhancedEventFiringWebDriver webDriver(@Value("${cucumber.closeBrowserAfterTests}") boolean closeBrowserAfterTests) {
        return new EnhancedEventFiringWebDriver(newDriver(), closeBrowserAfterTests);
    }

    private static String OS = System.getProperty("os.name").toLowerCase();

    public WebDriver newDriver() {

        String browser = "firefox";

        if (isUnix()) {
            // return new FirefoxDriver();

            String projectDir = System.getProperty("user.dir");
            String marionetteDriverLocation = projectDir + "/drivers/firefox/geckodriver";
            System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);

            return new MarionetteDriver();
        } else {
            throw new RuntimeException("Can't run test on " + OS + " " + browser);
        }
    }

    public static void main(String[] args) {
        System.out.print(System.getProperty("user.dir") + "/drivers/firefox/");
    }

    private static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    private static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    private static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

}
