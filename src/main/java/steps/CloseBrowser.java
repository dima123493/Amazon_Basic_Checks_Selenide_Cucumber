package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class CloseBrowser {
    @After
    public void tearDown() {
        WebDriverRunner.getWebDriver().close();
    }
}
