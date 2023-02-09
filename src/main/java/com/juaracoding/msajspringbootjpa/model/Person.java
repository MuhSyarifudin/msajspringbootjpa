package com.juaracoding.msajspringbootjpa.model;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 08/02/2023 22:48
@Last Modified 08/02/2023 22:48
Version 1.1
*/

import org.springframework.boot.*;

import javax.persistence.*;

@Entity
@Table( name = "MstPerson")
public class Person {
    @Id
    @Column( name = "IDPerson")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "FirstName")
    private String FirstName;
    @Column( name = "MiddleName")
    private String MiddleName;
    @Column( name = "LastName")
    private String LastName;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
