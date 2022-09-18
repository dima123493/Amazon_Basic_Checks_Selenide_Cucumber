package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GiftPage {
    By textPresented = By.xpath("//span[text()='Giveaway']");

    @Then("Verify that {string} text is not presented on the webpage")
    public void verifyThatTetIsNotPresentedOnTheWebpage(String text) {
        assertFalse($(textPresented).isDisplayed());
    }
}
