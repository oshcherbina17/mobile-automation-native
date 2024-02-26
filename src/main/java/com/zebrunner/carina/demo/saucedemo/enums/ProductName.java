package com.zebrunner.carina.demo.saucedemo.enums;

public enum ProductName {
    BACKPACK("Sauce Labs Backpack"),
    LIGHT("Sauce Labs Bike Light"),
    T_SHIRT("Sauce Labs Bolt T-Shirt"),
    JACKET("Sauce Labs Fleece Jacket"),
    ONESIE("Sauce Labs Onesie"),
    T_SHIRT_RED("Test.allTheThings() T-Shirt (Red)");

    private String productType;

    ProductName(String productType) {
        this.productType = productType;

    }

    public String getProductType() {
        return productType;
    }
}
