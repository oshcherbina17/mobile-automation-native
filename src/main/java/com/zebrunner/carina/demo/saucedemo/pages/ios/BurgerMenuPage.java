package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BurgerMenuPageBase.class)
public class BurgerMenuPage extends BurgerMenuPageBase {

    @ExtendedFindBy(iosPredicate = "name == 'test-LOGOUT'")
    private ExtendedWebElement logoutBtn;

    @ExtendedFindBy(iosPredicate = "name == 'test-DRAWING'")
    private ExtendedWebElement drawingBtn;

    @ExtendedFindBy(iosPredicate = "name == 'test-Close'")
    private ExtendedWebElement closeBtn;

    @ExtendedFindBy(iosPredicate = "name == 'test-DRAWING'")
    private ExtendedWebElement drawingButton;

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
        drawingButton.click();
        return initPage(getDriver(), DrawingPageBase.class);
    }
}
