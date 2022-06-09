package com.demo.factory.dao;

import com.demo.factory.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT *  from user where name=:name",nativeQuery = true)
    User getUserName(@Param(value = "name") String name);


}
