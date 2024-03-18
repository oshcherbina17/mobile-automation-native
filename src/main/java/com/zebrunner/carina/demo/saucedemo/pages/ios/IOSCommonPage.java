package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.CommonPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.components.ios.HeaderMenu;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CommonPageBase.class)
public class IOSCommonPage extends CommonPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='headerContainer']/parent::XCUIElementTypeOther")
    private HeaderMenu header;

    public IOSCommonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderMenu getHeader() {
        return header;
    }

}
