package com.leanplatformtechnologies.assignment.service;

import com.leanplatformtechnologies.assignment.dao.MentorDAO;
import com.leanplatformtechnologies.assignment.dao.MentorRequestDAO;
import com.leanplatformtechnologies.assignment.dao.StatisticsDAO;
import com.leanplatformtechnologies.assignment.dao.UserDAO;
import com.leanplatformtechnologies.assignment.entity.Mentor;
import com.leanplatformtechnologies.assignment.entity.MentorRequest;
import com.leanplatformtechnologies.assignment.entity.Statistics;
import com.leanplatformtechnologies.assignment.entity.User;
import com.leanplatformtechnologies.assignment.exceptionhandling.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
The methods defined in service interface are implemented in service implementation class

The DAO class constructors are injected into service class
 */
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    //Constructor Injection

    //define fields
    @Autowired
    private MentorDAO mentorDAO;
    @Autowired
    private StatisticsDAO statisticsDAO;
    @Autowired
    private MentorRequestDAO mentorRequestDAO;
    @Autowired
    private UserDAO userDAO;

    public ServiceImpl(MentorDAO theMentorDAO){
        mentorDAO=theMentorDAO;
    }

    public ServiceImpl(){

    }

    //constructor injection
    //Statistics DAO constructor injection
    public ServiceImpl(StatisticsDAO theStatisticsDAO){
        statisticsDAO = theStatisticsDAO;
    }

    //MentorRequest DAO constructor injection
    public ServiceImpl(MentorRequestDAO theMentorRequestDAO){
        mentorRequestDAO = theMentorRequestDAO;
    }

    //UserDAO DAO constructor injection
    public ServiceImpl(UserDAO theUserDAO){
        userDAO = theUserDAO;
    }


    //Handling consultant/Mentor related requests

    //Finding all consultants
    @Override
    public List<Mentor> findAll() {

        return mentorDAO.findAll();
    }
    //finding consultants based on id
    @Override
    public Mentor findById(int id) {
        return mentorDAO.findById(id);
    }

    //finding consultants based on role
    @Override
    public List<Mentor> findByRole(String role) {
        return mentorDAO.findByRole(role);
    }

    //Storing a consultant into database
    /*@Transactional annotation is used to mark a method or a class as transactional
     that any database operations performed within the marked method or class will be
      executed within a transaction.
     */
    @Transactional
    @Override
    public Mentor save(Mentor mentor) {
        statisticsDAO.addConsultants();
        return mentorDAO.save(mentor);
    }

    //Updating consulting Details
    @Transactional
    @Override
    public Mentor updateMentorDetails(Mentor mentor) {
        return mentorDAO.updateMentorDetails(mentor);
    }

    //Removing a consultant
    @Transactional
    @Override
    public void delete(int id) {
       int temp = mentorDAO.delete(id);
       if(temp==1){
           statisticsDAO.deleteConsultants();
       }
    }


    //Handling new consultant-request related Requests

    //finding all mentor requests
    @Override
    public List<MentorRequest> findAllRequests() {
        return mentorRequestDAO.findAllRequests();
    }

    //adding a request to mentor request table
    @Transactional
    @Override
    public MentorRequest sendRequest(MentorRequest mentorRequest) {
        return mentorRequestDAO.sendRequest(mentorRequest);
    }

    //fetching request based on mentor request id
    @Override
    public MentorRequest findByRequestId(int id){
        return mentorRequestDAO.findByRequestId(id);
    }

    //delete a request from mentor request
    @Transactional
    @Override
    public void deleteRequest(int id) {
        mentorRequestDAO.deleteRequest(id);
    }

    //convert mentor request into mentor
    @Transactional
    @Override
    public Mentor save(int id){
        MentorRequest temp = mentorRequestDAO.findByRequestId(id);
        statisticsDAO.addConsultants();
        return mentorDAO.save(temp);
    }


    //Handling statistics requests
    @Override
    public Statistics statistics() {
        return statisticsDAO.findAll();
    }

    //Handling user requests

    //saving a new user - user registration
    @Transactional
    @Override
    public User save(User newUser) {
        long temp=newUser.getPhoneNum();
        User tempUser = userDAO.findByPhoneNum(temp);
        if(tempUser!=null){
            throw new GlobalException("A user already exists with Phone number -"+temp);
        }
        statisticsDAO.addClient();
        return userDAO.save(newUser);
    }

    //user booking a session
    @Transactional
    @Override
    public String bookSession(long phno){
        User user = userDAO.findByPhoneNum(phno);
        if(user==null){
            throw new GlobalException("No user exists with phone number -"+phno);
        }
        int temp=user.getNoOfSessions();
        user.setNoOfSessions(temp+1);
        return statisticsDAO.updateSessions();
    }

    //displaying all users
    @Override
    public List<User> findAllUser() {
        return userDAO.findAll();
    }
}
