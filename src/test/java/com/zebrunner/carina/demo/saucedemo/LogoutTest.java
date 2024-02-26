package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-11")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLogout() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
        BurgerMenuPageBase burgerMenu = productListPage.clickOnBurgerMenu();
        Assert.assertTrue(burgerMenu.isLogoutPresent(), "Logout button isn't presented");
        burgerMenu.clickOnLogoutBtn();
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button isn't opened");
    }
}
