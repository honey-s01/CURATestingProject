package com.sparta.shs.steps;

import com.sparta.shs.pages.AppointmentPage;
import com.sparta.shs.pages.HomePage;
import com.sparta.shs.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sk.Tak;
import junit.framework.TestListener;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class loginSteps extends sharedSteps {

    public static WebDriver driver = getDriver();
    public String HOME_URL = "https://katalon-demo-cura.herokuapp.com/";
    private HomePage homePage;
    private LoginPage loginPage;
    protected static final Logger logger = Logger.getLogger(loginSteps.class.getName());

    public loginSteps(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Before
    public void before(){
        getDriver();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        BasicConfigurator.configure();
        logger.info("Launching ChromeDriver");
        logger.info("Navigating to home page");
        driver.get(HOME_URL);
    }

    @When("I click on make appointment")
    public void iClickOnMakeAppointment() {
        homePage.makeAppointment();
    }

    @Then("I should be on the login page")
    public void iShouldBeOnTheLoginPage() throws InterruptedException {
        screenshot(driver, System.currentTimeMillis());
        MatcherAssert.assertThat(getUrl(), Matchers.containsString("login"));
    }

    @When("I enter {string} as username")
    public void iEnterAsUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter {string} as password")
    public void iEnterAsPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click login")
    public void iClickLogin() {
        loginPage.clickLogin();
    }

    @Then("I should be on the appointment making page")
    public void iShouldBeOnTheAppointmentMakingPage() {
        screenshot(driver, System.currentTimeMillis());
        MatcherAssert.assertThat(getUrl(), Matchers.containsString("appointment"));
    }

    @Then("I should see a failed login message")
    public void iShouldSeeAFailedLoginMessage() {
        screenshot(driver, System.currentTimeMillis());
        MatcherAssert.assertThat(loginPage.getFailedMessage(), Matchers.containsString("failed"));
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

    @After
    public void after(){
        driver.manage().deleteAllCookies();
        driver.quit();
//        driver = null;
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }


}