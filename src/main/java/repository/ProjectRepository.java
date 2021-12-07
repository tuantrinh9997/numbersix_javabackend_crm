package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import db.DbQuerry;
import entity.Project;


public class ProjectRepository {
	
	private Connection _connection;
	public ProjectRepository(Connection connection) {
		_connection = connection;
	}
	
	
	public List<Project> getProject(int id_project, String role) {
		List<Project> projects = new LinkedList<Project>();

		String query = DbQuerry.PROJECT_WITH_USER_ID + id_project + ";";
		if (role.equalsIgnoreCase("admin")) {
			query = DbQuerry.PROJECT_WITH_USER;
		}
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("project_id");
				String name = rs.getString("project_name");
				String description = rs.getString("description");
				String start_date = rs.getString("start_date");
				String end_date = rs.getString("end_date");
				int user_id = rs.getInt("user_id");
				
				projects.add(new Project(id, name, description, start_date, end_date, user_id));
				
			}
		} catch (SQLException e) {
			System.out.println("Khong the lay getProjectList");
			e.printStackTrace();
		}

		return projects;
	}

	public int addProject(String name, String start_date, String end_date, String description, int user_id) {
		String query = DbQuerry.ADD_PROJECT;

		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, start_date);
			statement.setString(3, end_date);
			statement.setString(4, description);
			statement.setInt(5, user_id);

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Khong the addProject");
			e.printStackTrace();
		}

		return 0;
	}

	public int delProject(int id) {
		String query = "DELETE FROM project WHERE id=?;";
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setInt(1, id);
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Khong the delProject");
			e.printStackTrace();
		}

		return 0;
	}

	public int updateProject(int id, String name, String start_date, String end_date, String description, int user_id) {
		String query = "UPDATE project\r\n" + "SET name = '" + name + "', start_date = '" + start_date
				+ "', end_date = '" + end_date + "', description = '" + description + "', creat_user = " + user_id
				+ "\r\n" + "WHERE id = " + id + ";";

		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Khong the updateProject");
			e.printStackTrace();
		}

		return 0;
	}

	public Project getInfoProject(int id) {
		Project project = new Project();

		String query = DbQuerry.PROJECT_WITH_ID;

		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				project.setId(rs.getInt("project_id"));
				project.setUser_id(rs.getInt("user_id"));
				project.setName(rs.getString("project_name"));
				project.setStart_date(rs.getString("start_date"));
				project.setEnd_date(rs.getString("end_date"));
				project.setDescription(rs.getString("description"));

			}

		} catch (SQLException e) {
			System.out.println("Khong the getInfoProject");
			e.printStackTrace();
		}

		return project;
	}

	public List<Project> getProjectList() {
		List<Project> projects = new LinkedList<Project>();
		
		//Nhiều câu query quá
		String query = DbQuerry.PROJECT_WITH_USER;

		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("project_id");
				String name = rs.getString("project_name");
				String description = rs.getString("description");
				String start_date = rs.getString("start_date");
				String end_date = rs.getString("end_date");
				
				int user_id = rs.getInt("user_id");
				projects.add(new Project(id, name, description, start_date, end_date, user_id));
			}
			
		} catch (SQLException e) {
			System.out.println("Khong the lay getProjectList");
			e.printStackTrace();
		}

		return projects;
	}
}
