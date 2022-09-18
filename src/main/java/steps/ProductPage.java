package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductPage {
    By productSearchName = By.xpath("//span[normalize-space()='Windows 11 Home (Digital Download)']");
    By addToCart = By.id("add-to-cart-button");
    By dropDownField = By.xpath("//span[@id='a-autoid-0-announce']");
    By increaseAmount = By.xpath("//a[@id='quantity_1']");
    By checkAmount = By.xpath("//*[@id=\"nav-cart-count\"]");
    By questionSearchField = By.xpath("//input[@placeholder='Have a question? Search for answers']");
    By answer = By.xpath("//div[1]/div[1]/div[3]/div[1]/span[4]");

    @Then("Product {string} is displayed on the web page")
    public void productIsDisplayedOnTheWebPage(String productName) {
        assertEquals($(productSearchName).getText(), productName);
    }

    @And("Increase amount of product to 2")
    public void increaseAmountOfProduct() {
        $(dropDownField).hover().click();
        $(increaseAmount).click();
    }

    @And("Add this product to cart")
    public void addThisProductToCart() {
        $(addToCart).click();
    }

    @Then("Verify that appropriate amount of products are added to the cart")
    public void verifyThatAppropriateAmountOfProductsAreAddedToTheCart() {
        assertEquals("2", $(checkAmount).getText());
    }

    @And("Find answer on the following question {string}")
    public void findAnswerOnTheFollowingQuestion(String question) {
        $(byText("Explore More From Amazon Basics")).scrollTo();
        $(questionSearchField).setValue(question).sendKeys(Keys.ENTER);
    }

    @Then("Verify that answer equals {string}")
    public void verifyThatAnswerEquals(String commentAnswer) {
        assertEquals(commentAnswer, $(answer).getText());
    }
}
