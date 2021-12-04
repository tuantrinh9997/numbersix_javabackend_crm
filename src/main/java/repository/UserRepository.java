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
	//private Connection connection = null;
	private Connection _connection;
	public UserRepository(Connection connection) {
		_connection = connection;
	}
	
	 public User login(String username, String password) {
		 try {
			//nên viết dạng inner join thì dễ đọc hơn
			 String query = "SELECT u.id as user_id, u.fullname as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description \r\n"
						+ "FROM users u, roles r\r\n"
						+ "WHERE u.email="+"'"+username+"'"+" and u.password="+password+" and u.role_id = r.id;";
				
			 	
			 	PreparedStatement statement = _connection.prepareStatement(query);
				
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
				
				//ở đây
				System.out.println("Khong the ket noi den du lieu Authen");
				e.printStackTrace();
			} 
			//close tập trung
			return null;
	 }
	
	
	
	public List<User> getUser() {
		List<User> users = new LinkedList<User>();
		try {
			//connection = MySQLConnection.getConnection();
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
			System.out.println("Khong the ket noi den du lieu");
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
			System.out.println("Khong the ket noi du lieu");
			e.printStackTrace();
		}
		return 0;
	}
	
	// delete user by id
	public int delUser(int id) {
		String query = "DELETE FROM users WHERE id="+id+";";
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Khong the ket noi du lieu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// find user by id
	public User findUser(int id) {
		User user = null;
		String query = DbQuerry.USER_WITH_ID+id+";";
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int editAccount(int id, String email, String fullname, String phone, String address, String password) {
		String query = "UPDATE users\r\n"
				+ "SET email = '"+email+"', password = "+password+", fullname = '"+fullname+"', phone = '"+phone+"', address = '"+address+"'\r\n"
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

	public List<User> getUserIsMember() {
		List<User> users = new LinkedList<User>();
		try {
			//connection = MySQLConnection.getConnection();
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
			System.out.println("Khong the ket noi den du lieu");
			e.printStackTrace();
		} 
		return users;
	}
}
