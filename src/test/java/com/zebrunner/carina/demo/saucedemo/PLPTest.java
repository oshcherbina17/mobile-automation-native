package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PLPTest implements IAbstractTest {

    LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

    ProductListPageBase productListPage = initPage(getDriver(), ProductListPageBase.class);

    @BeforeMethod
    public void loginTest() {
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        loginPage.autofillLogin();
        Assert.assertTrue(productListPage.getHeader().isBurgerMenuPresent(), "Burger menu isn't presented");
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-5")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void sortLowToHighTest() {
        productListPage.clickOnDropdownMenu(SortDropdown.LOW_TO_HIGH);
        Assert.assertTrue(productListPage.sortLowToHighPrice(), "Prices aren't sorted");
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-7")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void sortHighToLowTest() {
        productListPage.clickOnDropdownMenu(SortDropdown.HIGH_TO_LOW);
        Assert.assertTrue(productListPage.sortHighToLowPrice(), "Prices aren't sorted");
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-9")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void sortProductsFromAtoZTest() {
        productListPage.clickOnDropdownMenu(SortDropdown.AZ);
        Assert.assertTrue(productListPage.sortProductFromAToZ(), "Product aren't sorted");
    }
}
