package com.zebrunner.carina.demo.saucedemo.pages.components.ios;

import com.zebrunner.carina.demo.saucedemo.pages.components.common.ProductListItemComponentBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductListItemComponent extends ProductListItemComponentBase implements IMobileUtils {
    @ExtendedFindBy(accessibilityId = "test-Item title")
    private ExtendedWebElement titleText;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartBtn;

    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    @Override
    public String getItemTitle() {
        swipe(addToCartBtn, 2, 4000);
        return titleText.getText();
    }

    @Override
    public void addToCartButton() {
        swipe(addToCartBtn, 2, 4000);
        addToCartBtn.click();
    }
}
