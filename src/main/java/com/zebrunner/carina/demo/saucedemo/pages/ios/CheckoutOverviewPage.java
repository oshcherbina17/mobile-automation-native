package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.OrderCompletionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase implements IMobileUtils {

    @FindBy( xpath = "//XCUIElementTypeStaticText[contains(@name,'Total')]")
    private ExtendedWebElement totalPrice;

    @ExtendedFindBy(iosPredicate = "name == 'test-FINISH'")
    private ExtendedWebElement finishBtn;

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
