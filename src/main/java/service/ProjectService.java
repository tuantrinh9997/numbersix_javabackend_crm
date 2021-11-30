package service;

import java.util.List;

import entity.Project;

public interface ProjectService {
	
	public List<Project> getProject();
	
	public int deleteProject(int id);
	
	public int addProject(String name, String start_date, String end_date, String description, int user_id);
	
	public int updateProject(int id);
}
