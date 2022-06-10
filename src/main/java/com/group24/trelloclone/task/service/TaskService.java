package com.group24.trelloclone.task.service;

import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.model.TaskRequestModel;
import com.group24.trelloclone.task.model.TaskStatusEnum;
import com.group24.trelloclone.task.repository.TaskRepository;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static io.github.handsomecoder.utils.ObjectUtils.isNull;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public String createTask(TaskRequestModel request) {
        if (taskRepository.existsByName(request.getName())) {
            return null;
        }

        return taskRepository.save(TaskModel.create(request)).getId();
    }

    public List<TaskModel> getTasks() {
        return Streamable.of(taskRepository.findAll()).toList();
    }

    @Transactional
    public boolean assignTask(String taskId, Long userId) {

        UserModel user = userService.getUserById(userId);

        if (isNull(user)) {
            return false;
        }

        return taskRepository.assignTask(taskId, user) == 1;
    }

    @Transactional
    public boolean updateTaskStatus(String taskId, TaskStatusEnum status) {

//         TODO
//         Check whether task if there or not using findById
//         If task is not there return false
//         else update the task and return true on success
//
//         Perform update operation

        TaskModel task = taskRepository.getTaskById(taskId);

        if (isNull(task)) {
            return false;
        }

        return taskRepository.updateTaskStatus(taskId, status) == 1;
    }
}



