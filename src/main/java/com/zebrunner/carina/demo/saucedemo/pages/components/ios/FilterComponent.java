package com.zebrunner.carina.demo.saucedemo.pages.components.ios;

import com.zebrunner.carina.demo.saucedemo.enums.SortType;
import com.zebrunner.carina.demo.saucedemo.pages.components.common.FilterComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class FilterComponent extends FilterComponentBase {

    @ExtendedFindBy(iosPredicate = "name == '%s'")
    private ExtendedWebElement sortDropdownBtn;

    public FilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void sortBy(SortType sortType) {
        sortDropdownBtn.format(sortType.getSortType()).click();
    }
}
