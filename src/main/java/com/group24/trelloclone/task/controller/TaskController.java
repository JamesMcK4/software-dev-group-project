package com.group24.trelloclone.task.controller;

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

import static com.group24.trelloclone.constant.ApplicationConstant.*;
import static io.github.handsomecoder.utils.ObjectUtils.isNull;
import static io.github.handsomecoder.utils.StringUtils.isEmpty;
import static java.util.Collections.singletonMap;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("")
    public ResponseEntity<Map<String, String>> createTask(@RequestBody TaskRequestModel request) {

        if (request.isEmpty()) {
            return status(HttpStatus.BAD_REQUEST).body(singletonMap(MESSAGE, "Missing required fields: [name, description]"));
        }

        String id = taskService.createTask(request);

        HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;

        return status(status).body(singletonMap(ID, id));
    }

    @GetMapping("")
    public List<TaskModel> getTasks() {
        return taskService.getTasks();
    }

    @PutMapping("{taskId}")
    public ResponseEntity<Map<String, Object>> assignTask(@PathVariable("taskId") String taskId,
                                                          @RequestParam("userId") Long userId) {

        if (isEmpty(taskId)) {
            return status(HttpStatus.BAD_REQUEST).body(singletonMap(MESSAGE, "Missing required field: [taskId]"));
        }

        return status(HttpStatus.OK).body(singletonMap(STATUS, taskService.assignTask(taskId, userId)));
    }

    @PutMapping("status/{taskId}")
    public ResponseEntity<Map<String, Object>> updateTaskStatus(@PathVariable("taskId") String taskId,
                                                                @RequestParam("status") TaskStatusEnum status) {
//         TODO
//         Validate request parameters
//         Need to return message Missing required field: [taskId]
//
//         Perform update operation

        return status(HttpStatus.CREATED).body(null);
    }
}

