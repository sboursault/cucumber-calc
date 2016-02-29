package com.sb.cucumbercalc.hooks;


import com.sb.cucumbercalc.support.ui.utils.EnhancedEventFiringWebDriver;
import cucumber.api.java.Before;

import javax.annotation.Resource;

/**
 * Created by sboursault on 23/02/16.
 */
public class Hooks {

    // urls
    public static final String GOOGLE_URL = "https://www.google.fr";

    @Resource
    private EnhancedEventFiringWebDriver webDriver;

    @Before
    public void navigateToGooglePage() {
        if (!webDriver.getCurrentUrl().startsWith(GOOGLE_URL)) {
            webDriver.get(GOOGLE_URL);
        }
    }
}
