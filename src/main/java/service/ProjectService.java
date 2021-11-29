package service;

import java.util.List;

import entity.Project;

public interface ProjectService {
	
	public List<Project> getProject();
	
	public int deleteProject(int id);
	
	public int addProject(int id);
	
	public int updateProject(int id);
}
