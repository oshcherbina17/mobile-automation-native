package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.enums.SortType;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.components.android.FilterComponent;
import com.zebrunner.carina.demo.saucedemo.pages.components.android.ProductListItemComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {

    @ExtendedFindBy (accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement filterBtn;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private List<ExtendedWebElement> productNameList;

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<ProductListItemComponent> productListItems;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private List<ExtendedWebElement> priceList;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'%s')]/following-sibling::*[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCartBtnEnum;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Terms of Service')]")
    private ExtendedWebElement footerText;

    @ExtendedFindBy(accessibilityId = "Selector container")
    private FilterComponent filterComponent;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

   @Override
    public void addProductsToCart(List<String> productTitles) {
        int maxIterations = 3;
        List<String> titles = new ArrayList<>();
        do {
            for (ProductListItemComponent productListItem : productListItems) {
                try {
                    String productTitle = productListItem.getItemTitle();
                    if (productTitles.contains(productTitle) && !titles.contains(productTitle)) {
                        titles.add(productTitle);
                        productListItem.addToCartButton();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } while (!swipe(footerText, Direction.UP, 2, 600) && --maxIterations != 0);

    }

    @Override
    public void sortProduct(SortType sortType) {
        openFilter();
        filterComponent.sortBy(sortType);
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

    public void openFilter() {
        filterBtn.click();
    }
}
