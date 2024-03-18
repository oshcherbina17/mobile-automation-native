package com.zebrunner.carina.demo.saucedemo.pages.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductListItemComponentBase extends AbstractUIObject {
    public ProductListItemComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getItemTitle();

    public abstract void addToCartButton();
}
