package com.group24.trelloclone.task.model;

import static io.github.handsomecoder.utils.StringUtils.isAnyEmpty;

public class TaskRequestModel {

    private String name;

    private String description;

    public TaskRequestModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEmpty(){
        return isAnyEmpty(this.name, this.description);
    }
}

