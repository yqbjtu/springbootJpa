package com.yq.demo.dao;

import com.yq.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    public User getByUserName(String username);
    public User getByFullName(String fullname);
    public List<User> getByLanguage(String username);
    public List<User> getByLanguageAndTimeZone(String username, String timeZone);

    @Query(value = " from user u where u.userName like %:userName%")
    List<User> findByNameMatchQuery(@Param("userName") String userName);

    //nativeQuery, 必须使用user，因为表的名称必须和数据库严格匹配
    @Query(value = "select * from user u where u.username=?1", nativeQuery = true)
    User findByNameNativeQuery(String name);

    //#{#entityName}'值为'User'对象对应的数据表名称(user)
    @Query(value = "select * from #{#entityName} u where u.username=?1", nativeQuery = true)
    User findByNameWithSpel(String name);
}
