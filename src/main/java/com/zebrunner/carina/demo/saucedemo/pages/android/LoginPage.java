package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(xpath = "//*[@content-desc='test-Username']")
    private ExtendedWebElement loginInput;

    @FindBy(xpath = "//*[@content-desc='test-Password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//*[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//*[@content-desc='test-Error message']")
    private ExtendedWebElement errorMessage;

    @FindBy(xpath = "//*[@text='standard_user']")
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
