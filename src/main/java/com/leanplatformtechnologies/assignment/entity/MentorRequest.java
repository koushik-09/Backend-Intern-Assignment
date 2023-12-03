package com.leanplatformtechnologies.assignment.entity;

import jakarta.persistence.*;

@Entity
@Table(name="MentorRequest")
public class MentorRequest {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="first-name")
    private String firstName;

    @Column(name="last-name")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="role")
    private String role;

    @Column(name="status")
    private boolean status;

    //define constructors
    public MentorRequest(){

    }

    public MentorRequest(String firstName, String lastName,int age, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=age;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
