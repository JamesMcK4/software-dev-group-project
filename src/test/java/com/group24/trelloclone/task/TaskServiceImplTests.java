package com.group24.trelloclone.task;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.model.TaskRequestModel;
import com.group24.trelloclone.task.model.TaskStatusEnum;
import com.group24.trelloclone.task.repository.TaskRepository;
import com.group24.trelloclone.task.service.TaskService;
import com.group24.trelloclone.task.service.TaskServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTests {
	
	@Mock
	@Autowired
	private TaskRepository taskRepository;
	
	@InjectMocks
	private TaskService tasksServiceImpl = (TaskService) new TaskServiceImpl();

	private TaskModel task1;
	private TaskModel task2;
	private ArrayList<TaskModel> tasks=new ArrayList<TaskModel>();

	private long task1Id=1;

	@BeforeEach
	public void setUp(){
		TaskRequestModel request1 = new TaskRequestModel("Test1", "Test1 description", new Date(20220729), TaskStatusEnum.TO_DO);
		task1=TaskModel.create(request1);
		task1.setId(task1Id);
		TaskRequestModel request2 = new TaskRequestModel("Test1", "Test1 description", new Date(20220729), TaskStatusEnum.TO_DO);
		task2=TaskModel.create(request2);
		tasks.add(task1);
		tasks.add(task2);

	}
	@Test
	public void createTaskTest() {
		TaskRequestModel request = new TaskRequestModel("Test", "Test description", new Date(20220729), TaskStatusEnum.TO_DO);
		TaskModel task = TaskModel.create(request);
		Mockito.when(taskRepository.save(task)).thenReturn(task);
		TaskModel savedTask = tasksServiceImpl.createTask(request);
		assertNotNull(savedTask);
	}
	@Test
	public void getALlTaskTest(){
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
		assertTrue(tasksServiceImpl.deleteAllTasks());
	}
	@Test
	public void deleteTaskByIdTest(){
		Mockito.when(taskRepository.findById(task1Id)).thenReturn(Optional.of(task1)).thenReturn(Optional.empty());
		Assertions.assertEquals(task1, tasksServiceImpl.deleteTask(task1Id));

	}

	/* 
	@Test
	public void getAllTasksForBoardTest() {
		String boardTitle = "Test";
		List<Tasks> listOfTasks = taskRepository.getTasksInABoard(boardTitle);
		assertNotNull(listOfTasks);
	}
	
	
	@Test
	public void updateTasksTest() {
		Tasks t = new Tasks();
		Mockito.when(taskRepository.updateAssignee(anyString(), anyInt())).thenReturn(t);
		assertNotNull(t);
		t = tasksServiceImpl.updateAssigneeForTask(anyString(), anyInt());
		assertNotNull(t);
	}
*/
}
