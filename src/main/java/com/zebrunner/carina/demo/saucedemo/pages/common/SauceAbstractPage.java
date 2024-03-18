package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.demo.saucedemo.pages.components.common.HeaderMenuBase;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SauceAbstractPage extends AbstractPage implements IMobileUtils {

    public SauceAbstractPage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenuBase getHeaderMenu() {
       return initPage(getDriver(), CommonPageBase.class).getHeader();
    }
}
