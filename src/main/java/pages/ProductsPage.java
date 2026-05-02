package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By ADD_TO_CART_BTN = By.cssSelector(".btn_inventory");
    private final By CART = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }
    public String getTitle() {
        return  driver.findElement(TITLE).getText();
    }
    public void addToCart() {
        driver.findElement(ADD_TO_CART_BTN).click();
    }
    public void openCart() {
        driver.findElement(CART).click();
    }
    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(By.cssSelector(".shopping_cart_badge")).isEmpty();
    }
}
