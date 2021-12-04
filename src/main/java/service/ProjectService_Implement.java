package service;

import java.util.List;

import entity.Project;

public class ProjectService_Implement extends BaseService implements ProjectService{
	
	public List<Project> getProject(int id, String role) {
		return _projectRepository.getProject(id, role);
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
		return _projectRepository.getInfoProject(id);
	}
	
	
}
