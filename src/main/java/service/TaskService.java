package service;

import java.util.List;

import entity.Project;
import entity.Task;

public interface TaskService {

	public List<Task> getTask(int id, String role);

	public int addTask(String name, String start_date, String end_date, String description, int assignee,
			Project project);

	public int deleteTask(int id);

	public int updateTask(int id, String name, String start_date, String end_date, String description, int assignee);

	public int updateTaskByUser(int id, int status);

	public Project getProject(int id_leader);

	public Task getInfoTask(int id);

}
