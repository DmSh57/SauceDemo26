package tests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutFinalTest extends BaseTest {

    @Test (
            description = "Финальное оформление товара",
            testName = "Финальное оформление товара")
    public void checkCompleteMessage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutOnePageCart.writeForm("Dmitry", "Shapovalov", "12345");
        checkoutOnePageCart.clickContinue();
        checkoutSecondPageCart.clickFinish();
        assertEquals(checkoutFinalPage.getMessage(), "Thank you for your order!");
    }
}

