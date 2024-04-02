package com.sparta.shs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SharedPage {

    private WebDriver driver;
    private LoginPage loginPage;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private static final By makeAppointmentBtn = new By.ById("btn-make-appointment");
    public void makeAppointment(){
        SharedPage sharedPage = new SharedPage();
        sharedPage.click(makeAppointmentBtn);
    }

}
