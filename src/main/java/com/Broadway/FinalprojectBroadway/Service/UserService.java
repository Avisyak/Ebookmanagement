package com.Broadway.FinalprojectBroadway.Service;

import java.util.List;

import com.Broadway.FinalprojectBroadway.Model.User;

public interface UserService {
	void userSignup(User user);
	User userLogin(String un,String psw);
	User getUserById(int id);
	List<User> getAllUser();

}
