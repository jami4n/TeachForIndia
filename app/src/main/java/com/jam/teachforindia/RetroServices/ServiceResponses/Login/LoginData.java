package com.jam.teachforindia.RetroServices.ServiceResponses.Login;

/**
 * Created by Jam on 21-02-2018.
 */

public class LoginData {

    String userid;
    String email;
    String password;
    String role;
    String firstname;
    String usertitle;

    public LoginData(String userid, String email, String password, String role, String firstname, String usertitle) {
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstname = firstname;
        this.usertitle = usertitle;
    }

    public String getUsertitle() {
        return usertitle;
    }

    public void setUsertitle(String usertitle) {
        this.usertitle = usertitle;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
