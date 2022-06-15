package com.group24.trelloclone.task.service;

import java.util.List;

import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.model.TaskRequestModel;
import com.group24.trelloclone.task.model.TaskStatusEnum;

public interface TaskService {
    public String createTask(TaskRequestModel request);
    public List<TaskModel> getTasks();
    public TaskModel getTaskById(String taskId);
    public boolean assignTask(String taskId, Long userId) throws InvalidUserIdException;
    public boolean updateTaskStatus(String taskId, TaskStatusEnum status);
    public boolean deleteAllTasks();
}
