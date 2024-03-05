package com.zebrunner.carina.demo.saucedemo.pages.components.android;


import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.components.common.HeaderMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class HeaderMenu extends HeaderMenuBase {

    @FindBy(xpath = "//*[@content-desc='test-Menu']")
    private ExtendedWebElement burgerMenu;

    @FindBy(xpath = "//*[@content-desc='test-Cart']")
    private ExtendedWebElement cartBtn;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPageBase clickOnCartBtn() {
        cartBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public BurgerMenuPageBase clickOnBurgerMenu() {
        burgerMenu.click();
        return initPage(getDriver(), BurgerMenuPageBase.class);

    }

    @Override
    public boolean isBurgerMenuPresent() {
        return burgerMenu.isElementPresent(Duration.ofSeconds(3));

    }
}