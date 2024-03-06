package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.demo.saucedemo.pages.components.common.HeaderMenuBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductListPageBase extends AbstractPage {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAddToCartBtnEnum(ProductName productName);

    public abstract void clickOnDropdownMenu(SortDropdown sortDropdown);

    public abstract boolean sortLowToHighPrice();

    public abstract boolean sortHighToLowPrice();

    public abstract boolean sortProductFromAToZ();

    public abstract HeaderMenuBase getHeader();
}
