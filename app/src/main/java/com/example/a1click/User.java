package com.example.a1click;

public class User {
    public String email, user_name, password;

    public User() {
    }

    public User(String email, String user_name, String password) {
        this.email = email;
        this.user_name = user_name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
