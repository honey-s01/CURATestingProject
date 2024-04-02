package com.sparta.shs.pages;

import com.sparta.shs.steps.sharedSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SharedPage extends sharedSteps {

    public WebDriver driver = getDriver();
    private WebDriverWait webDriverWait;

    public void click(By webElement){
        driver.findElement(webElement).click();
    }

    public void enterInput(String entry, By webElement){
        driver.findElement(webElement).sendKeys(entry);
    }

    public String getResponseBody(By webElement){
        return driver.findElement(webElement).getText();
    }
}
