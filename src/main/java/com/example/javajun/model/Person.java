package com.example.javajun.model;

import lombok.Data;

import java.util.Date;

@Data
public class Person {

    private int personId;
    private String fio;
    private Date birthday;
    private boolean isAlive;
    private String town;
}
