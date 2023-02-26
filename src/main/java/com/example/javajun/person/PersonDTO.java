package com.example.javajun.person;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
public class PersonDTO {
    @Id
    @Column(name = "personid")
    private Integer personId;

    @Column(name = "fio")
    private String fio;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "isAlive")
    private boolean isAlive;

    @Column(name = "town")
    private String town;
}
