package service;

import java.util.List;

import entity.User;

public class UserService_Implement extends BaseService 
	implements UserService {
	
	public List<User> getUser(){
		return _userRepository.getUser();
	}

}
