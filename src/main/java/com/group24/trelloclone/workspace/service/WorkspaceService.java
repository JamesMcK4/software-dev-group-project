package com.group24.trelloclone.workspace.service;

import java.util.List;

import com.group24.trelloclone.workspace.model.WorkspaceModel;

public interface WorkspaceService {
    WorkspaceModel saveWorkspace(WorkspaceModel workspace);
    public WorkspaceModel getWorkspaceById(Long userId);
    public List<WorkspaceModel> getAllWorkspaces();
    public WorkspaceModel deleteWorkspace(Long userId);
    public boolean deleteAllUsers();
    boolean addUser(Long workspaceId, Long userId);
    boolean addUsers(Long workspaceId, List<Long> usersId);
    boolean deleteUser(Long workspaceId, Long userId);
    boolean deleteUsers(Long workspaceId, List<Long> usersId);
    boolean updateWorkspaceName(Long workspaceId, String name);
    boolean updateWorkspaceDescription(Long workspaceId, String description);
    boolean addBoard(Long workspaceId, Long boardId);
    boolean deleteBoard(Long workspaceId, Long boardId);
}
