package com.group24.trelloclone.workspace.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.exception.UnableTooAddBoardException;
import com.group24.trelloclone.workspace.model.WorkspaceModel;
import com.group24.trelloclone.workspace.service.WorkspaceService;

import static com.group24.trelloclone.utils.ApplicationConstant.*;
import static java.util.Collections.singletonMap;
import static org.springframework.http.ResponseEntity.status;

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

    @PostMapping(path = "/update_workspace", consumes = "application/json", produces = "application/json" )
    public ResponseEntity<Map<String, Object>>  udpdateWorkspace(@RequestBody WorkspaceModel workspace){
        WorkspaceModel updatedWorkspace;
        try{
            updatedWorkspace = workspaceService.updateWorkspace(workspace);        
        }
        catch(Exception e){
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(OBJECT, null));
        }
        return status(HttpStatus.OK).body(singletonMap(OBJECT, updatedWorkspace));
    }

    @DeleteMapping("/delete_workspace/{id}")
    public WorkspaceModel deleteWorkspace(@PathVariable("id") Long workspaceId)
    {
        return workspaceService.deleteWorkspace(workspaceId);
    }

    @PostMapping(path = "/add_board/{id}", consumes = "application/json", produces = "application/json" )
    public ResponseEntity<Map<String, Object>> addBoard(@PathVariable("id") Long workspaceId, @RequestBody BoardModel board) throws UnableTooAddBoardException{
        WorkspaceModel workspace;
        try{
            workspace = workspaceService.addBoard(workspaceId, board);        
        }
        catch(Exception e){
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(OBJECT, null));
        }
        return status(HttpStatus.OK).body(singletonMap(OBJECT, workspace));
    }

    @PostMapping("/add_user/{workspace_id}/{user_id}")
    public ResponseEntity<Map<String, Object>> addUser(@PathVariable("workspace_id") Long workspaceId, @PathVariable("user_id") Long userId)
    {
        WorkspaceModel workspace;
        try{
            workspace = workspaceService.addUser(workspaceId, userId);  
        }
        catch(Exception e){
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(OBJECT, null));
        }
        return status(HttpStatus.OK).body(singletonMap(OBJECT, workspace));
    }

    @DeleteMapping(path = "/delete_all_users/{workspace_id}")
    public ResponseEntity<Map<String, Object>> deleteAllUsers(@PathVariable("workspace_id") Long workspaceId)
    {   
        try{
            workspaceService.deleteAllUsers(workspaceId);
        }
        catch(Exception e){
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(STATUS, false));
        }
        return status(HttpStatus.OK).body(singletonMap(STATUS, true));
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
