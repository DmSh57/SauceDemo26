package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test (priority = 1,
            description = "Проверка входа в систему с позитивными кредами",
            testName = "Проверка входа в систему с позитивными кредами",
            groups = {"smoke"})
    public void checkPositiveCred() {
        /*Проверка'Retry' System.out.println("Запуск теста checkPositiveCred");
        Assert.fail();*/
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(priority = 4,
            description = "Проверка входа в систему с пустым полем пароля",
            testName = "Проверка входа в систему с пустым полем пароля",
            groups = {"regression"})
    public void checkEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.gerErrorMessage(), "Epic sadface: Password is required");
    }

    @Test (priority = 3,
            description = "Проверка входа в систему с пустым полем юзер",
            testName = "Проверка входа в систему с пустым полем юзер",
            groups = {"regression"})
    public void checkEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.gerErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(priority = 2,
            description = "Проверка входа в систему с невалидными кредами",
            testName = "Проверка входа в систему с невалидными кредами",
            groups = {"regression"})
    public void checkNegativeCred() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(loginPage.gerErrorMessage(), "Epic sadface: Username and password do not match any " +
                "user in this service");
    }

    @DataProvider (name = "Тестовые данные для негативного тестирования", indices = {0, 2})
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test (dataProvider = "Тестовые данные для негативного тестирования")
    public void negativeLogin(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.gerErrorMessage(), errorMessage);
    }
}

