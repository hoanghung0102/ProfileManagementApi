package com.hoanghung.profilemanage.repository;

import com.hoanghung.profilemanage.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hxhung on 8/24/2017.
 */
@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "select * From users as u where u.user_name = :#{#user.username} AND u.pwd = :#{#user.password}", nativeQuery = true)
    User findUserByUserNameAndPwd(@Param("user") User user);

    @Query(value = "select * From users as u where u.user_name = :#{#username}", nativeQuery = true)
    User findUserByUserName(@Param("username") String userName);

    @Query(value = "Select role_name from role rl inner join user_role ur on ur.role_id = ur.role_id where ur.user_id = :#{#user_id}", nativeQuery = true)
    List<String> findRoleNamesByUserId(@Param("user_id") Long userId);
}
