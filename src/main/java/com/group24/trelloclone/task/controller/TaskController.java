package com.group24.trelloclone.task.controller;

import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.model.TaskRequestModel;
import com.group24.trelloclone.task.model.TaskStatusEnum;
import com.group24.trelloclone.task.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.group24.trelloclone.utils.Response.*;
import static io.github.handsomecoder.utils.ObjectUtils.isNull;
import static io.github.handsomecoder.utils.StringUtils.isEmpty;
import static java.util.Collections.singletonMap;
import static org.springframework.http.ResponseEntity.status;

@CrossOrigin()
@RestController

@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create_task")
    public ResponseEntity<Map<String, Object>> createTask(@RequestBody TaskRequestModel request) {

        Map<String, Object> body;

        if (request.isEmpty()) {
            body = singletonMap(MESSAGE.getValue(), "Missing required fields: [name, description]");
            return status(HttpStatus.BAD_REQUEST).body(body);
        }

        TaskModel task = taskService.createTask(request);

        HttpStatus status = isNull(task) ? HttpStatus.CONFLICT : HttpStatus.CREATED;

        if (isNull(task)){
            body = singletonMap(MESSAGE.getValue(), "Task name already exists. Please choose another.");
        }
        else{
            body = singletonMap(OBJECT.getValue(), task);
        }

        return status(status).body(body);
    }

    @GetMapping("/get_all_tasks")
    public List<TaskModel> getTasks() {
        return taskService.getTasks();
    }

    @PutMapping("/assign_task/{taskId}") 
    public ResponseEntity<Map<String, Object>> assignTask(@PathVariable("taskId") String taskId,
        @RequestParam("userId") String userId) throws InvalidUserIdException {

        Map<String, Object> body;

        if (isEmpty(taskId)) {
            body = singletonMap(MESSAGE.getValue(), "Missing required field: [taskId]");
            return status(HttpStatus.BAD_REQUEST).body(body);
        }

        body = singletonMap(STATUS.getValue(), taskService.assignTask(Long.parseLong(taskId), Long.parseLong(userId)));

        return status(HttpStatus.OK).body(body);
    }

    @PutMapping("status/{taskId}")
    public ResponseEntity<Map<String, Object>> updateTaskStatus(@PathVariable("taskId") String taskId,
        @RequestParam("status") TaskStatusEnum status) {

        Map<String, Object> body;

        if (isEmpty(taskId)) {
            body = singletonMap(MESSAGE.getValue(), "Missing required field: [taskId]");
            return status(HttpStatus.BAD_REQUEST).body(body);
        }

        body = singletonMap(STATUS.getValue(), taskService.updateTaskStatus(Long.parseLong(taskId), status));

        return status(HttpStatus.OK).body(body);
    }

    @DeleteMapping("/delete_all_tasks")
    public boolean deleteAllTasks()
    {
        return taskService.deleteAllTasks();
    }
    
    @DeleteMapping("/delete_task/{taskId}")
    public ResponseEntity<Map<String, Object>> deleteTask(@PathVariable("taskId") String taskId)
    {
        Map<String, Object> body;

        if (isEmpty(taskId)) {
            body = singletonMap(MESSAGE.getValue(), "Missing required field: [taskId]");
            return status(HttpStatus.BAD_REQUEST).body(body);
        }

        body = singletonMap(OBJECT.getValue(), taskService.deleteTask(Long.parseLong(taskId)));

        return status(HttpStatus.OK).body(body);
    }
    @GetMapping("/get_task/{id}")
    public TaskModel getTaskById(@PathVariable("id") Long taskId)
    {
        TaskModel task = taskService.getTaskById(taskId);
        return task;
    }
}

