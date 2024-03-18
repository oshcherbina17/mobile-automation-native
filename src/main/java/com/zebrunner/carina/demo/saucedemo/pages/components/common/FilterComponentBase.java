package com.zebrunner.carina.demo.saucedemo.pages.components.common;

import com.zebrunner.carina.demo.saucedemo.enums.SortType;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FilterComponentBase extends AbstractUIObject {
    public FilterComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void sortBy(SortType sortType);
}
