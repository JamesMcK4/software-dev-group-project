package com.group24.trelloclone.board;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.group24.trelloclone.exception.InvalidBoardIdException;
import com.group24.trelloclone.exception.InvalidTaskIdException;
import com.group24.trelloclone.task.model.TaskRequestModel;
import com.group24.trelloclone.task.model.TaskStatusEnum;
import com.group24.trelloclone.task.service.TaskService;
import com.group24.trelloclone.task.service.TaskServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.board.repository.BoardRepository;
import com.group24.trelloclone.board.service.BoardService;
import com.group24.trelloclone.board.service.BoardServiceImpl;
import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.repository.TaskRepository;
import com.group24.trelloclone.task.service.TaskService;

@ExtendWith(MockitoExtension.class)
public class BoardServiceImplTests {
	
	@Mock
	@Autowired
	private BoardRepository boardRepository;
	@Mock
	@Autowired
	private TaskService taskService;
	
	@InjectMocks
	private BoardService boardsServiceImpl = new BoardServiceImpl();


	private BoardModel board;
	private BoardModel board2;
	private List<BoardModel> boards = new ArrayList<BoardModel>();
	private List<Long> boardIds = new ArrayList<Long>();
	private Long boardId = (long) 1;

	private TaskModel task1;

	private long taskId=(long) 1;

	@BeforeEach
	public void setUp() {
		board = new BoardModel("test board", "test description");
		board2 = new BoardModel("test board 2", "test 2 description");
		TaskRequestModel request = new TaskRequestModel("Test", "Test description", new Date(20220729), TaskStatusEnum.TO_DO);
		task1=TaskModel.create(request);
		boardId = (long) 1;
		board.setId((long) boardId);
		board2.setId((long) 2);
		boardIds.add((long)1);
		boardIds.add((long)2);
		boards.add(board);
		boards.add(board2);
		task1.setId((long)taskId);
	}

	@Test
	public void saveBoardTest(){
		Mockito.when(boardRepository.save(board)).thenReturn(board);
		Assertions.assertEquals(board, boardsServiceImpl.saveBoard(board));
	}

	@Test
	public void getBoardsTest(){
		Mockito.when(boardRepository.findAll()).thenReturn(boards);
		Assertions.assertEquals(boards, boardsServiceImpl.getBoards());
	}

	@Test
	public void getBoardsByIDTest(){
		Mockito.when(boardRepository.findAllById(boardIds)).thenReturn(boards);
		Assertions.assertEquals(boards, boardsServiceImpl.getBoardsByID(boardIds));
	}

	@Test
	public void getBoardByIdTest(){
		Mockito.when(boardRepository.findById(boardId)).thenReturn(Optional.of(board));
		Assertions.assertEquals(board, boardsServiceImpl.getBoardByID(boardId));
	}

	@Test
	public void deleteBoardTest(){
		Mockito.when(boardRepository.findById(boardId)).thenReturn(Optional.of(board)).thenReturn(Optional.empty());
		Assertions.assertEquals(board, boardsServiceImpl.deleteBoard(boardId));
	}

	@Test
	public void updateBoardNameTest(){

	}

	@Test
	public void updateBoardDescriptionTest(){

	}

	@Test
	public void deleteAllBoardsTest(){
		Mockito.when(boardRepository.count()).thenReturn((long)0);
		Assertions.assertTrue(boardsServiceImpl.deleteAllBoards());
	}
/*
	@Test
	public void addTask() throws InvalidBoardIdException, InvalidTaskIdException {
		Mockito.when(boardRepository.findById(boardId)).thenReturn(Optional.of(board));
		Mockito.when(taskService.getTaskById(taskId)).thenReturn(task1);
		board.getTasks().add(task1);
		Mockito.when(boardRepository.save(board)).thenReturn(board);
		Assertions.assertEquals(board, boardsServiceImpl.addTask(boardId, taskId));
	}

 */



}
