package service;

import repository.ProjectRepository;
import repository.TaskRepository;
import repository.UserRepository;

public abstract class BaseService {
	
	protected UserRepository _userRepository;
	protected ProjectRepository _projectRepository;
	protected TaskRepository _taskRepository;
	
	public BaseService() {
		_userRepository = new UserRepository();
		_projectRepository = new ProjectRepository();
		_taskRepository = new TaskRepository();
	}
}
