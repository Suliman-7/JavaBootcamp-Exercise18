package com.example.exercise18.Repository;

import com.example.exercise18.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {

     User findById(Integer id);

     User findByEmail(String Email);

     @Query("select u from User u")
     List<User> pleaseGetAllUsers();

     @Query("select u from User u where u.username=?1 and u.password=?2")
     User LogIn(String username , String password);


     @Query("select u from User u where u.role=?1")
     List<User> pleaseGetByRole(String role);

     @Query("select u from User u where u.age>=?1")
     List<User> pleaseGetByAge(int age);


}
