package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.*;

public class BasePage {
    By searchBar = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By changeCountryOfDelivery = By.id("glow-ingress-line2");
    By countryField = By.xpath("//span[@id='GLUXCountryValue']");
    By changeToUganda = By.id("GLUXCountryList_230");
    By button = By.xpath("//button[@name='glowDoneButton']");
    By signInButton = By.xpath("//a[@class='a-button-text']");

    @When("Input product name {string} into the search bar")
    public void inputProductNameIntoTheSearchBar(String productName) {
        $(searchBar).setValue(productName);
    }

    @And("Click the \"Search\" button")
    public void searchButtonClicked() {
        $(searchButton).click();
    }

    @And("User can choose new location")
    public void userCanChooseLocationToUganda() {
        $(changeCountryOfDelivery).hover().click();
        $(countryField).hover().click();
        $(changeToUganda).click();
        $(button).click();
        $(changeCountryOfDelivery).getText();
    }

    @Then("Verify that location has changed")
    public void verifyThatLocationHasChanged() {
        $(changeCountryOfDelivery).shouldBe(Condition.exactText("Uganda"), Duration.ofSeconds(10));
        assertEquals("Uganda", $(changeCountryOfDelivery).getText());
    }

    @Then("Verify that \"Sign in securely\" button is displayed")
    public void verifyThatButtonIsDisplayed() {
        assertTrue($(signInButton).isDisplayed());
        assertFalse($(signInButton).getText().equals("Login"));
    }
}
