package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.demo.saucedemo.pages.components.common.HeaderMenuBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CommonPageBase extends AbstractPage {
    public CommonPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderMenuBase getHeader();
}
