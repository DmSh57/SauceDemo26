package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void checkPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void checkEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.gerErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void checkEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.gerErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void checkNegativeCred() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(loginPage.gerErrorMessage(), "Epic sadface: Username and password do not match any " +
                "user in this service");
    }
}

