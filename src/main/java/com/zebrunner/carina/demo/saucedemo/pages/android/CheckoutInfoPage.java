package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutInfoPageBase.class)
public class CheckoutInfoPage extends CheckoutInfoPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    private ExtendedWebElement firsNameInput;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    private ExtendedWebElement lastNameInput;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    private ExtendedWebElement zipInput;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    private ExtendedWebElement continueBtn;

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUserInformation(String firstName, String lastName, String zip) {
        firsNameInput.type(firstName);
        lastNameInput.type(lastName);
        zipInput.type(zip);
    }

    @Override
    public CheckoutOverviewPageBase clickOnContinueBtn() {
        tap(24, 394);
        continueBtn.click();
        return initPage(getDriver(), CheckoutOverviewPageBase.class);
    }
}
