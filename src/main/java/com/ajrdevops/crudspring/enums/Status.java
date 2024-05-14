package com.ajrdevops.crudspring.enums;

public enum Status {
    ACTIVE("ativo"), INACTIVE("inativo");

    private String value;

    Status(String value) {
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
