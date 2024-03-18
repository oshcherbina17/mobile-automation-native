package com.zebrunner.carina.demo.saucedemo.pages.components.android;

import com.zebrunner.carina.demo.saucedemo.enums.SortType;
import com.zebrunner.carina.demo.saucedemo.pages.components.common.FilterComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterComponent extends FilterComponentBase {

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortDropdownBtn;

    public FilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void sortBy(SortType sortType) {
        sortDropdownBtn.format(sortType.getSortType()).click();
    }
}
