package com.zebrunner.carina.demo.saucedemo.pages.components.ios;


import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.components.common.HeaderMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HeaderMenu extends HeaderMenuBase {

    @ExtendedFindBy(iosPredicate = "name == 'test-Menu'")
    private ExtendedWebElement burgerMenu;

    @ExtendedFindBy(iosPredicate = "name == 'test-Cart'")
    private ExtendedWebElement cartBtn;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
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
        return burgerMenu.isElementPresent(Duration.ofSeconds(5));
    }
}
