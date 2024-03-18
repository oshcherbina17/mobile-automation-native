package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.enums.SortType;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductListPageBase extends SauceAbstractPage {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addProductsToCart(List<String> productTitles);

    public abstract void sortProduct(SortType sortType);

    public abstract boolean sortLowToHighPrice();

    public abstract boolean sortHighToLowPrice();

    public abstract boolean sortProductFromAToZ();

    public abstract void openFilter();
}
