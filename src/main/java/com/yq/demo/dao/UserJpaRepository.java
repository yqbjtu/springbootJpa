package com.yq.demo.dao;

import com.yq.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    public User getByUserName(String username);
    public User getByFullName(String fullname);
    public List<User> getByLanguage(String username);
    public List<User> getByLanguageAndTimeZone(String username, String timeZone);

}
