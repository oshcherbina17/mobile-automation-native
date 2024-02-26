package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.OrderCompletionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase implements IMobileUtils {
    @FindBy(xpath = "//*[contains(@text,'Total:')]")
    protected ExtendedWebElement totalPrice;

    @FindBy(xpath = "//*[@text='FINISH']")
    protected ExtendedWebElement finishBtn;

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
}
