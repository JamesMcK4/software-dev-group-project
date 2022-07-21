package com.group24.trelloclone.task.service;

import com.group24.trelloclone.exception.InvalidUserIdException;
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
import java.util.Optional;

import static io.github.handsomecoder.utils.ObjectUtils.isNull;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public TaskModel createTask(TaskRequestModel request) {
        if (taskRepository.existsByName(request.getName())) {
            return null;
        }

        return taskRepository.save(TaskModel.create(request));
    }

    public List<TaskModel> getTasks() {
        return Streamable.of(taskRepository.findAll()).toList();
    }

    @Override
    public TaskModel getTaskById(Long taskId){
        TaskModel task = null;
        Optional<TaskModel> optionalTask = taskRepository.findById(taskId);
        if(optionalTask.isPresent())
        {
            task = optionalTask.get();
        }
        return task;
    }

    @Transactional
    public boolean assignTask(Long taskId, Long userId) throws InvalidUserIdException {
        TaskModel task = getTaskById(taskId);
        UserModel assignee= userService.getUserById(userId);

        if (isNull(task) ||  isNull(assignee)) {
            return false;
        }

        task.setAssignee(assignee);
        taskRepository.save(task);

        return true;
    }

    @Transactional
    public boolean updateTaskStatus(Long taskId, TaskStatusEnum status) {

        TaskModel task = getTaskById(taskId);

        if (isNull(task)) {
            return false;
        }

        task.setStatus(status);
        taskRepository.save(task);

        return true;
    }

    public boolean deleteAllTasks(){
        taskRepository.deleteAll();
        if (taskRepository.count()==0){
            return true;
        }

        return false;
    }

    public TaskModel searchForTask(Long taskId){
        TaskModel task = getTaskById(taskId);
        //if(task == null){
        //throw an error
        //}
        return task;
    }
    
    @Override
    public TaskModel deleteTask(Long taskId) {
        TaskModel deletedTask = getTaskById(taskId);
		taskRepository.deleteById(taskId);
		if (!taskRepository.existsById(taskId)){
			return deletedTask;
		}

		return null;
    }
}



