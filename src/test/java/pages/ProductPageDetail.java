package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageDetail extends BasePage {

    private final By TITLE = By.className("inventory_item_name ");
    private final By PRICE = By.className("inventory_details_price");
    private final By ADD_TO_CART = By.cssSelector(".btn_inventory");
    private final By BACK = By.id("back-to-products");

    public ProductPageDetail(WebDriver driver) {
        super(driver);
    }

    public String getTitleProduct() {
        return driver.findElement(TITLE).getText();
    }
    public String getPriceProduct() {
        return driver.findElement(PRICE).getText();
    }
    public void addToCart() {
        driver.findElement(ADD_TO_CART).click();
    }
    public void goBackPage() {
        driver.findElement(BACK).click();
    }
}

