package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSecondPageCart extends BasePage {
    private final By TOTAL = By.className("summary_total_label");
    private final By FINISH_BTN = By.id("finish");

    public CheckoutSecondPageCart(WebDriver driver) {
        super(driver);
    }
    public String getTotal() {
        return driver.findElement(TOTAL).getText();
    }
    public void clickFinish() {
        driver.findElement(FINISH_BTN).click();
    }
}
