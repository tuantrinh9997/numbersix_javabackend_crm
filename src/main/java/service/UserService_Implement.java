package service;

import java.sql.Connection;
import java.util.List;

import entity.User;
import repository.UserRepository;

public class UserService_Implement implements UserService {
	
	private UserRepository _userRepository;
	
	public UserService_Implement(Connection connection) {
		_userRepository = new UserRepository(connection);
	}
	
	public List<User> getUserList(){
		return _userRepository.getUserList();
	}

	public int addUser(String email, String password, String fullname, String phone, String address, int role) {
		return _userRepository.addUser(email, password, fullname, phone, address, role);
	}

	public int delUserById(int id) {
		return _userRepository.delUserById(id);
	}

	public User findUserById(int id) {
		return _userRepository.findUserById(id);
	}

	public int updateUser(int id, String email, String password, String fullname, String phone, String address,
			int role) {
		
		return _userRepository.updateUser(id, email, password, fullname, phone, address, role);
	}

	public int editAccount(int id, String email, String fullname, String phone, String address, String password) {
		return _userRepository.editAccount(id, email, fullname, phone, address, password);
	}

	public List<User> getUserIsMember() {
		return _userRepository.getUserIsMember();
	}
	
}
