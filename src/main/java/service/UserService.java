package service;

import java.util.List;
import entity.User;

public interface UserService {
	public List<User> getUser();
	/*
	private UserRepository repository;
	
	public UserService() {
		repository = new UserRepository();
	}
	
	public List<User> getUser(){
		return repository.getUser();
	}
	*/
	
	public int addUser(String email, String password, String fullname, String phone, String address, int role);
}
