package com.group24.trelloclone.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.model.TaskRequestModel;
import com.group24.trelloclone.task.model.TaskStatusEnum;
import com.group24.trelloclone.task.repository.TaskRepository;
import com.group24.trelloclone.task.service.TaskService;
import com.group24.trelloclone.task.service.TaskServiceImpl;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.service.UserService;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTests {
	
	@Mock
	@Autowired
	private TaskRepository taskRepository;

	@Mock
	@Autowired
	private UserService userService;
	
	@InjectMocks
	private TaskService tasksServiceImpl = (TaskService) new TaskServiceImpl();

	private TaskModel task1;
	private TaskModel task2;
	private ArrayList<TaskModel> tasks=new ArrayList<TaskModel>();

	private long task1Id = 1;
	private TaskStatusEnum testStatus = TaskStatusEnum.DONE;

	private long userId = 1;
	private UserModel user;

	@BeforeEach
	public void setUp(){
		task1 = new TaskModel();
		task1.setId(task1Id);
		task2 = new TaskModel();
		tasks.add(task1);
		tasks.add(task2);
		user = new UserModel();
		user.setId(userId);
	}

	@Test
	public void createTaskTest() {
		TaskRequestModel request = new TaskRequestModel("Test", "Test description", new Date(), TaskStatusEnum.TO_DO);
		TaskModel task = TaskModel.create(request);
		Mockito.when(taskRepository.save(task)).thenReturn(task);
		TaskModel savedTask = tasksServiceImpl.createTask(request);
		Assertions.assertNotNull(savedTask);
	}
	@Test
	public void getAllTaskTest(){
		Mockito.when(taskRepository.findAll()).thenReturn(tasks);
		Assertions.assertEquals(tasks, tasksServiceImpl.getTasks());
	}
	@Test
	public void getTaskByIdTest(){
		Mockito.when(taskRepository.findById(task1Id)).thenReturn(Optional.of(task1));
		Assertions.assertEquals(task1, tasksServiceImpl.getTaskById(task1Id));
	}
	@Test
	public void deleteAllTaskTest(){
		Mockito.when(taskRepository.count()).thenReturn(0L);
		Assertions.assertTrue(tasksServiceImpl.deleteAllTasks());
	}
	@Test
	public void deleteTaskByIdTest(){
		Mockito.when(taskRepository.findById(task1Id)).thenReturn(Optional.of(task1)).thenReturn(Optional.empty());
		Assertions.assertEquals(task1, tasksServiceImpl.deleteTask(task1Id));
	}

	@Test
	public void assignTaskTest() throws InvalidUserIdException{
		Mockito.when(taskRepository.findById(task1Id)).thenReturn(Optional.of(task1));
		Mockito.when(userService.getUserById(userId)).thenReturn(user);
		task1.setAssignee(user);
		Mockito.when(taskRepository.save(task1)).thenReturn(task1);
		Assertions.assertTrue(tasksServiceImpl.assignTask(task1Id, userId));
	}

	@Test
    public void updateTaskStatusTest(){
		Mockito.when(taskRepository.findById(task1Id)).thenReturn(Optional.of(task1));
		task1.setStatus(testStatus);
		Mockito.when(taskRepository.save(task1)).thenReturn(task1);
		Assertions.assertTrue(tasksServiceImpl.updateTaskStatus(task1Id, testStatus));
	}
}
