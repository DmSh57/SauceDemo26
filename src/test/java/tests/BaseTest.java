package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.*;
import utilits.TestListener;

import java.util.HashMap;
@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutOnePageCart checkoutOnePageCart;
    protected CheckoutSecondPageCart checkoutSecondPageCart;
    protected CheckoutFinalPage checkoutFinalPage;


    @Parameters ({"browser"})
    @BeforeMethod (alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            driver = new ChromeDriver(options);
            DriverManager.setDriver(driver);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            DriverManager.setDriver(driver);
        }

        loginPage = new LoginPage(DriverManager.getDriver());
        productsPage = new ProductsPage(DriverManager.getDriver());
        cartPage = new CartPage(DriverManager.getDriver());
        checkoutOnePageCart = new CheckoutOnePageCart(DriverManager.getDriver());
        checkoutSecondPageCart = new CheckoutSecondPageCart(DriverManager.getDriver());
        checkoutFinalPage = new CheckoutFinalPage(DriverManager.getDriver());
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
