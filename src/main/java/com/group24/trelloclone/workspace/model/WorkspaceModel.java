package com.group24.trelloclone.workspace.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.user.model.UserModel;

@Entity(name = "workspaces")
public class WorkspaceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(targetEntity = UserModel.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("workspaces")
    private Set<UserModel> users;

    @OneToMany(targetEntity = BoardModel.class, cascade=CascadeType.ALL, orphanRemoval = true)
    private Set<BoardModel> boards;

    public WorkspaceModel(String name, String description, Set<UserModel> users) {
        this.name = name;
        this.description = description;
        this.users = users;
        this.boards = new HashSet<BoardModel>();
    }

    public WorkspaceModel(String name, String description) {
        this.name = name;
        this.description = description;
        this.boards = new HashSet<BoardModel>();
        this.users = new HashSet<UserModel>();
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

    public Set<UserModel> getUsers() {
        return users;
    }

    public void setUsers(Set<UserModel> users) {
        this.users = users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BoardModel> getBoards() {
        return boards;
    }

    public void setBoards(Set<BoardModel> boards) {
        this.boards = boards;
    }
}
