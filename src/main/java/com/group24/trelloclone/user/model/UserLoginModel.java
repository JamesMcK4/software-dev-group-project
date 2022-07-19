package com.group24.trelloclone.user.model;

public class UserLoginModel
{
    private String emailId;

    private String password;

    public UserLoginModel(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public UserLoginModel(){
        
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}