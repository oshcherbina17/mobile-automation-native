package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrawingTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "oshcherbina")
    @TestCaseKey("CR1-14")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void drawingAndComparePicturesTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        BurgerMenuPageBase burgerMenu = productListPage.clickOnBurgerMenu();
        DrawingPageBase drawingArea = burgerMenu.clickOnDrawingButton();
        Assert.assertTrue(drawingArea.isEmptyPadPresent(), "Drawing area isn't empty.");
        drawingArea.drawPicture();
        Assert.assertTrue(drawingArea.isDrawingPresent(), "There is no drawing.xml found.");
        drawingArea.clickOnClearBtn();
        Assert.assertTrue(drawingArea.isEmptyPadPresent(), "Drawing area isn't cleared");
    }
}
