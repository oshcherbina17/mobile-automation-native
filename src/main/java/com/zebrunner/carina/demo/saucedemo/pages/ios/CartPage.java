package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(iosPredicate = "name == '%s'")
    private ExtendedWebElement cartProductName;

    @ExtendedFindBy(iosPredicate = "name == 'test-REMOVE'")
    private ExtendedWebElement removeProductFromCartBtn;

    @FindBy(xpath = "//*[@name='Sauce Labs Backpack']/../following-sibling::*[@name='test-Price']//*[@name='test-REMOVE']")
    private ExtendedWebElement removeByNameProductFromCartBtn;

    @ExtendedFindBy(iosPredicate = "name == 'test-CHECKOUT'")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductNameTextPresent(ProductName productName) {
        return cartProductName.format(productName.getProductType()).isElementPresent();
    }

    @Override
    public void removeAllProductsFromCart() {
        while (removeProductFromCartBtn.isElementPresent()) {
            removeProductFromCartBtn.click();
        }
    }

    public void removeProductsByNameFromCart(ProductName productName) {
        removeByNameProductFromCartBtn.format(productName.getProductType()).click();
    }

    @Override
    public CheckoutInfoPageBase clickOnCheckoutInfoBtn() {
        checkoutBtn.click();
        return initPage(getDriver(), CheckoutInfoPageBase.class);
    }
}
