package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSearchPage {
    By sorting = By.xpath("//span[@class='a-dropdown-prompt']");
    By lowToHigh = By.xpath("//a[@id='s-result-sort-select_1']");
    By brand = By.xpath("//li[@id='p_89/Calvin Klein']//i[@class='a-icon a-icon-checkbox']");
    By brandName = By.xpath("//div[2]/div[2]//h2//span");

    @And("Change sorting method")
    public void changeSortingMethod() {
        $(sorting).hover().click();
        $(lowToHigh).click();
        $(sorting).getText();
    }

    @Then("Verify that method changed")
    public void verifyThatMethodChanged() {
        assertEquals("Price: Low to High", $(sorting).getText());
    }

    @And("Choose brand")
    public void chooseBrand() {
        $(brand).hover().click();
    }

    @Then("Verify that brand has changed")
    public void verifyThatBrandHasChanged() {
        assertEquals("Calvin Klein womens Solid Sheath With Chiffon Bell Sleeves Dress", $(brandName).getText());
    }
}
