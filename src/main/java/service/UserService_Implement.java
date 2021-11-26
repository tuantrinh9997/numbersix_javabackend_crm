package service;

import java.util.List;

import entity.User;

public class UserService_Implement extends BaseService 
	implements UserService {
	
	public List<User> getUser(){
		return _userRepository.getUser();
	}

	@Override
	public int addUser(String email, String password, String fullname, String phone, String address, int role) {
		return _userRepository.addUser(email, password, fullname, phone, address, role);
	}}
