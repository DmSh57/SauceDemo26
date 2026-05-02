package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test (
            description = "Открытие карточки товара",
            testName = "Открытие карточки товара")
    public void checkCartTitle() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        assertEquals(cartPage.getTitle(), "Your Cart");
    }

    @Test (
            description = "Удаление товара из корзины",
            testName = "Удаление товара из корзины")
    public void removeProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.openCart();
        cartPage.clickRemove();
        productsPage.open();
        assertFalse(productsPage.isCartBadgeDisplayed(), "Cart badge should not be visible when cart is empty");
    }

    @Test (
            description = "Добавление товара в корзину",
            testName = "Добавление товара в корзину")
    public void goToCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.openCart();
        cartPage.clickCheckout();
        assertTrue(checkoutOnePageCart.getCurrentUrl().contains("checkout-step-one"));
    }

    @Test (
            description = "Проверка входа в систему с пустым полем юзер",
            testName = "Проверка входа в систему с пустым полем юзер",
            groups = {"regression"})
    public void checkEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.gerErrorMessage(), "Epic sadface: Username is required");
    }
}
