package com.sparta.shs.steps;

import com.sparta.shs.pages.SharedPage;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks extends SharedPage {
    public static WebDriver driver = getDriver();
    protected static final Logger logger = Logger.getLogger(Hooks.class.getName());
    @BeforeAll
    public static void setup() throws IOException {
        chromeService();
    }

    @Before
    public void before(){
        getDriver();
    }

    @After
    public void after(){
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void teardown(){
        service.stop();
        driver.quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            screenshot(driver,System.currentTimeMillis());
        }
    }

    public static void screenshot(WebDriver driver, long ms){
        try{
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("target/screenshots/" + ms + "_screenshot.png"));
            logger.info("Screenshot Taken");
        }
        catch (Exception e){
            System.out.println("Exception caught whilst taking a screenshot");
        }
    }
}
