package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import db.DbQuerry;
import entity.Project;
import entity.User;

public class ProjectRepository extends BaseRepository{
	UserRepository repository = new UserRepository();
	
	public List<Project> getProject(){
		List<Project> projects = new LinkedList<Project>();
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
				String user_name = rs.getString("user_name");
				
				List<User> users = repository.getUser();
				
				User user = null;
				for(User u: users) {
					if (u.getName().equals(user_name)) {
						user = u;
						break;
					}
				}
				
				Project project = new Project(id, name, description, start_date, end_date, user);
				projects.add(project);
				
			}
		} catch (SQLException e) {
			
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
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int delProject(int id) {
		String query = "DELETE FROM project WHERE id="+id+";";
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public int updateProject(int id, String name, String start_date, String end_date, String description, int user_id) {
		String query = "UPDATE project\r\n"
				+ "SET name = '"+name+"', start_date = '"+start_date+"', end_date = '"+end_date+"', description = '"+description+"', creat_user = "+user_id+"\r\n"
				+ "WHERE id = "+id+";";
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public Project getInfoProject(int id) {
		Project project = new Project();
		String query = DbQuerry.PROJECT_WITH_ID + id+";";
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				project.setName(rs.getString("project_name"));
				project.setStart_date(rs.getString("start_date"));
				project.setEnd_date(rs.getString("end_date"));
				project.setDescription(rs.getString("description"));
				
				String user_name = rs.getString("user_name");
				
				List<User> users = repository.getUser();
				
				User user = null;
				for(User u: users) {
					if (u.getName().equals(user_name)) {
						user = u;
						break;
					}
				}
				
				project.setUser(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return project;
	}
}
