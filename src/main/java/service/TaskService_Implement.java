package service;

import java.sql.Connection;
import java.util.List;

import entity.Project;
import entity.Task;
import repository.ProjectRepository;
import repository.StatusRepository;
import repository.TaskRepository;
import repository.UserRepository;

public class TaskService_Implement implements TaskService{

	private TaskRepository _taskRepository;
	private ProjectRepository _projectRepository;
	private UserRepository _userRepository;
	private StatusRepository _statusRepository;
	public TaskService_Implement(Connection connection) {
		//Cần repo nào thì inject hết vào đây
		_taskRepository = new TaskRepository(connection);
		_projectRepository = new ProjectRepository(connection);
		_userRepository = new UserRepository(connection);
		_statusRepository = new StatusRepository(connection);
	}
	public List<Task> getTask(int id, String role) {
		List<Task> tasks = _taskRepository.getTask(id, role);
		if(tasks != null) {
			for (Task task : tasks) {
				task.setAssignee(_userRepository.findUser(task.getUser_id()));
				task.setProject(_projectRepository
						.getInfoProject(task.getProject_id()));
				
				task.setStatus(_statusRepository.findById(task.getStatus_id()));
			}
		}
		
		return tasks;
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

	//Bỏ qua cái Project Repository
	public Project getProject(int id_leader) {
		Project project = _taskRepository.getProject(id_leader);
		project.setUser(_userRepository.findUser(project.getUser_id()));
		return project;
	}

}
