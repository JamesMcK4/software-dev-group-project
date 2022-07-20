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

import static com.group24.trelloclone.utils.ApplicationConstant.*;
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

        if (request.isEmpty()) {
            return status(HttpStatus.BAD_REQUEST).body(singletonMap(MESSAGE, "Missing required fields: [name, description]"));
        }

        TaskModel task = taskService.createTask(request);

        HttpStatus status = isNull(task) ? HttpStatus.CONFLICT : HttpStatus.CREATED;

        Map<String, Object> body = isNull(task)? singletonMap(MESSAGE, "Task name already exists. Please choose another."): singletonMap(OBJECT, task);

        return status(status).body(body);
    }

    @GetMapping("/get_all_tasks")
    public List<TaskModel> getTasks() {
        return taskService.getTasks();
    }

    @PutMapping("/assign_task/{taskId}") 
    public ResponseEntity<Map<String, Object>> assignTask(@PathVariable("taskId") String taskId,
        @RequestParam("userId") Long userId) throws InvalidUserIdException {

        if (isEmpty(taskId)) {
            return status(HttpStatus.BAD_REQUEST).body(singletonMap(MESSAGE, "Missing required field: [taskId]"));
        }

        return status(HttpStatus.OK).body(singletonMap(STATUS, taskService.assignTask(Long.parseLong(taskId), userId)));
    }

    @PutMapping("status/{taskId}")
    public ResponseEntity<Map<String, Object>> updateTaskStatus(@PathVariable("taskId") String taskId,
        @RequestParam("status") TaskStatusEnum status) {
        if (isEmpty(taskId)) {
        return status(HttpStatus.BAD_REQUEST).body(singletonMap(MESSAGE, "Missing required field: [taskId]"));
        }

        return status(HttpStatus.OK).body(singletonMap(STATUS, taskService.updateTaskStatus(Long.parseLong(taskId), status)));
    }

    @DeleteMapping("/delete_all_tasks")
    public boolean deleteAllTasks()
    {
        return taskService.deleteAllTasks();
    }

    @DeleteMapping("/delete_task/{taskId}")
    public ResponseEntity<Map<String, Object>> deleteTask(@PathVariable("taskId") String taskId)
    {
        if (isEmpty(taskId)) {
            return status(HttpStatus.BAD_REQUEST).body(singletonMap(MESSAGE, "Missing required field: [taskId]"));
        }

        return status(HttpStatus.OK).body(singletonMap(OBJECT, taskService.deleteTask(Long.parseLong(taskId))));
    }
    @GetMapping("/get_task/{id}")
    public TaskModel getTaskById(@PathVariable("id") Long taskId)
    {
        TaskModel task = TaskService.getTaskById(taskId);
        return task;
    }
}

