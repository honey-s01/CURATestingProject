package com.sparta.shs.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class sharedSteps {

    protected static WebDriver driver;

    protected static WebDriver getDriver(){
        if(driver == null){
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    protected String getUrl(){
        return driver.getCurrentUrl();
    }
}
