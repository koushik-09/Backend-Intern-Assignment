package com.leanplatformtechnologies.assignment.dao;

import com.leanplatformtechnologies.assignment.entity.Mentor;
import com.leanplatformtechnologies.assignment.entity.MentorRequest;

import java.util.*;

/*
DAO class
 */
public interface MentorDAO {
    //find all consultants
    List<Mentor> findAll();

    //find a consultant by id
    Mentor findById(int id);

    //find all consultants based on role
    List<Mentor> findByRole(String role);

    //add a new consultant
    Mentor save(Mentor mentor);
    Mentor save(MentorRequest mentorRequest);

    //update details of mentor
    Mentor updateMentorDetails(Mentor mentor);

    //remove a consultant
    int delete(int id);

}
