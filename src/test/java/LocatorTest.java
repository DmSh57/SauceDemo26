import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class LocatorTest {

    @Test
    public void checkLocator() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='user-name']"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
        driver.findElement(By.className("shopping_cart_link"));
        driver.findElement(By.tagName("a"));
        driver.findElement(By.linkText("Facebook"));
        driver.findElement(By.partialLinkText("Face"));
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//button[contains(@id,'add-to-cart')]"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//ancestor::div[@class='inventory_item']"));
        driver.findElement(By.xpath("//div[@class='inventory_list']//descendant::div[@class='inventory_item']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//following::button[1]"));
        driver.findElement(By.xpath("//button[text()='Add to cart']//parent::div"));
        driver.findElement(By.xpath("//button[text()='Add to cart']//preceding::div[1]"));
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn' and .='Open Menu']"));
        driver.findElement(By.cssSelector(".inventory_item"));
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector("#item_4_title_link"));
        driver.findElement(By.cssSelector("select"));
        driver.findElement(By.cssSelector("div.inventory_item"));
        driver.findElement(By.cssSelector("[data-test='inventory-item-name']"));
        driver.findElement(By.cssSelector("[class~='inventory_item']"));
        driver.findElement(By.cssSelector("div[data-test|='inventory']"));
        driver.findElement(By.cssSelector("[id^='add-to-cart']"));
        driver.findElement(By.cssSelector("[id$='backpack']"));
        driver.findElement(By.cssSelector("[class*='inventory']"));
        driver.quit();
    }
}
