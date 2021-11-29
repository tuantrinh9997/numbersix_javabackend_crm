package service;

import java.util.List;

import entity.User;

public class UserService_Implement extends BaseService 
	implements UserService {
	
	public List<User> getUser(){
		return _userRepository.getUser();
	}

	public int addUser(String email, String password, String fullname, String phone, String address, int role) {
		return _userRepository.addUser(email, password, fullname, phone, address, role);
	}

	public int delUser(int id) {
		return _userRepository.delUser(id);
	}

	public User findUser(int id) {
		return _userRepository.findUser(id);
	}

	public int updateUser(int id, String email, String password, String fullname, String phone, String address,
			int role) {
		
		return _userRepository.updateUser(id, email, password, fullname, phone, address, role);
	}
	
}
