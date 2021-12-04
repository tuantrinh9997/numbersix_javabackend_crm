package service;

import java.sql.Connection;

import java.util.List;

import entity.Project;

import repository.ProjectRepository;
import repository.UserRepository;

public class ProjectService_Implement implements ProjectService{
	
	private ProjectRepository _projectRepository;
	private UserRepository _userRepository;
	public ProjectService_Implement(Connection connection) {
		//cần cái gì thì inject vào đây
		_projectRepository = new ProjectRepository(connection);
		_userRepository = new UserRepository(connection);
	}
	
	public List<Project> getProject(int id, String role) {
		List<Project> projects = _projectRepository.getProject(id, role);
		
		//List<User> users = _userRepository.getUser();
		if(projects != null) {
			for (Project project : projects) {
				project.setUser(_userRepository.findUser(project.getUser_id()));
			}
		}
		return projects;
		//return _projectRepository.getProject(id, role);
	}

	public int deleteProject(int id) {
		return _projectRepository.delProject(id);
	}


	public int addProject(String name, String start_date, String end_date, String description, int user_id) {
		return _projectRepository.addProject(name, start_date, end_date, description, user_id);
	}

	public int updateProject(int id, String name, String start_date, String end_date, String description, int user_id) {
		
		return _projectRepository.updateProject(id, name, start_date, end_date, description, user_id);
	}

	public Project getInfoProject(int id) {
		Project rt = _projectRepository.getInfoProject(id);
		
		rt.setUser(_userRepository.findUser(rt.getUser_id()));

		return rt;
		//return _projectRepository.getInfoProject(id);
	}
	
	
}
