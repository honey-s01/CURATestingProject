package com.sparta.shs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends LoginPage{

    public AppointmentPage(WebDriver driver){
        super(driver);
    }
    private WebDriver driver = getDriver();
    private By facilityDropdown = new By.ById("combo_facility");
    private By hospitalReadmissionBox = new By.ById("chk_hospotal_readmission");
    private By medicareOption = new By.ById("radio_program_medicare");
    private By medicaidOption = new By.ById("radio_program_medicaid");
    private By noneOption = new By.ById("radio_program_none");
    private By visitDateField = new By.ById("txt_visit_date");
    private By commentField = new By.ById("txt_comment");
    private By bookAppointmentBtn = new By.ById("btn-book-appointment");
    private By appointmentConfirmationField = new By.ByXPath("//*[@id=\"summary\"]/div/div/div[1]/h2");
    private By facilityText = new By.ById("facility");
    private By hospitalReadmissionText = new By.ById("hospital_readmission");
    private By programText = new By.ById("program");
    private By visitDateText = new By.ById("visit_date");
    private By commentText = new By.ById("comment");
    private By menuBtn = new By.ById("menu-toggle");
    private By logoutOption = new By.ByLinkText("Logout");

    public void selectFacility(String facility) {
        Select facilityOption = new Select(driver.findElement(By.id("combo_facility")));
        facilityOption.selectByValue(facility);
    }

    public void applyForReadmission() {
        click(hospitalReadmissionBox);
    }

    public void selectProgram(String program) {
        switch (program.toLowerCase()){
            case "medicare":
                click(medicareOption);
                break;
            case "medicaid":
                click(medicaidOption);
                break;
            default:
                click(noneOption);
                break;
        }
    }

    public void enterDate(String date) {
        enterInput(date.replace("/", ""), visitDateField);
    }

    public void enterComment(String comment) {
        enterInput(comment, commentField);
    }

    public void bookAppointment() {
        click(bookAppointmentBtn);
    }

    public String getConfirmationMessage() {
        return getResponseBody(appointmentConfirmationField);
    }

    public String getField(String field) {
        switch (field.toLowerCase()){
            case "facility":
                return getResponseBody(facilityText);
            case "hospital readmission":
                return getResponseBody(hospitalReadmissionText);
            case "healthcare program":
                return getResponseBody(programText);
            case "visit date":
                return getResponseBody(visitDateText);
            default:
                return getResponseBody(commentText);
        }
    }

    public void logout() {
        click(menuBtn);
        click(logoutOption);
    }

}
