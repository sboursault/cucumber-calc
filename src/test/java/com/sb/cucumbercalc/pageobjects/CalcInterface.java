package com.sb.cucumbercalc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("cucumber-glue")
public class CalcInterface {

    @Resource
    private EventFiringWebDriver webDriver;

    public void search(String str) {

        webDriver.get("http://www.google.com");
        webDriver.findElement(By.id("lst-ib")).sendKeys(str);
        webDriver.findElement(By.id("lst-ib")).submit();

    }

}
