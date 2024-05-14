package com.ajrdevops.crudspring.enums;

public enum Category {
    BACKEND("back-end"), FRONTEND("front-end"), FULLSTACK("full-stack");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // toString
    @Override
    public String toString() {
        return value;
    }
}
