package com.yq.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yq.demo.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    public User getByUserName(String username);
    public User getByFullName(String fullname);
    public List<User> getByLanguage(String username);
    public List<User> getByLanguageAndTimeZone(String username, String timeZone);
}
