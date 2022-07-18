package com.group24.trelloclone.task;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.model.TaskRequestModel;
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
	
	/*@Test
	/*public void createTaskTest() {
		TaskRequestModel request = new TaskModel("Test", "Test description","Assignee","dueOn");
		TaskModel task = TaskModel.create(request);
		Mockito.when(taskRepository.save(task)).thenReturn(task);
		TaskModel savedTask = tasksServiceImpl.createTask(request);
		assertNotNull(savedTask);
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
