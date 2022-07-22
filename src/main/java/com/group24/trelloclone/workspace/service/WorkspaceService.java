package com.group24.trelloclone.workspace.service;

import java.util.List;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.exception.InvalidWorkspaceIdException;
import com.group24.trelloclone.exception.UnableTooAddBoardException;
import com.group24.trelloclone.workspace.model.WorkspaceModel;

public interface WorkspaceService {
    WorkspaceModel saveWorkspace(WorkspaceModel workspace);
    public WorkspaceModel getWorkspaceById(Long workspaceId);
    public List<WorkspaceModel> getAllWorkspaces();
    public WorkspaceModel deleteWorkspace(Long workspaceId);
    public boolean deleteAllUsers(Long workspaceId) throws InvalidWorkspaceIdException;
    public WorkspaceModel addUser(Long workspaceId, Long userId) throws InvalidWorkspaceIdException, InvalidUserIdException;
    public WorkspaceModel updateWorkspace(WorkspaceModel workspace) throws InvalidWorkspaceIdException;
    public WorkspaceModel addBoard(Long workspaceId, BoardModel board) throws UnableTooAddBoardException;
    public WorkspaceModel deleteBoard(Long workspaceId, Long boardId);
}
