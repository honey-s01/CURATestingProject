package com.sparta.shs.steps;

import com.beust.ah.A;
import com.sparta.shs.pages.AppointmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class makeAnAppointmentSteps extends sharedSteps {

    public WebDriver driver = getDriver();
    private AppointmentPage appointmentPage;
    public makeAnAppointmentSteps()
    {
        appointmentPage = new AppointmentPage(driver);
    }


    @When("I select {string} facility")
    public void iSelectFacility(String facility) {
        appointmentPage.selectFacility(facility);
    }

    @And("I apply for hospital readmission")
    public void iApplyForHospitalReadmission() {
        appointmentPage.applyForReadmission();
    }

    @And("I select {string} healthcare program")
    public void iSelectHealthcareProgram(String program) {
        appointmentPage.selectProgram(program);
    }

    @And("I enter {string} date")
    public void iEnterDate(String date) {
        appointmentPage.enterDate(date);
    }

    @And("I enter {string} comment")
    public void iEnterComment(String comment) {
        appointmentPage.enterComment(comment);
    }

    @And("I book appointment")
    public void iBookAppointment() {
        appointmentPage.bookAppointment();
    }

    @Then("I should see appointment confirmation")
    public void iShouldSeeAppointmentConfirmation() {
        MatcherAssert.assertThat(appointmentPage.getConfirmationMessage(), Matchers.is("Appointment Confirmation"));
    }

    @And("I confirm details stored in the table")
    public void iConfirmDetailsStoredInTheTable(Map<String, String> expectedData) {
        MatcherAssert.assertThat(expectedData.get("Facility"), Matchers.is(appointmentPage.getField("Facility")));
        MatcherAssert.assertThat(expectedData.get("Hospital readmission"), Matchers.is(appointmentPage.getField("Hospital readmission")));
        MatcherAssert.assertThat(expectedData.get("Healthcare Program"), Matchers.is(appointmentPage.getField("Healthcare Program")));
        MatcherAssert.assertThat(expectedData.get("Visit Date"), Matchers.is(appointmentPage.getField("Visit Date")));
        MatcherAssert.assertThat(expectedData.get("Comment"), Matchers.is(appointmentPage.getField("Comment")));
    }

    @And("I logout")
    public void iLogout() {
        appointmentPage.logout();
    }
}
