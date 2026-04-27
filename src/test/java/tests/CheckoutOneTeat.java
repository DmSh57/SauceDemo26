package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutOneTeat extends BaseTest {

    @Test
    public void checkEmptyFormError() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.clickContinue();
        assertEquals(checkoutOnePageCart.getErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void checkOnlyFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.writeForm("John", "", "");
        checkoutOnePageCart.clickContinue();
        assertEquals(checkoutOnePageCart.getErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void checkOnlyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.writeForm("", "Doe", "");
        checkoutOnePageCart.clickContinue();
        assertEquals(checkoutOnePageCart.getErrorMessage(), "Error: First Name is required");
    }

    @Test
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

