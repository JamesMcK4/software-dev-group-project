package com.group24.trelloclone.workspace.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.user.model.UserModel;

@Entity(name = "workspaces")
public class WorkspaceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(targetEntity = UserModel.class)
    private List<UserModel> users;

    @OneToMany(targetEntity = BoardModel.class)
    private List<BoardModel> boards;

    public WorkspaceModel(String name, String description, List<UserModel> users) {
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public WorkspaceModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public WorkspaceModel(){
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BoardModel> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardModel> boards) {
        this.boards = boards;
    }

    
}
