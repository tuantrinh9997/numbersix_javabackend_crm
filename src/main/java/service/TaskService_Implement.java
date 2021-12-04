package service;

import java.util.List;

import entity.Project;
import entity.Task;

public class TaskService_Implement extends BaseService implements TaskService{

	public List<Task> getTask(int id, String role) {
		return _taskRepository.getTask(id, role);
	}

	public int addTask(String name, String start_date, String end_date, String description, int assignee,
			Project project) {
		
		return _taskRepository.addTask(name, start_date, end_date, description, assignee, project);
	}

	public int deleteTask(int id) {
		return _taskRepository.deleteTask(id);
	}

	public int updateTask(int id, String name, String start_date, String end_date, String description, int assignee,
			int project, int status) {
		return _taskRepository.updateTask(id, name, start_date, end_date, description, assignee, project, status);
	}

	public int updateTaskByUser(int id, int status) {
		return _taskRepository.updateTaskByUser(id, status);
	}

	public Project getProject(int id_leader) {
		return _taskRepository.getProject(id_leader);
	}

}
