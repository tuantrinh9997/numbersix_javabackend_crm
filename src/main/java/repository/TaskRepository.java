package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import db.DbQuerry;
import entity.Project;
import entity.Status;
import entity.Task;
import entity.User;

public class TaskRepository extends BaseRepository{
	private UserRepository _userRepository = new UserRepository();
	private ProjectRepository _projectRepository = new ProjectRepository();
	private StatusRepository _statusRepository = new StatusRepository();

	public List<Task> getTask(int id_user, String role) {
		List<Task> tasks = new LinkedList<Task>();
		
		String query = DbQuerry.TASK_WITH_USER_ID+id_user+";";
		
		if (role.equalsIgnoreCase("admin")) {
			query = DbQuerry.TASK_WITH_USER_AND_PROJECT;
		}
		
		if (role.equalsIgnoreCase("leader")) {
			query = DbQuerry.TASK_WITH_LEADER_ID+id_user+";";
			
		}
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setStart_date(rs.getString("start_date"));
				task.setEnd_date(rs.getString("end_date"));
				task.setDescription(rs.getString("description"));
				
				String assignee = rs.getString("assignee");
				List<User> users = _userRepository.getUser();
				User user = null;
				for (User u: users) {
					if (u.getName().equalsIgnoreCase(assignee)) {
						user = u;
						break;
					}
				}
				task.setAssignee(user);
				
				String project_name = rs.getString("project_name");
				List<Project> projects = _projectRepository.getProject();
				Project project = null;
				for (Project p: projects) {
					if (p.getName().equalsIgnoreCase(project_name)) {
						project = p;
						break;
					}
				}
				task.setProject(project);
				
				String status_name = rs.getString("status");
				List<Status> statusList = _statusRepository.getStatus();
				Status status = null;
				for (Status s: statusList) {
					if (s.getName().equalsIgnoreCase(status_name)) {
						status = s;
						break;
					}
				}
				task.setStatus(status);
				
				tasks.add(task);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tasks;
	}
	
	public int addTask(String name, String start_date, String end_date, String description, int assignee,
			int project, int status) {
		String query = DbQuerry.TASK_ADD;
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, start_date);
			statement.setString(3, end_date);
			statement.setInt(4, assignee);
			statement.setInt(5, project);
			statement.setInt(6, status);
			statement.setString(7, description);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteTask(int id) {
		String query = "DELETE FROM task WHERE id="+id+";";
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int updateTask(int id, String name, String start_date, String end_date, String description, int assignee,
			int project, int status) {
		String query = "update task\r\n"
				+ "set name = '"+name+"', start_date = '"+start_date+"', end_date = '"+end_date+"', assignee = "+assignee+", project = "+project+", description = '"+description+"'\r\n"
				+ "where id = "+id+";";
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateTaskByUser(int id, int status) {
		System.out.println("---"+id);
		String query = "update task\r\n"
				+ "set status = "+status+"\r\n"
				+ "where id = "+id+";";
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			return statement.executeUpdate();
					
		} catch (SQLException e) {
			System.out.println("khong ket noi database duoc");
			e.printStackTrace();
		}
		
		return 0;
		
	}

}
