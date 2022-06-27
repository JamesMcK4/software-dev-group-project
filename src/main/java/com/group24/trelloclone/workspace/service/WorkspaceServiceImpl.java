package com.group24.trelloclone.workspace.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group24.trelloclone.workspace.model.WorkspaceModel;
import com.group24.trelloclone.workspace.repository.WorkspaceRepository;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Override
    public WorkspaceModel saveWorkspace(WorkspaceModel workspace) {
        return workspaceRepository.save(workspace);
    }

    @Override
    public WorkspaceModel getWorkspaceById(Long userId) {
        WorkspaceModel space1=null;
        Optional<WorkspaceModel> op1=workspaceRepository.findById(userId);
        if (op1.isPresent()){
            space1=op1.get();
        }
        return space1;
    }

    @Override
    public List<WorkspaceModel> getAllWorkspaces() {
       return workspaceRepository.findAll();
    }

    @Override
    public WorkspaceModel deleteWorkspace(Long userId) {
        WorkspaceModel m1=workspaceRepository.getById(userId);
        workspaceRepository.delete(m1);
        return m1;
    }

    @Override
    public boolean deleteAllUsers() {


    }

    @Override
    public boolean addUser(Long workspaceId, Long userId) {

        return false;
    }

    @Override
    public boolean addUsers(Long workspaceId, List<Long> usersId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUser(Long workspaceId, Long userId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUsers(Long workspaceId, List<Long> usersId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateWorkspaceName(Long workspaceId, String name) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateWorkspaceDescription(Long workspaceId, String description) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addBoard(Long workspaceId, Long boardId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteBoard(Long workspaceId, Long boardId) {
        // TODO Auto-generated method stub
        return false;
    }
}
