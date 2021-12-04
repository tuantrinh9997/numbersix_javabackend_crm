package service;

import entity.User;

public interface AuthenService {
	
	User login(String username, String password);
	
	String getRoleByUserId(int userId);
}
