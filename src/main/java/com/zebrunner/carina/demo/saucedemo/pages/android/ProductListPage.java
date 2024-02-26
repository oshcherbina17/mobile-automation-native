package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {
    @FindBy(xpath = "//*[@content-desc='test-Menu']")
    private ExtendedWebElement burgerMenu;

    @FindBy(xpath = "//*[@content-desc='test-Cart']")
    private ExtendedWebElement cartBtn;

    @FindBy(xpath = "//*[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement filterBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortDropdownBtn;

    @FindBy(xpath = "//*[@content-desc='test-Item title']")
    private List<ExtendedWebElement> productNameList;

    @FindBy(xpath = "//*[@content-desc='test-Price']")
    private List<ExtendedWebElement> priceList;

    @FindBy(xpath = "//*[contains(@text,'%s')]/following-sibling::*[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCartBtn;
    @FindBy(xpath = "//*[contains(@text,'Terms of Service')]")
    private ExtendedWebElement footerText;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isBurgerMenuPresent() {
        return burgerMenu.isElementPresent(Duration.ofSeconds(3));
    }

    @Override
    public void clickAddToCartBtnEnum(ProductName productName) {
        addToCartBtn.format(productName.getProductType()).click();

    }

    @Override
    public CartPageBase clickOnCartBtn() {
        cartBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public BurgerMenuPageBase clickOnBurgerMenu() {
        burgerMenu.click();
        return initPage(getDriver(), BurgerMenuPageBase.class);
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
            swipeUp(1000);
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
        List<String> newProductsList = new ArrayList<>();
        while (!footerText.isElementPresent()) {
            List<String> currentProducts = productNameList.stream()
                    .map(ExtendedWebElement::getText)
                    .distinct()
                    .collect(Collectors.toList());

            currentProducts.forEach(item -> {
                if (!newProductsList.contains(item)) {
                    newProductsList.add(item);
                }
            });

            swipeUp(3000);
        }

        List<String> sortedList = new ArrayList<>(newProductsList);
        sortedList.sort(String::compareTo);
        return newProductsList.equals(sortedList);
    }
}
