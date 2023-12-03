package com.leanplatformtechnologies.assignment.entity;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

@Entity
@Table(name="Mentor")
public class Mentor {


    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @Column(name="first-name")
    private String firstName;

    @Column(name="last-name")
    private String lastName;

    @Column(name="phno")
    private long phoneNum;

    @Column(name="role")
    private String role;

    @Column(name="age")
    private int age;

    @Lob
    @Column(name="CV")
    private byte[] cv;

    //define constructors
    public Mentor(){

    }

    public Mentor(String firstName, String lastName,int age, long phoneNum, String role, byte[] cv) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=age;
        this.phoneNum = phoneNum;
        this.role = role;
        this.cv = cv;
    }
    public Mentor(MentorRequest mentorRequest){
        this.firstName=mentorRequest.getFirstName();
        this.lastName=mentorRequest.getLastName();
        this.age=mentorRequest.getAge();
        this.role=mentorRequest.getRole();
    }

    //define getters and setters

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
    public void setAge(int age){
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }
}
