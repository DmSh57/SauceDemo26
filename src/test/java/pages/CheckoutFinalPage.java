package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutFinalPage extends BasePage {

    private final By COMPLETE_MESSAGE = By.className("complete-header");

    public CheckoutFinalPage(WebDriver driver) {
        super(driver);
    }
    public String getMessage() {
        return driver.findElement(COMPLETE_MESSAGE).getText();
    }
}
