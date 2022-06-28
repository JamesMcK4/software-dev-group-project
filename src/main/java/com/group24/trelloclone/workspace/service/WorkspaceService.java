package com.group24.trelloclone.workspace.service;

import java.util.List;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.exception.UnableTooAddBoardException;
import com.group24.trelloclone.workspace.model.WorkspaceModel;

public interface WorkspaceService {
    WorkspaceModel saveWorkspace(WorkspaceModel workspace);
    public WorkspaceModel getWorkspaceById(Long workspaceId);
    public List<WorkspaceModel> getAllWorkspaces();
    public WorkspaceModel deleteWorkspace(Long workspaceId);
    public boolean deleteAllUsers();
    public WorkspaceModel addUser(Long workspaceId, Long userId);
    public WorkspaceModel addUsers(Long workspaceId, List<Long> usersId);
    public WorkspaceModel deleteUser(Long workspaceId, Long userId);
    public WorkspaceModel deleteUsers(Long workspaceId, List<Long> usersId);
    public WorkspaceModel updateWorkspaceName(Long workspaceId, String name);
    public WorkspaceModel updateWorkspaceDescription(Long workspaceId, String description);
    public WorkspaceModel addBoard(Long workspaceId, Long boardId);
    public WorkspaceModel addBoard(Long workspaceId, BoardModel board) throws UnableTooAddBoardException;
    public WorkspaceModel deleteBoard(Long workspaceId, Long boardId);
}
