package service;

import repository.UserRepository;

public abstract class BaseService {
	
	protected UserRepository _userRepository;
	public BaseService() {
		_userRepository = new UserRepository();
	}
}
