package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOnePageCart extends BasePage {

    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By ZIP = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR = By.cssSelector("[data-test=error]");

    public CheckoutOnePageCart(WebDriver driver) {
        super(driver);
    }
    public void writeForm(String firstName, String lastName, String zip) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP).sendKeys(zip);
    }
    public void clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
    }
    public String getErrorMessage() {
        return driver.findElement(ERROR).getText();
    }
}
