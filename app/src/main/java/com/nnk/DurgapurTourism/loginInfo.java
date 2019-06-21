package com.nnk.DurgapurTourism;

public class loginInfo {

    String id;
    String Name;
    String EmailId;
    String password;

    public loginInfo()
    {

    }

    public loginInfo(String id, String name, String emailId, String password) {
        this.id = id;
        Name = name;
        EmailId = emailId;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getEmailId() {
        return EmailId;
    }

    public String getPassword() {
        return password;
    }
}
