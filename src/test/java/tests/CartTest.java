package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutOnePageCart;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {
    @Test
    public void checkCartTitle() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        assertEquals(cartPage.getTitle(), "Your Cart");
    }
    @Test
    public void removeProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.openCart();
        cartPage.clickRemove();
        productsPage.open();
        assertFalse(productsPage.isCartBadgeDisplayed(), "Cart badge should not be visible when cart is empty");
    }
    @Test
    public void goToCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.openCart();
        cartPage.clickCheckout();
        assertTrue(checkoutOnePageCart.getCurrentUrl().contains("checkout-step-one"));
    }
}
