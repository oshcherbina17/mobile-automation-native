package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.Setting;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-DRAWING-SCREEN")
    private ExtendedWebElement signaturePad;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CLEAR']")
    private ExtendedWebElement clearBtn;

    @ExtendedFindBy(image = "img/empty_drawing.png")
    private ExtendedWebElement emptyDrawing;

    @ExtendedFindBy(image = "img/drawingLine.png")
    private ExtendedWebElement drawing;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void drawPicture() {
        Point position = signaturePad.getLocation();
        Dimension size = signaturePad.getSize();
        int startX = position.x + size.width / 10;
        int startY = position.y + size.height / 10;
        int endX = startX * 5;
        tap(startX, startY);
        int pixelCount = 0;

        for (int i = 0; i < 5; i++) {
            swipe(startX, startY + pixelCount, endX, startY + pixelCount, 200);
            pixelCount += 10;
        }
    }

    @Override
    public void clickOnClearBtn() {
        clearBtn.click();
    }

    @Override
    public boolean isEmptyPadPresent() {
        setSetting(Setting.FIX_IMAGE_TEMPLATE_SCALE, true);
        setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.7);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return emptyDrawing.isElementPresent();
    }

    @Override
    public boolean isDrawingPresent() {
        setSetting(Setting.FIX_IMAGE_TEMPLATE_SCALE, true);
        setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.5);
        return drawing.isElementPresent();
    }
}
