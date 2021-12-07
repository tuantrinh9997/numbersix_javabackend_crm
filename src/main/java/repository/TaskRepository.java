package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import db.DbQuerry;
import entity.Project;

import entity.Task;


public class TaskRepository{
	
	private Connection _connection;
	public TaskRepository(Connection connection) {
		_connection = connection;
	}
	
	//nên đặt tên getTasks
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
				
				int user_id = rs.getInt("user_id");
				task.setUser_id(user_id);
				
				int project_id = rs.getInt("project_id");
				task.setProject_id(project_id);
				
				int status_id = rs.getInt("status_id");
				task.setStatus_id(status_id);
				
				tasks.add(task);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tasks;
	}
	
	public int addTask(String name, String start_date, String end_date, String description, int assignee,
			Project project) {
		String query = DbQuerry.TASK_ADD;
		int project_id = project.getId();
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, start_date);
			statement.setString(3, end_date);
			statement.setInt(4, assignee);
			statement.setInt(5, project_id);
			statement.setString(6, description);
			
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

	public int updateTask(int id, String name, String start_date, String end_date, String description, int assignee) {
		String query = DbQuerry.TASK_UPDATE;
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, start_date);
			statement.setString(3, end_date);
			statement.setInt(4, assignee);
			statement.setString(5, description);
			statement.setInt(6, id);
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateTaskByUser(int id, int status) {
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

	
	//Cái này phải bỏ trong Prject Repository
	public Project getProject(int id_leader) {
		Project project = new Project();
		String query = "select *\r\n"
				+ "from project\r\n"
				+ "where creat_user = "+id_leader+";";
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				project.setId(rs.getInt("id"));
				project.setName(rs.getString("name"));
				project.setStart_date(rs.getString("start_date"));
				project.setEnd_date(rs.getString("end_date"));
				project.setDescription("description");
				
				project.setUser_id(rs.getInt("creat_user"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return project;
	}

	public Task getInfoTask(int id) {
		Task task = new Task();
		String query = DbQuerry.TASK_INFO;
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setDescription(rs.getString("description"));
				task.setStart_date(rs.getString("start_date"));
				task.setEnd_date(rs.getString("end_date"));
				task.setProject_id(rs.getInt("project"));
				task.setStatus_id(rs.getInt("status"));
				task.setUser_id(rs.getInt("assignee"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return task;
	}

}
