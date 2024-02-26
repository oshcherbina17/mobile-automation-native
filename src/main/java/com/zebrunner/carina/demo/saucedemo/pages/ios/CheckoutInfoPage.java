package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutInfoPageBase.class)
public class CheckoutInfoPage extends CheckoutInfoPageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == 'test-First Name'")
    protected ExtendedWebElement firsNameInput;
    @ExtendedFindBy(iosPredicate = "name == 'test-Last Name'")
    protected ExtendedWebElement lastNameInput;
    @ExtendedFindBy(iosPredicate = "name == 'test-Zip/Postal Code'")
    protected ExtendedWebElement zipInput;
    @ExtendedFindBy(iosPredicate = "name == 'test-CONTINUE'")
    protected ExtendedWebElement continueBtn;

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
