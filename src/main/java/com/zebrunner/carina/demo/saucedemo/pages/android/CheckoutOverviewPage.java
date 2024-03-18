package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.OrderCompletionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Total:')]")
    private ExtendedWebElement totalPrice;
    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Tax:')]")
    private ExtendedWebElement taxPrice;

    @ExtendedFindBy(accessibilityId = "test-FINISH")
    private ExtendedWebElement finishBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Price']//android.widget.TextView")
    private List<ExtendedWebElement> productPrices;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTotalPricePresent() {
        swipe(totalPrice);
        return totalPrice.isElementPresent();
    }

    @Override
    public OrderCompletionPageBase clickOnFinishBtn() {
        finishBtn.click();
        return initPage(getDriver(), OrderCompletionPageBase.class);
    }

    @Override
    public double overallProductPrice() {
        double result = 0.0d;

        for (ExtendedWebElement productPrice : productPrices) {
            result += Double.parseDouble(productPrice.getText().replace("$", ""));
        }
        swipe(finishBtn);
        return result;
    }

    @Override
    public double getTotalPrice() {
        BigDecimal totalPriceValue = new BigDecimal(totalPrice.getText().replace("Total: $", ""));
        BigDecimal taxPriceValue = new BigDecimal(taxPrice.getText().replace("Tax: $", ""));
        BigDecimal result = totalPriceValue.subtract(taxPriceValue);
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
