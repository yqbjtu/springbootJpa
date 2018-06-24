


package com.yq.demo.service.impl;

import com.yq.demo.dao.UserJpaRepository;
import com.yq.demo.entity.User;
import com.yq.demo.service.UserService;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

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

    @Autowired
    EntityManager entityManager;

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

    @Override
    public List<Map<String, Object>> myFindSomeColumnsByNativeQuery(){
        //@Query(value = "select u.id, u.active, u.username  from user u where u.username=?1", nativeQuery = true)
        Query query = entityManager.createNativeQuery("select u.id, u.active, u.username from user u");
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List rows = query.getResultList();

        for (Object obj : rows) {
            Map row = (Map) obj;
            System.out.print("id = " + row.get("id"));
            System.out.print(", name = " + row.get("active"));
            System.out.println(", age = " + row.get("username"));
        }
        return rows;
    }
}
