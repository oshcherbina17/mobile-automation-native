package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLoginButtonPresent();

    public abstract boolean isLoginMessagePresent();

    public abstract ProductListPageBase login(String userName, String password);

    public abstract ProductListPageBase autofillLogin();
}
