package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {
    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductNameTextPresent(ProductName productName);

    public abstract void removeProductFromCart();

    public abstract void removeProductFromCart(ProductName productName);

    public abstract int getItemsListSize();

    public abstract CheckoutInfoPageBase clickOnCheckoutInfoBtn();
}
