package com.group24.trelloclone.task.model;

import static io.github.handsomecoder.utils.StringUtils.isAnyEmpty;

import java.util.Date;

public class TaskRequestModel {

    private String name;

    private String description;

    private Date dueOn;

    private TaskStatusEnum status;

    public TaskRequestModel(String name, String description, Date dueOn, TaskStatusEnum status) {
        this.name = name;
        this.description = description;
        this.dueOn = dueOn;
        this.status = status;
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

    public Date getDueOn() {
        return dueOn;
    }

    public void setDueOn(Date dueOn) {
        this.dueOn = dueOn;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }
}

