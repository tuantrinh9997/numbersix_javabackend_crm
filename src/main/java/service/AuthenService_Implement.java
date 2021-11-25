package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MySQLConnection;
import entity.Role;
import entity.User;

public class AuthenService_Implement extends BaseService
	implements AuthenService{
	
	public User login(String username, String password) {
		// Viet lai ham nay
		//Select * from user where name =? and password = ?
		Connection connection = MySQLConnection.getConnection();
		User user = null;
		
		try {
			String query = "SELECT u.id as user_id, u.fullname as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description \r\n"
					+ "FROM users u, roles r\r\n"
					+ "WHERE u.email="+"'"+username+"'"+" and u.password="+password+" and u.role_id = r.id;";
			PreparedStatement statement = connection.prepareStatement(query);
			
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
			System.out.println("Khong the ket noi den du lieu Authen");
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return user;
	}

	
	public String getRoleByUserId(int userId) {
		String role = "";
		switch (userId) {
		case 1:
			role = "ADMIN";
			break;
		case 2:
			role = "LEADER";
			break;
		case 3:
			role = "PM";
			break;
		case 4:
			role = "USER";
			break;
		default:
			break;
		}
		return role;
	}

}
