package com.leanplatformtechnologies.assignment.entity;


import jakarta.persistence.*;

@Entity
@Table(name="web-statistics")
public class Statistics {


    //define fields
    @Id
    private int id=1;
    @Column(name="consultants")
    private int consultants;

    @Column(name="clients")
    private int clients;

    @Column(name="sessions")
    private int sessions;

    //define constructors
    public Statistics() {

    }

    public Statistics(int consultants, int clients, int sessions) {
        this.consultants = consultants;
        this.clients = clients;
        this.sessions = sessions;
    }

    //define getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsultants() {
        return consultants;
    }

    public void setConsultants(int consultants) {
        this.consultants = consultants;
    }

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }
}

