package com.leanplatformtechnologies.assignment.service;

import com.leanplatformtechnologies.assignment.entity.Mentor;
import com.leanplatformtechnologies.assignment.entity.MentorRequest;
import com.leanplatformtechnologies.assignment.entity.Statistics;
import com.leanplatformtechnologies.assignment.entity.User;

import java.util.List;
/*
Service interface it acts as a mediator between rest controller and Data Access Object(DAO) classes

All the methods that are defined in all the DAO classes are also defined in service class
 */

public interface Service {

    //------------------------------------------------//
    //Consultants

    //find all consultants
    List<Mentor> findAll();

    //find a consultant by id
    Mentor findById(int id);

    //find all consultants based on role
     List<Mentor> findByRole(String role);

    //add a new consultant
    Mentor save(Mentor mentor);

    //update details of a consultant
    Mentor updateMentorDetails(Mentor mentor);

    //remove a consultant
    void delete(int id);

    //-----------------------------------------------//
    //Mentor Requests

    //find all consultant requests
    List<MentorRequest> findAllRequests();

    //send a request to become a mentor
    MentorRequest sendRequest(MentorRequest mentorRequest);

    //approve the mentor request
    Mentor save(int id);

    //find request based on request id
    MentorRequest findByRequestId(int id);

    //reject the request
    void deleteRequest(int id);

    //-----------------------------------------------------//

    //web-statistics
    Statistics statistics();

    //-----------------------------------------------------//

    //User requests

    //new user registration
    User save(User newUser);

    //book a session
    String bookSession(long phno);

    List<User> findAllUser();
}
