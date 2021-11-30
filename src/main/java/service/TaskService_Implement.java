package service;

import java.util.List;

import entity.Task;

public class TaskService_Implement extends BaseService implements TaskService{

	public List<Task> getTask() {
		return _taskRepository.getTask();
	}

	public int addTask(String name, String start_date, String end_date, String description, int assignee,
			int project, int status) {
		
		return _taskRepository.addTask(name, start_date, end_date, description, assignee, project, status);
	}

	public int deleteTask(int id) {
		return _taskRepository.deleteTask(id);
	}

}
