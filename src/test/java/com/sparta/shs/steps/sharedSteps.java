package com.sparta.shs.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class sharedSteps {

    protected static WebDriver driver;
    private static final String DRIVER_LOCATION = "src/test/java/resources/chromedriver";
    public static ChromeDriverService service;

    private static String browser = "firefox";

    protected static WebDriver getDriver(){
        if(driver == null){

            if (browser.equalsIgnoreCase("chrome")){

                ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
                driver = new ChromeDriver(options);

            }
            if (browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", "src/test/java/resources/geckodriver");
                driver = new FirefoxDriver();

            }
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
            options.addArguments("--disable-gpu");

        }
        return driver;
    }

    public static void chromeService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    protected String getUrl(){
        return driver.getCurrentUrl();
    }
}
