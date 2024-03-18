package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement loginInput;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordInput;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    @ExtendedFindBy(accessibilityId = "test-Error message")
    private ExtendedWebElement errorMessage;

    @ExtendedFindBy(accessibilityId = "test-standard_user")
    private ExtendedWebElement autofillUserBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return loginBtn.isElementPresent();
    }

    @Override
    public boolean isLoginButtonPresent() {
        return loginBtn.isElementPresent();
    }

    @Override
    public boolean isLoginMessagePresent() {
        return errorMessage.isElementPresent();
    }

    @Override
    public ProductListPageBase login(String userName, String password) {
        loginInput.type(userName);
        passwordInput.type(password);
        loginBtn.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public ProductListPageBase autofillLogin() {
        swipe(autofillUserBtn);
        autofillUserBtn.click();
        loginBtn.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

}
