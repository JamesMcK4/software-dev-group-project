package com.group24.trelloclone.utils;

public enum Response {
    ID("ID"), STATUS("STATUS"), MESSAGE("MESSAGE"), OBJECT("object"), VALIDATION_STATUS("validated"), ERROR("error");

    //TODO change ApplicationConstant to enum.
    private String value;

    Response(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
