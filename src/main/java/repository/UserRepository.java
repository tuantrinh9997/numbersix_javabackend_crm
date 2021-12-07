package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import db.DbQuerry;
import entity.Role;
import entity.User;

public class UserRepository{
	private Connection _connection;
	public UserRepository(Connection connection) {
		_connection = connection;
	}
	
	 public User login(String username, String password) {
		 try {
			 String query = DbQuerry.LOGIN;
				
			 	PreparedStatement statement = _connection.prepareStatement(query);
			 	statement.setString(1, username);
			 	statement.setString(2, password);
				
				User user = null;
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					user = new User();
					user.setId(rs.getInt("user_id"));
					user.setAddress(rs.getString("address"));
					user.setEmail(rs.getString("email"));
					user.setName(rs.getString("user_name"));
					user.setPassword(rs.getString("password"));
					user.setPhone(rs.getString("phone"));

					Role role = new Role();
					role.setId(rs.getInt("role_id"));
					role.setName(rs.getString("role_name"));
					role.setDescription(rs.getString("role_description"));

					user.setRole(role);
					
				}
				return user;
			} catch (SQLException e) {
				System.out.println("Khong the login");
				e.printStackTrace();
			} 
			return null;
	 }
	
	
	
	public List<User> getUserList() {
		List<User> users = new LinkedList<User>();
		try {
			String query = DbQuerry.USER_WITH_ROLE;

			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));

				Role role = new Role();
				role.setId(rs.getInt("role_id"));
				role.setName(rs.getString("role_name"));
				role.setDescription(rs.getString("role_description"));

				user.setRole(role);
				users.add(user);
			}

		} catch (SQLException e) {
			System.out.println("Khong the getUserList");
			e.printStackTrace();
		} 
		return users;
	}
	
	// them user
	public int addUser(String email, String password, String fullname, String phone, String address, int role) {
		String query = DbQuerry.ADD_USER;
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setString(3, fullname);
			statement.setString(4, phone);
			statement.setInt(5, role);
			statement.setString(6, address);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Khong the addUser");
			e.printStackTrace();
		}
		return 0;
	}
	
	// delete user by id
	public int delUserById(int id) {
		String query = "DELETE FROM users WHERE id="+id+";";
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Khong the deleteUserByID");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// find user by id
	public User findUserById(int id) {
		User user = null;
		String query = DbQuerry.USER_WITH_ID;
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				user = new User();
				
				user.setId(rs.getInt("user_id"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));

				Role role = new Role();
				role.setId(rs.getInt("role_id"));
				role.setName(rs.getString("role_name"));
				role.setDescription(rs.getString("role_description"));

				user.setRole(role);
			}
		} catch (SQLException e) {
			System.out.println("Khong the findUserById");
			e.printStackTrace();
		}

		return user;
	}

	public int updateUser(int id, String email, String password, String fullname, String phone, String address,
			int role) {
		String query = "UPDATE users\r\n"
				+ "SET email = ?, password = ?, fullname = ?, phone = ?, role_id = ?, address = ?\r\n"
				+ "WHERE id = "+id+";";
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setString(3, fullname);
			statement.setString(4, phone);
			statement.setInt(5, role);
			statement.setString(6, address);
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Khong the updateUser");
			e.printStackTrace();
		}
		return 0;
	}

	public int editAccount(int id, String email, String fullname, String phone, String address, String password) {
		String query = "UPDATE users\r\n"
				+ "SET email = ?, password = ?, fullname = ?, phone = ?, address = ?\r\n"
				+ "WHERE id = "+id+";";
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setString(3, fullname);
			statement.setString(4, phone);
			statement.setString(5, address);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Khong the editAccount");
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<User> getUserIsMember() {
		List<User> users = new LinkedList<User>();
		try {
			String query = DbQuerry.USER_IS_MEMBER;

			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));

				Role role = new Role();
				role.setId(rs.getInt("role_id"));
				role.setName(rs.getString("role_name"));
				role.setDescription(rs.getString("role_description"));

				user.setRole(role);
				users.add(user);
			}

		} catch (SQLException e) {
			System.out.println("Khong the getUserIsMember");
			e.printStackTrace();
		} 
		return users;
	}
}
