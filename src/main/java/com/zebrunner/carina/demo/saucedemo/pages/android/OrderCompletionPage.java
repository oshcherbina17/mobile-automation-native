package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.OrderCompletionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OrderCompletionPageBase.class)
public class OrderCompletionPage extends OrderCompletionPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    private ExtendedWebElement completeTitle;

    public OrderCompletionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCompleteTitlePresent() {
        return completeTitle.isElementPresent();
    }
}
