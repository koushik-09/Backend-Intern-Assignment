package com.leanplatformtechnologies.assignment.dao;

import com.leanplatformtechnologies.assignment.entity.MentorRequest;

import java.util.List;

public interface MentorRequestDAO {
    List<MentorRequest> findAllRequests();
    MentorRequest findByRequestId(int id);
    void deleteRequest(int id);
    MentorRequest sendRequest(MentorRequest mentorRequest);
}
