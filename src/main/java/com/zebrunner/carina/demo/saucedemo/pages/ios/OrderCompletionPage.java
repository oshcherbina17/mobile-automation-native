package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.OrderCompletionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = OrderCompletionPageBase.class)
public class OrderCompletionPage extends OrderCompletionPageBase {
    @ExtendedFindBy(iosPredicate = "name == 'THANK YOU FOR YOU ORDER'")
    protected ExtendedWebElement completeTitle;

    public OrderCompletionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCompleteTitlePresent() {
        return completeTitle.isElementPresent();
    }
}
