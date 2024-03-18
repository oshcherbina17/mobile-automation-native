package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CartTest implements IAbstractTest {
    List<String> productTitles = Arrays.asList("Sauce Labs Bike Light", "Sauce Labs Backpack");

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-6")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void addProductToCartTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.getHeaderMenu().isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.addProductsToCart(productTitles);
        CartPageBase cartPage = productListPage.getHeaderMenu().clickOnCartBtn();
        Assert.assertTrue(cartPage.compareProductTitles(productTitles), "Product titles isn't presented");
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-8")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void removeProductsFromCartTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.getHeaderMenu().isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.addProductsToCart(productTitles);
        CartPageBase cartPage = productListPage.getHeaderMenu().clickOnCartBtn();
        Assert.assertTrue(cartPage.compareProductTitles(productTitles), "Product titles isn't presented");
        cartPage.removeAllProductsFromCart();
        Assert.assertFalse(cartPage.isButtonPresent(), "Remove button is presented in the cart");
    }
}
