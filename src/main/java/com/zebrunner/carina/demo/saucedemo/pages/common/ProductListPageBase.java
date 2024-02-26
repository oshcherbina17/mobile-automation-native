package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductListPageBase extends AbstractPage {
    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isBurgerMenuPresent();

    public abstract void clickAddToCartBtnEnum(ProductName productName);

    public abstract CartPageBase clickOnCartBtn();

    public abstract BurgerMenuPageBase clickOnBurgerMenu();

    public abstract void clickOnDropdownMenu(SortDropdown sortDropdown);

    public abstract boolean sortLowToHighPrice();

    public abstract boolean sortHighToLowPrice();

    public abstract boolean sortProductFromAToZ();
}
