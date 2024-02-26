package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase{

    @ExtendedFindBy(iosPredicate = "name == '%s'")
    protected ExtendedWebElement cartProductName;

    @ExtendedFindBy(iosPredicate = "name == 'test-REMOVE'")
    protected ExtendedWebElement removeProductFromCartBtn;

    @ExtendedFindBy(iosPredicate = "name == 'test-CHECKOUT'")
    protected ExtendedWebElement checkoutBtn;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductNameTextPresent(ProductName productName) {
        return cartProductName.format(productName.getProductType()).isElementPresent();
    }

    @Override
    public void removeProductFromCart(){
        removeProductFromCartBtn.click();
    }

    @Override
    public void removeProductFromCart(ProductName productName) {
        throw new NotImplementedException();
    }

    @Override
    public int getItemsListSize() {
        return 0;
    }

    @Override
    public CheckoutInfoPageBase clickOnCheckoutInfoBtn() {
        checkoutBtn.click();
        return initPage(getDriver(), CheckoutInfoPageBase.class);
    }
}
