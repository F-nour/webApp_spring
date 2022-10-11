package com.example.demo.model;

import lombok.Data;

@Data
public class Employee {

    private Integer id;

    private String firstName;

    private String lastName;

    private String mail;

    private String password;

    public int getId() {
        return id;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {} {
        this.password = password;
    }

}