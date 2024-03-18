package com.zebrunner.carina.demo.saucedemo.enums;

public enum MenuItems {
    DRAWING("test-DRAWING"),
    LOGOUT("test-LOGOUT");

    private String accessibilityId;

    MenuItems(String accessibilityId) {
        this.accessibilityId = accessibilityId;
    }

    public String getAccessibilityId() {
        return accessibilityId;
    }
}
