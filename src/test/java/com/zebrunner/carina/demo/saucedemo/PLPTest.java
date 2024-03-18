package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.saucedemo.enums.SortType;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PLPTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-5")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void sortLowToHighTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.getHeaderMenu().isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.sortProduct(SortType.PRICE_LOW_TO_HIGH);
        Assert.assertTrue(productListPage.sortLowToHighPrice(), "Prices aren't sorted");
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-7")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void sortHighToLowTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.getHeaderMenu().isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.sortProduct(SortType.PRICE_HIGH_TO_LOW);
        Assert.assertTrue(productListPage.sortHighToLowPrice(), "Prices aren't sorted");
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-9")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void sortProductsFromAtoZTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.getHeaderMenu().isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.sortProduct(SortType.AZ);
        Assert.assertTrue(productListPage.sortProductFromAToZ(), "Product aren't sorted");
    }
}
