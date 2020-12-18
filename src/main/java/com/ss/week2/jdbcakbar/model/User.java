package com.ss.week2.jdbcakbar.model;

public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private int role;

    public User() {}

    public User(String name, String username, String password, int role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String name, String username, String password, int role, int id) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
