package com.leanplatformtechnologies.assignment.entity;


import jakarta.persistence.*;

@Entity
@Table(name="client")
public class User {

    //define fields
    @Id
    @Column(name="phno")
    private long phoneNum;

    @Column(name="name")
    private String name;

    @Column(name = "sessions")
    private int noOfSessions;

    //define constructors
    public User(){

    }

    public User(long phoneNum,String name) {
        this.phoneNum=phoneNum;
        this.name = name;
    }
    //define getters and setters

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfSessions() {
        return noOfSessions;
    }

    public void setNoOfSessions(int noOfSessions) {
        this.noOfSessions = noOfSessions;
    }
}
