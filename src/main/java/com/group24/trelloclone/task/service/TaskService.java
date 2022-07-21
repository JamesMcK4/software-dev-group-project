package com.group24.trelloclone.task.service;

import java.util.List;

import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.model.TaskRequestModel;
import com.group24.trelloclone.task.model.TaskStatusEnum;

public interface TaskService {
    public TaskModel createTask(TaskRequestModel request);
    public List<TaskModel> getTasks();
    public TaskModel getTaskById(Long taskId);
    public boolean assignTask(Long taskId, Long userId) throws InvalidUserIdException;
    public boolean updateTaskStatus(Long taskId, TaskStatusEnum status);
    public boolean deleteAllTasks();
    public TaskModel deleteTask(Long taskId);
}
