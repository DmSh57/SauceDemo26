package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutOneTeat extends BaseTest {

    @Test (
            description = "Проверка заполнения формы покупки товара с пустыми полями",
            testName = "Проверка заполнения формы покупки товара с пустыми полями ")
    public void checkEmptyFormError() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.clickContinue();
        assertEquals(checkoutOnePageCart.getErrorMessage(), "Error: First Name is required");
    }

    @Test (
            description = "Заполнение формы покупки товара с пустым полем фамилия",
            testName = "Заполнение формы покупки товара с пустым полем фамилия")
    public void checkOnlyFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.writeForm("John", "", "");
        checkoutOnePageCart.clickContinue();
        assertEquals(checkoutOnePageCart.getErrorMessage(), "Error: Last Name is required");
    }

    @Test (
            description = "Заполнение формы покупки товара с пустым полем имя",
            testName = "Заполнение формы покупки товара с пустым полем имя")
    public void checkOnlyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.writeForm("", "Doe", "");
        checkoutOnePageCart.clickContinue();
        assertEquals(checkoutOnePageCart.getErrorMessage(), "Error: First Name is required");
    }

    @Test (
            description = "Заполнение формы покупки товара с валидными данными",
            testName = "Заполнение формы покупки товара с валидными данными")
    public void checkSuccessfulForm() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.writeForm("Dmitry", "Shapovalov", "12345");
        checkoutOnePageCart.clickContinue();
        assertTrue(checkoutSecondPageCart.getTotal().contains("Total"));
    }
}

