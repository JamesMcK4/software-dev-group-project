package com.group24.trelloclone.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.group24.trelloclone.workspace.model.WorkspaceModel;

@Entity(name = "users")
public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String emailId;

    private String password;

    private String firstName;

    private String lastName;

    private int role;

    @ManyToMany(targetEntity = WorkspaceModel.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("users")
    private Set<WorkspaceModel> workspaces;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, String emailId, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        workspaces = new HashSet<WorkspaceModel>();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }


    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Set<WorkspaceModel> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(Set<WorkspaceModel> workspaces) {
        this.workspaces = workspaces;
    }

}