package com.group24.trelloclone.workspace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.group24.trelloclone.workspace.service.WorkspaceService;
import com.group24.trelloclone.workspace.service.WorkspaceServiceImpl;
import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.board.service.BoardService;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.exception.InvalidWorkspaceIdException;
import com.group24.trelloclone.exception.UnableTooAddBoardException;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.service.UserService;
import com.group24.trelloclone.workspace.model.WorkspaceModel;
import com.group24.trelloclone.workspace.repository.WorkspaceRepository;;

@ExtendWith(MockitoExtension.class)
public class WorkspaceServiceImplTests {
	
	@Mock
	@Autowired
	private WorkspaceRepository workspaceRepository;

	@Mock
	@Autowired
	private BoardService boardService;

	@Mock
	@Autowired
	private UserService userService;
	
	@InjectMocks
	private WorkspaceService workspaceServiceImpl = new WorkspaceServiceImpl();

	private WorkspaceModel workspace;
	private BoardModel board;
	private UserModel user;
	private WorkspaceModel workspace2;
	private List<WorkspaceModel> workspaces = new ArrayList<WorkspaceModel>();
	private long workspaceId = 1;
	private long boardId = 1;
	private long userId = 1;
	private Set<BoardModel> boards = new HashSet<BoardModel>();

	@BeforeEach
	public void setUp() {
		workspace = new WorkspaceModel("sample workspace", "sample description");
		workspace2 = new WorkspaceModel("sample workspace 2", "sample description 2");
		board = new BoardModel();
		workspace.setId(workspaceId);
		Set<BoardModel> boards = new HashSet<BoardModel>();
		boards.add(board);
		workspaces.add(workspace);
		workspaces.add(workspace2);
		user = new UserModel("first name", "last name", "email", "password");
		user.setId(userId);
	}

	@Test
    public void deleteBoardTest(){
		workspace.setBoards(boards);
		Mockito.when(workspaceRepository.findById(workspaceId)).thenReturn(Optional.of(workspace));
		Mockito.when(boardService.getBoardByID(boardId)).thenReturn(board);
		workspace.getBoards().remove(board);
		Mockito.when(workspaceRepository.save(workspace)).thenReturn(workspace);
		Assertions.assertEquals(workspace, workspaceServiceImpl.deleteBoard(workspaceId, boardId));
	}

	@Test
    public void addBoardTest() throws UnableTooAddBoardException{
		Mockito.when(workspaceRepository.findById(workspaceId)).thenReturn(Optional.of(workspace));
		Mockito.when(boardService.saveBoard(board)).thenReturn(board);
		workspace.setBoards(boards);
		Mockito.when(workspaceRepository.save(workspace)).thenReturn(workspace);
		Assertions.assertEquals(workspace, workspaceServiceImpl.addBoard(workspaceId, board));
	}

	@Test
    public void getAllWorkspacesTest(){
		Mockito.when(workspaceRepository.findAll()).thenReturn(workspaces);
		Assertions.assertEquals(workspaces, workspaceServiceImpl.getAllWorkspaces());
	}

	@Test
    public void getWorkspaceByIdTest(){
		Mockito.when(workspaceRepository.findById(workspaceId)).thenReturn(Optional.of(workspace));
		Assertions.assertEquals(workspace, workspaceServiceImpl.getWorkspaceById(workspaceId));
	}

	@Test
    public void saveWorkspaceTest(){
		Mockito.when(workspaceRepository.save(workspace)).thenReturn(workspace);
		Assertions.assertEquals(workspace, workspaceServiceImpl.saveWorkspace(workspace));
	}

	@Test
	public void addUserTest() throws InvalidUserIdException, InvalidWorkspaceIdException{
		Mockito.when(workspaceRepository.findById(workspaceId)).thenReturn(Optional.of(workspace));
		Mockito.when(userService.getUserById(userId)).thenReturn(user);
		workspace.getUsers().add(user);
		Mockito.when(workspaceRepository.save(workspace)).thenReturn(workspace);
		Assertions.assertEquals(workspace, workspaceServiceImpl.addUser(workspaceId, userId));
	}

	@Test
	public void updateWorkspaceTest() throws InvalidWorkspaceIdException {
		Mockito.when(workspaceRepository.existsById(workspaceId)).thenReturn(true);
		Mockito.when(workspaceRepository.save(workspace)).thenReturn(workspace);
		Assertions.assertEquals(workspace, workspaceServiceImpl.updateWorkspace(workspace));
	}
}
