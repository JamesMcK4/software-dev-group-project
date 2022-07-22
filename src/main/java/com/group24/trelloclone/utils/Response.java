package com.group24.trelloclone.utils;

public enum Response {
    ID("id"), STATUS("status"), MESSAGE("message"), OBJECT("object"), VALIDATED("validated"), ERROR("error");

    private String value;

    Response(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
