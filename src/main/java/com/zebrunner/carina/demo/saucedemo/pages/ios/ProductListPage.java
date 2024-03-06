package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.components.common.HeaderMenuBase;
import com.zebrunner.carina.demo.saucedemo.pages.components.ios.HeaderMenu;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='headerContainer']/parent::XCUIElementTypeOther")
    private HeaderMenu header;

    @ExtendedFindBy(iosPredicate = "name == 'test-Modal Selector Button'")
    private ExtendedWebElement filterBtn;

    @ExtendedFindBy(iosPredicate = "name == '%s'")
    private ExtendedWebElement sortDropdownBtn;

    @ExtendedFindBy(iosPredicate = "name == 'test-Price'")
    private List<ExtendedWebElement> priceList;

    @ExtendedFindBy(iosPredicate = "name == 'test-Item title'")
    private List<ExtendedWebElement> productNameList;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']/../following-sibling::*//XCUIElementTypeOther[@name='ADD TO CART']")
    private ExtendedWebElement addToCartBtn;

    @ExtendedFindBy(iosPredicate = "name == 'Terms of Service | Privacy Policy'")
    private ExtendedWebElement footerText;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickAddToCartBtnEnum(ProductName productName) {
        addToCartBtn.format(productName.getProductType()).click();
    }

    @Override
    public void clickOnDropdownMenu(SortDropdown sortDropdown) {
        filterBtn.click();
        sortDropdownBtn.format(sortDropdown.getSortType()).click();
    }

    private List<Double> getPricesList() {
        List<Double> pricesList = new ArrayList<>();
        while (!footerText.isElementPresent()) {
            List<Double> currentPrices = priceList.stream()
                    .map(element -> Double.parseDouble(element.getText().replace("$", "")))
                    .distinct()
                    .collect(Collectors.toList());

            currentPrices.forEach(price -> {
                if (!pricesList.contains(price)) {
                    pricesList.add(price);
                }
            });
            swipeUp(100);
        }
        return pricesList;
    }

    @Override
    public boolean sortLowToHighPrice() {
        List<Double> pricesList = getPricesList();
        return IntStream.range(0, pricesList.size() - 1)
                .allMatch(i -> pricesList.get(i) <= pricesList.get(i + 1));
    }

    @Override
    public boolean sortHighToLowPrice() {
        List<Double> pricesList = getPricesList();
        return IntStream.range(0, pricesList.size() - 1)
                .allMatch(i -> pricesList.get(i) >= pricesList.get(i + 1));
    }

    @Override
    public boolean sortProductFromAToZ() {
        List<String> newProductList = new ArrayList<>();
        for (ExtendedWebElement element : productNameList) {
            newProductList.add(element.getText());
        }
        List<String> bufferList = new ArrayList<>(newProductList);
        Collections.sort(bufferList);
        return newProductList.equals(bufferList);
    }

    @Override
    public HeaderMenuBase getHeader() {
        return header;
    }
}
