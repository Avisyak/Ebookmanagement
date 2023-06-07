package com.Broadway.FinalprojectBroadway.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Broadway.FinalprojectBroadway.Model.User;
import com.Broadway.FinalprojectBroadway.Repository.UserRepository;
import com.Broadway.FinalprojectBroadway.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public void userSignup(User user) {
		
		userRepo.save(user);
	}

	@Override
	public User userLogin(String un, String psw) {
		
		return userRepo.findByUsernameAndPassword(un, psw);
	}

	@Override
	public User getUserById(int id) {
		
		return userRepo.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}

}
