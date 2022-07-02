package com.group24.trelloclone.workspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.exception.UnableTooAddBoardException;
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

    @DeleteMapping("/delete_workspace/{id}")
    public WorkspaceModel deleteWorkspace(@PathVariable("id") Long workspaceId)
    {
        return workspaceService.deleteWorkspace(workspaceId);
    }

    @PostMapping(path = "/add_board/{id}", consumes = "application/json", produces = "application/json" )
    public WorkspaceModel addBoard(@PathVariable("id") Long workspaceId, @RequestBody BoardModel board) throws UnableTooAddBoardException{
        return workspaceService.addBoard(workspaceId, board);
    }

    @DeleteMapping("/delete_board/{workspace_id}/{board_id}")
    public WorkspaceModel deleteBoard(@PathVariable("workspace_id") Long workspaceId, @PathVariable("board_id") Long boardId)
    {
        return workspaceService.deleteBoard(workspaceId, boardId);
    }

    @GetMapping(path = "/get_all_workspaces")
    public List<WorkspaceModel> getAllWorkspaces(){
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/get_workspace/{id}")
    public WorkspaceModel getWorkspaceById(@PathVariable("id") Long workspaceId)
    {
        WorkspaceModel workspace =  workspaceService.getWorkspaceById(workspaceId);
        return workspace;
    }
}
