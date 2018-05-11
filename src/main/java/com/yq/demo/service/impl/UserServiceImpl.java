


package com.yq.demo.service.impl;

import com.yq.demo.dao.UserJpaRepository;
import com.yq.demo.entity.User;
import com.yq.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Simple to Introduction
 * className: UserServiceImpl
 *
 * @author EricYang
 * @version 2018/5/11 22:10
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserJpaRepository userJpaRepo;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public long userCount(){
        return userJpaRepo.count();
    }

    @Override
    public String showSpecificClassName() {
        String clsName = this.getClass().getCanonicalName();
        log.info("impl class is " + clsName);
        return clsName;
    }

    @Override
    public List<User> getAllUser() {
        return userJpaRepo.findAll();
    }

    @Override
    public User addUser(User user) {
        return userJpaRepo.save(user);
    }

    @Override
    public void delUser(Integer id) {
        userJpaRepo.delete(id);
    }

    @Override
    public User updateUser(User user) {
        return userJpaRepo.save(user);
    }

    @Override
    public User getUserByName(String username) {
        return userJpaRepo.getByUserName(username);
    }

    @Override
    public User getUserByID(Integer id) {
        return userJpaRepo.findOne(id);
    }

}
