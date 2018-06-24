package com.yq.demo.service;

import com.yq.demo.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {

    public long userCount();

    public String showSpecificClassName();

    public List<User> getAllUser();

    public User addUser(User user);

    public void delUser(Integer id);

    public User updateUser(User user);

    public User getUserByName(String username);

    public User getUserByID(Integer id);

    public List<Map<String, Object>> myFindSomeColumnsByNativeQuery();
}
