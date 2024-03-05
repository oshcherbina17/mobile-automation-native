package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement cartProductName;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeProductFromCartBtn;

    @FindBy(xpath = "//*[contains(@text,'%s')]/../following-sibling::*[@content-desc='test-Price']//*[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeByNameProductFromCartBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT']")
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

    @Override
    public void removeProductsByNameFromCart(ProductName productName) {
        removeByNameProductFromCartBtn.format(productName.getProductType()).click();
    }

    @Override
    public CheckoutInfoPageBase clickOnCheckoutInfoBtn() {
        checkoutBtn.click();
        return initPage(getDriver(), CheckoutInfoPageBase.class);
    }
}
