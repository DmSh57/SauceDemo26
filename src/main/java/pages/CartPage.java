package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By CHECKOUT_BTN = By.id("checkout");
    private final By REMOVE_BTN = By.cssSelector(".btn_secondary");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
    public void clickCheckout() {
        driver.findElement(CHECKOUT_BTN).click();
    }
    public void clickRemove() {
        driver.findElement(REMOVE_BTN).click();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}