package com.zebrunner.carina.demo.saucedemo.enums;

public enum SortDropdown {
    LOW_TO_HIGH("Price (low to high)"),
    HIGH_TO_LOW("Price (high to low)"),
    AZ("Name (A to Z)"),
    ZA("Name (Z to A)");

    private String sortType;

    SortDropdown(String sortType) {
        this.sortType = sortType;

    }

    public String getSortType() {
        return sortType;
    }
}
