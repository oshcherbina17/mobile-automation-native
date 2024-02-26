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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartTest implements IAbstractTest {
    LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
    ProductListPageBase productListPage = initPage(getDriver(), ProductListPageBase.class);

    @BeforeMethod
    public void loginTest() {
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        loginPage.autofillLogin();
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-6")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void addProductToCartTest() {
        productListPage.clickAddToCartBtnEnum(ProductName.BACKPACK);
        CartPageBase cartPage = productListPage.clickOnCartBtn();
        Assert.assertTrue(cartPage.isProductNameTextPresent(ProductName.BACKPACK), "Product name isn't presented");
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-8")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void removeProductsFromCartTest() {
        productListPage.clickAddToCartBtnEnum(ProductName.BACKPACK);
        CartPageBase cartPage = productListPage.clickOnCartBtn();
        Assert.assertTrue(cartPage.isProductNameTextPresent(ProductName.BACKPACK), "Product name isn't presented");
        cartPage.removeProductFromCart(ProductName.BACKPACK);
        Assert.assertFalse(cartPage.isProductNameTextPresent(ProductName.BACKPACK),"Product name is presented in the cart");
    }
}
