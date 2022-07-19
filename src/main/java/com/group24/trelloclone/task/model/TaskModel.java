package com.group24.trelloclone.task.model;

import com.group24.trelloclone.user.model.UserModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Date;
import java.util.Objects;

@Entity(name = "tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String name;

    private String description;

    @ManyToOne(targetEntity = UserModel.class)
    private UserModel assignee;

    private TaskStatusEnum status;

    private Date createdOn;

    private Date dueOn;

    public TaskModel(String name, String description, Date dueOn, TaskStatusEnum status) {
        this.name = name;
        this.description = description;
        this.dueOn = dueOn;
        this.status = status;
    }

    public TaskModel() {
    }

    public static TaskModel create(TaskRequestModel requestModel) {
        return new TaskModel(requestModel.getName(), requestModel.getDescription(), requestModel.getDueOn(), requestModel.getStatus());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDueOn() {
        return dueOn;
    }

    public void setDueOn(Date dueOn) {
        this.dueOn = dueOn;
    }
}
//TODO
/*
 * Create task - name, description, due date, status
 * Board Id will be in a disable field.
 * /create-task/:boardId
 */

 //TODO
/*
 * Display board name - description.
 */

//TODO
/* Only display the tasks that belong to the board -> boardId.
 * Task name
 * Task description
 * Due date: 
 * Status:
 * Button (Change status -> redirect user to a page to change the status -> /change-task-status/:taskId)
 * If there is no assignee -> Have a button to assign a user to the task -> redirect to a new page -> /assign-member/:taskId
 * If there is an assignee -> display them.
 */