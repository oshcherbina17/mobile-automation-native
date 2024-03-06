package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BurgerMenuPageBase.class)
public class BurgerMenuPage extends BurgerMenuPageBase {

    @FindBy(xpath = "//*[@text='LOGOUT']")
    private ExtendedWebElement logoutBtn;

    @FindBy(xpath = "//*[@content-desc='test-DRAWING']")
    private ExtendedWebElement drawingBtn;

    @FindBy(xpath = "*[@content-desc='test-Close']")
    private ExtendedWebElement closeBtn;

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
}
