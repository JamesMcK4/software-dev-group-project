package com.group24.trelloclone.task.model;

import com.group24.trelloclone.user.model.UserModel;
import io.github.handsomecoder.utils.UUIDUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Entity(name = "tasks")
public class TaskModel {

    @Id
    private String id;

    private String name;

    private String description;

    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(insertable = false, updatable = false)
    private UserModel assignee;

    private TaskStatusEnum status;

    private Date createdOn;

    private Date lastUpdatedOn;

    public TaskModel(String name, String description) {
        this.id = UUIDUtils.generate();
        this.name = name;
        this.description = description;
        this.createdOn = new Date();
    }

    public TaskModel() {
    }

    public static TaskModel create(TaskRequestModel requestModel) {
        return new TaskModel(requestModel.getName(), requestModel.getDescription());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public UserModel getAssignee() {
        return assignee;
    }

    public void setAssignee(UserModel assignee) {
        this.assignee = assignee;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel taskModel = (TaskModel) o;
        return Objects.equals(id, taskModel.id) && Objects.equals(name, taskModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

