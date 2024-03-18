package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.enums.MenuItems;
import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.ios.DrawingPage;
import com.zebrunner.carina.demo.saucedemo.pages.ios.LoginPage;
import org.apache.commons.lang3.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BurgerMenuPageBase.class)
public class BurgerMenuPage extends BurgerMenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutBtn;

    @ExtendedFindBy(accessibilityId = "test-DRAWING")
    private ExtendedWebElement drawingBtn;

    @ExtendedFindBy(accessibilityId = "test-Close")
    private ExtendedWebElement closeBtn;

    @ExtendedFindBy(accessibilityId = "%s")
    private ExtendedWebElement menuContent;

    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoutPresent() {
        return logoutBtn.isElementPresent(Duration.ofSeconds(3));
    }

    @Override
    public LoginPageBase clickOnLogoutBtn() {
        logoutBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public DrawingPageBase clickOnDrawingButton() {
        drawingBtn.click();
        return initPage(getDriver(), DrawingPageBase.class);
    }

    @Override
    public AbstractPage pickMenuContent(MenuItems item) {
        switch (item) {
            case DRAWING:
                menuContent.format(item.getAccessibilityId()).click();
                return new DrawingPage(getDriver());
            case LOGOUT:
                menuContent.format(item.getAccessibilityId()).click();
                return new LoginPage(getDriver());
            default:
                throw new NotImplementedException("Menu item " + item.getAccessibilityId() + " not implemented");
        }
    }
}
