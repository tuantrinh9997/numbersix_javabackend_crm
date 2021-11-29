package service;

import repository.ProjectRepository;
import repository.UserRepository;

public abstract class BaseService {
	
	protected UserRepository _userRepository;
	protected ProjectRepository _projectRepository;
	public BaseService() {
		_userRepository = new UserRepository();
		_projectRepository = new ProjectRepository();
	}
}
