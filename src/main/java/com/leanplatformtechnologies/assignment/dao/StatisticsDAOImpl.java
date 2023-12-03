package com.leanplatformtechnologies.assignment.dao;

import com.leanplatformtechnologies.assignment.entity.Statistics;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatisticsDAOImpl implements StatisticsDAO{

    //define entity manager
    private EntityManager entityManager;

    //constructor injection
    @Autowired
    public StatisticsDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }


    @Override
    public Statistics findAll() {
        TypedQuery<Statistics> theQuery = entityManager.createQuery("from Statistics",Statistics.class);

        List<Statistics> list = theQuery.getResultList();
        if(list.isEmpty()){
            return new Statistics();
        }
        return list.get(0);
    }

    @Override
    public String updateSessions() {
        Statistics statistics = findAll();
        int temp=statistics.getSessions();
        statistics.setSessions(temp+1);
        entityManager.merge(statistics);
        return "Session Booked Successfully";
    }

    @Override
    public void addConsultants() {
        Statistics statistics=findAll();
        int temp=statistics.getConsultants();
        statistics.setConsultants(temp+1);
        entityManager.merge(statistics);
    }

    @Override
    public void deleteConsultants() {
        Statistics statistics=findAll();
        int temp=statistics.getConsultants();
        if(temp==0){
            return;
        }
        statistics.setConsultants(temp-1);
        entityManager.merge(statistics);
    }

    @Override
    public void addClient() {
        Statistics statistics=findAll();
        int temp=statistics.getClients();
        statistics.setClients(temp+1);
        entityManager.merge(statistics);
    }

    @Override
    public void deleteClient() {
        Statistics statistics=findAll();
        int temp=statistics.getClients();
        if(temp==0){
            return;
        }
        statistics.setClients(temp-1);
        entityManager.merge(statistics);
    }
}
