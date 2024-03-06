package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends AbstractPage {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void drawPicture();

    public abstract void clickOnClearBtn();

    public abstract boolean isEmptyPadPresent();

    public abstract boolean isDrawingPresent();
}
