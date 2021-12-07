package service;

import java.sql.Connection;

import entity.User;
import repository.UserRepository;

public class AuthenService_Implement implements AuthenService{
	
	private UserRepository _userRepository;
	public AuthenService_Implement(Connection connection) {
		_userRepository = new UserRepository(connection);
	}
	public User login(String username, String password) {
		
		return _userRepository.login(username, password);
	}

	
	public String getRoleByUserId(int userId) {
		//Móc database lên chứ ko nên chơi cứng kiểu này
		String role = "";
		switch (userId) {
		case 1:
			role = "ADMIN";
			break;
		case 2:
			role = "LEADER";
			break;
		case 3:
			role = "PM";
			break;
		case 4:
			role = "USER";
			break;
		default:
			break;
		}
		return role;
	}

}
