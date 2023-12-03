package com.leanplatformtechnologies.assignment.dao;

import com.leanplatformtechnologies.assignment.entity.User;
import java.util.*;

public interface UserDAO {
    User save(User newUser);
    User findByPhoneNum(long phno);

    List<User> findAll();
}
