package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.CommonPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.components.android.HeaderMenu;
import com.zebrunner.carina.demo.saucedemo.pages.components.common.HeaderMenuBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommonPageBase.class)
public class AndroidCommonPage extends CommonPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/parent::android.view.ViewGroup")
    private HeaderMenu header;

    public AndroidCommonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderMenuBase getHeader() {
        return header;
    }

}
