package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BurgerMenuPageBase extends AbstractPage {

    public BurgerMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLogoutPresent();

    public abstract LoginPageBase clickOnLogoutBtn();

    public abstract DrawingPageBase clickOnDrawingButton();
}
