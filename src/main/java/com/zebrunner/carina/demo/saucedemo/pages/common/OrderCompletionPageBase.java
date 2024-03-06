package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OrderCompletionPageBase extends AbstractPage {

    public OrderCompletionPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCompleteTitlePresent();
}
