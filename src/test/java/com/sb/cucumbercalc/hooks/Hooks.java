package com.sb.cucumbercalc.hooks;


import com.sb.cucumbercalc.support.ui.utils.EnhancedEventFiringWebDriver;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * Created by sboursault on 23/02/16.
 */

public class Hooks {

    // urls
    @Value("${google.url}")
    private String googleUrl;

    @Resource
    private EnhancedEventFiringWebDriver webDriver;

    @Before
    public void navigateToGooglePage() {
        if (!webDriver.getCurrentUrl().startsWith(googleUrl)) {
            webDriver.get(googleUrl);
        }
    }
}
