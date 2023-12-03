package com.leanplatformtechnologies.assignment.dao;

import com.leanplatformtechnologies.assignment.entity.MentorRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MentorRequestDAOImpl implements MentorRequestDAO{

    private EntityManager entityManager;

    @Autowired
    public MentorRequestDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<MentorRequest> findAllRequests() {
        TypedQuery<MentorRequest> theQuery = entityManager.createQuery("from MentorRequest",MentorRequest.class);
        List<MentorRequest> list = theQuery.getResultList();
        return list;
    }

    @Override
    public MentorRequest findByRequestId(int id) {
        MentorRequest mentorRequest = entityManager.find(MentorRequest.class,id);
        if(mentorRequest==null){
            throw new RuntimeException("Request not found -"+id);
        }

        return mentorRequest;
    }

    @Override
    public void deleteRequest(int id){
        MentorRequest mentorRequest = findByRequestId(id);
        entityManager.remove(mentorRequest);
    }

    @Override
    public MentorRequest sendRequest(MentorRequest mentorRequest) {
        mentorRequest.setId(0);
        MentorRequest temp = entityManager.merge(mentorRequest);
        return temp;
    }
}
