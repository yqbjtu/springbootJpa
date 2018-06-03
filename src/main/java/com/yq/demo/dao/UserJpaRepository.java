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

    //使用NamedQuery
    User findByDemoName(String userName);

    @Query(value = " from user u where u.userName like %:userName%")
    List<User> findByNameMatchQuery(@Param("userName") String userName);
//    使用命名化参数，使用@Param即可，比如：
//    @Query(value="select u from user u where u.userName like %:na")
//    public List<UserModel> findByNameMatchQuery3(@Param("na") String userName);
//    同样支持更新类的Query语句，添加@Modifying即可，比如：
//    @Modifying
//

    //如果是like，后面的参数需要前面或者后面加“%”，比如下面都对：
    @Query(value="select u from user u where u.userName like %?1")
    List<User> findByNameMatchQuery2(String userName);

    //在参数绑定上，我们还可以直写问号
    // @Query("select u from user u where u.userName = ? and u.fullName = ?")

    //nativeQuery, 必须使用user，因为表的名称必须和数据库严格匹配
    @Query(value = "select * from user u where u.username=?1", nativeQuery = true)
    User findByNameNativeQuery(String name);

    //#{#entityName}'值为'User'对象对应的数据表名称(user)
    @Query(value = "select * from #{#entityName} u where u.username=?1", nativeQuery = true)
    User findByNameWithSpel(String name);
}
