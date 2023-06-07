package com.Broadway.FinalprojectBroadway.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Broadway.FinalprojectBroadway.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUsernameAndPassword(String un,String psw);
}
