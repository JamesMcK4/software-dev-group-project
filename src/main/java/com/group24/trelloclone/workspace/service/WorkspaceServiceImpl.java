package com.group24.trelloclone.workspace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.board.service.BoardService;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.exception.InvalidWorkspaceIdException;
import com.group24.trelloclone.exception.UnableTooAddBoardException;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.service.UserService;
import com.group24.trelloclone.workspace.model.WorkspaceModel;
import com.group24.trelloclone.workspace.repository.WorkspaceRepository;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Override
    public WorkspaceModel saveWorkspace(WorkspaceModel workspace) {
        return workspaceRepository.save(workspace);
    }

    @Override
    public WorkspaceModel getWorkspaceById(Long workspaceId) {
        WorkspaceModel workspace = null;
        Optional<WorkspaceModel> optionalWorkspace = workspaceRepository.findById(workspaceId);

        if(optionalWorkspace.isPresent())
        {
            workspace = optionalWorkspace.get();
        }

        return workspace;
    }

    @Override
    public List<WorkspaceModel> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }

    @Override
    public WorkspaceModel deleteWorkspace(Long workspaceId) {
        WorkspaceModel workspace = getWorkspaceById(workspaceId);
        workspaceRepository.delete(workspace);
        return workspace;
    }

    @Override
    public boolean deleteAllUsers(Long workspaceId) throws InvalidWorkspaceIdException {
        WorkspaceModel workspace = getWorkspaceById(workspaceId);
        if (workspace == null){
            throw new InvalidWorkspaceIdException();
        }
        for (UserModel user : workspace.getUsers()) {
            for (WorkspaceModel userWorkspace: user.getWorkspaces()){
                if (userWorkspace.getId() == workspaceId){
                    user.getWorkspaces().remove(userWorkspace);
                    try {
                        userService.updateUser(user);
                    } catch (InvalidUserIdException e) {
                        return false;
                    }
                    break;
                }
            }
        }
        workspace.getUsers().clear();
        if (workspace.getUsers().size()==0){
            workspaceRepository.save(workspace);
            return true;
        }
        return false;
    }

    @Override
    public WorkspaceModel addUser(Long workspaceId, Long userId) throws InvalidWorkspaceIdException, InvalidUserIdException{
        WorkspaceModel workspace = getWorkspaceById(workspaceId);
        if (workspace == null){
            throw new InvalidWorkspaceIdException();
        }

        UserModel user = userService.getUserById(userId);
        if (user == null){
            throw new InvalidUserIdException();
        }

        workspace.getUsers().add(user);
        user.getWorkspaces().add(workspace);
        userService.updateUser(user);

        return workspaceRepository.save(workspace);
    }

    @Override
    public WorkspaceModel addUsers(Long workspaceId, List<Long> usersId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WorkspaceModel deleteUser(Long workspaceId, Long userId) {
        return null;
    }

    @Override
    public WorkspaceModel deleteUsers(Long workspaceId, List<Long> usersId) {
        // TODO Auto-generated method stub
        return null;
    }

    // TODO refactoring
    @Override
    public WorkspaceModel addBoard(Long workspaceId, BoardModel board) throws UnableTooAddBoardException {
        WorkspaceModel workspace = getWorkspaceById(workspaceId);
        BoardModel savedBoard = boardService.saveBoard(board);
        if (workspace != null && savedBoard != null){
            workspace.getBoards().add(savedBoard);
        }
        else{
            throw new UnableTooAddBoardException();
        }
        return workspaceRepository.save(workspace);
    }

    // saveBoard(BoardModel) - BoardService -> calls workspaceService.addBoard()

    @Override
    public WorkspaceModel deleteBoard(Long workspaceId, Long boardId) {
        WorkspaceModel workspace = getWorkspaceById(workspaceId);
        if (workspace != null){
            BoardModel deletedBoard = boardService.getBoardByID(boardId);
            workspace.getBoards().remove(deletedBoard);
        }
        return workspaceRepository.save(workspace);
    }

    @Override
    public WorkspaceModel addBoard(Long workspaceId, Long boardId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WorkspaceModel updateWorkspaceName(Long workspaceId, String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WorkspaceModel updateWorkspaceDescription(Long workspaceId, String description) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WorkspaceModel updateWorkspace(WorkspaceModel workspace) throws InvalidWorkspaceIdException {
        if (workspaceRepository.existsById(workspace.getId())){
            workspace = workspaceRepository.save(workspace);
        }
        else{
            throw new InvalidWorkspaceIdException();
        }

        return workspace;
    }
}
