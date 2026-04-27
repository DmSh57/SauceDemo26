package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckoutSecondTest extends BaseTest {

    @Test
    public void checkTotalPrice() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.writeForm("Dmitry", "Shapovalov", "12345");
        checkoutOnePageCart.clickContinue();
        assertTrue(checkoutSecondPageCart.getTotal().contains("Total"));
    }

    @Test
    public void finishCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.writeForm("Dmitry", "Shapovalov", "12345");
        checkoutOnePageCart.clickContinue();
        checkoutSecondPageCart.clickFinish();
        assertTrue(!checkoutFinalPage.getMessage().isEmpty());
    }
}

