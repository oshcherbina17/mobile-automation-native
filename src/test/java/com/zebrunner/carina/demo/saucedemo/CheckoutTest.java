package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.OrderCompletionPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-10")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void verifyCheckoutProcessTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.getHeader().isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.clickAddToCartBtnEnum(ProductName.BACKPACK);
        CartPageBase cartPage = productListPage.getHeader().clickOnCartBtn();
        Assert.assertTrue(cartPage.isProductNameTextPresent(ProductName.BACKPACK), "Product name isn't presented");
        CheckoutInfoPageBase checkoutInfoPage = cartPage.clickOnCheckoutInfoBtn();
        checkoutInfoPage.typeUserInformation("John","Snow", "345672");
        CheckoutOverviewPageBase checkoutOverviewPage = checkoutInfoPage.clickOnContinueBtn();
        Assert.assertTrue(checkoutOverviewPage.isTotalPricePresent(),"Total price isn't presented");
        OrderCompletionPageBase orderCompletionPage = checkoutOverviewPage.clickOnFinishBtn();
        Assert.assertTrue(orderCompletionPage.isCompleteTitlePresent(), "Title text isn't presented");
    }
}
