package com.leanplatformtechnologies.assignment.dao;

import com.leanplatformtechnologies.assignment.entity.Mentor;
import com.leanplatformtechnologies.assignment.entity.MentorRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MentorDAOImpl implements MentorDAO{

    //define entitymanager
    private EntityManager entityManager;

    //constructor injection
    @Autowired
    public MentorDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Mentor> findAll() {

        //create a sql query
        TypedQuery<Mentor> theQuery = entityManager.createQuery("from Mentor",Mentor.class);

        //execute the query
        List<Mentor> mentors = theQuery.getResultList();

        //return the results
        return mentors;
    }

    @Override
    public Mentor findById(int id) {
        //create a sql query to find consultant by id
        Mentor mentor = entityManager.find(Mentor.class,id);
        return mentor;
    }

    @Override
    public List<Mentor> findByRole(String role) {
        //create a sql query
        TypedQuery<Mentor> theQuery = entityManager.createQuery("from Mentor where role=:theData",Mentor.class);

        theQuery.setParameter("theData",role);

        //execute the query
        List<Mentor> mentors = theQuery.getResultList();

        //return the results
        return mentors;
    }

    @Override
    public Mentor save(Mentor mentor) {
        Mentor dbMentor = entityManager.merge(mentor);
        return dbMentor;
    }

    @Override
    public Mentor save(MentorRequest mentorRequest) {
        MentorRequest temp = mentorRequest;
//        temp.setId(0);
        Mentor dbMentor = entityManager.merge(new Mentor(temp));
        return dbMentor;
    }

    @Override
    public Mentor updateMentorDetails(Mentor mentor) {
        Mentor dbMentor = entityManager.merge(mentor);
        return dbMentor;
    }

    @Override
    public int delete(int id) {
        Mentor mentor = findById(id);
        if(mentor==null){
            return 0;
        }
        entityManager.remove(mentor);
        return 1;
    }

}
