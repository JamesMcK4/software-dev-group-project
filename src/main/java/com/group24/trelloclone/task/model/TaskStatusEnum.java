package com.group24.trelloclone.task.model;

public enum TaskStatusEnum {
    TO_DO("TO_DO"), DOING("DOING"), DONE("DONE");

    private String value;

    TaskStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

