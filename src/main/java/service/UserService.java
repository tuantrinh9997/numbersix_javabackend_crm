package service;

import repository.UserRepository;
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
}