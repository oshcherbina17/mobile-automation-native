package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPageBase extends AbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductNameTextPresent(ProductName productName);

    public abstract boolean isButtonPresent();

    public abstract void removeAllProductsFromCart();

    public abstract void removeProductsByNameFromCart(ProductName productName);

    public abstract CheckoutInfoPageBase clickOnCheckoutInfoBtn();

    public abstract List<String> getProductList();

    public abstract boolean compareProductTitles(List<String> productTitles);
}
