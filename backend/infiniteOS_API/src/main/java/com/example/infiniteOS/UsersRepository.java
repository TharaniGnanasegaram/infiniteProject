package com.example.infiniteOS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository  extends JpaRepository<Users, Integer> {


    @Query(value = "SELECT * FROM users" +
            " WHERE " +
            "userName =:userName " +
            "AND password = :password", nativeQuery = true)
    Users loginUser(String userName, String password);




}
