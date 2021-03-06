package service;

import java.util.List;

import entity.Project;

public interface ProjectService {
	
	public List<Project> getProject(int id, String role);
	
	public int deleteProject(int id);
	
	public int addProject(String name, String start_date, String end_date, String description, int user_id);
	
	public int updateProject(int id, String name, String start_date, String end_date, String description, int user_id);

	public Project getInfoProject(int id);
	
}
