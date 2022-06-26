package com.group24.trelloclone.workspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group24.trelloclone.workspace.model.WorkspaceModel;
import com.group24.trelloclone.workspace.service.WorkspaceService;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {
    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping(path = "/save_workspace", consumes = "application/json", produces = "application/json" )
    public WorkspaceModel saveWorkspace(@RequestBody WorkspaceModel workspace){
        return workspaceService.saveWorkspace(workspace);
    }
}
