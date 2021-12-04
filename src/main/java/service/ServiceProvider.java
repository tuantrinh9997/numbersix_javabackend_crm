package service;

import java.sql.Connection;

public class ServiceProvider {
	protected UserService _userService;
	protected TaskService _taskService;
	protected ProjectService _projectService;
	public 	ServiceProvider(Connection connection) {
		_userService = new UserService_Implement(connection);
		_taskService = new TaskService_Implement(connection);
		_projectService = new ProjectService_Implement(connection);
		
	}
	
}
