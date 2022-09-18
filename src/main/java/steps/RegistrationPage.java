package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPage {
    By firstName = By.id("ap_customer_name");
    By email = By.id("ap_email");
    By password = By.id("ap_password");
    By passwordReminder = By.xpath("//*[contains(text(),'Passwords must be at least 6 characters.')]");
    By passwordCheck = By.id("ap_password_check");
    By submitButton = By.id("continue");
    By alreadyRegistered = By.xpath("//h4[normalize-space()='Email address already in use']");

    @When("Registration page {string} is opened")
    public void registrationPageIsOpened(String registrationPage) {
        open(registrationPage);
    }

    @And("Credentials are added to the fields and the Continue button is clicked")
    public void credentialsAreAddedToTheFieldsAndTheButtonIsClicked() {
        $(firstName).setValue("test");
        $(email).setValue("test@test.com");
        $(password).setValue("test1234");
        $(passwordCheck).setValue("test1234");
        $(submitButton).click();
    }

    @Then("Verify that user with same credentials already exists")
    public void verifyThatUserWithSameCredentialsAlreadyExists() {
        assertEquals($(alreadyRegistered).getText(), "Email address already in use");
    }

    @Then("Verify that there is a reminder that {string}")
    public void verifyThatThereIsAReminderThat(String passwordRem) {
        assertEquals($(passwordReminder).getText(), passwordRem);
    }
}
