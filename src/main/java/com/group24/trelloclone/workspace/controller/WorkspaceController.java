package com.group24.trelloclone.workspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group24.trelloclone.workspace.model.WorkspaceModel;
import com.group24.trelloclone.workspace.service.WorkspaceService;

@CrossOrigin()
@RestController
@RequestMapping("/workspace")
public class WorkspaceController {
    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping(path = "/save_workspace", consumes = "application/json", produces = "application/json" )
    public WorkspaceModel saveWorkspace(@RequestBody WorkspaceModel workspace){
        return workspaceService.saveWorkspace(workspace);
    }

    @GetMapping(path = "/get_all_workspaces")
    public List<WorkspaceModel> getAllWorkspaces(){
        return workspaceService.getAllWorkspaces();
    }
}
