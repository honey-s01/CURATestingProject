package com.sparta.shs.pages;

import com.sparta.shs.steps.sharedSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HomePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private final By usernameField = new By.ById("txt-username");
    private final By passwordField = new By.ById("txt-password");
    private final By loginBtn = new By.ById("btn-login");
    private final By failedMessageField = new By.ByCssSelector("p[class='lead text-danger']");

    public void enterUsername(String username){
        enterInput(username, usernameField);
    }

    public void enterPassword(String password){
        enterInput(password, passwordField);
    }

    public void clickLogin(){
        click(loginBtn);
    }

    public String getFailedMessage(){
        return getResponseBody(failedMessageField);
    }
}
