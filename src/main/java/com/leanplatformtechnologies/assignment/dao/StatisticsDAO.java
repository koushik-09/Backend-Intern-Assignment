package com.leanplatformtechnologies.assignment.dao;

import com.leanplatformtechnologies.assignment.entity.Statistics;
import java.util.*;

public interface StatisticsDAO {
    Statistics findAll();

    String updateSessions();

    void addConsultants();

    void deleteConsultants();

    void addClient();

    void deleteClient();
}
