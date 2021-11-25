package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import db.DbQuerry;
import entity.Role;
import entity.User;

public class UserRepository extends BaseRepository {
	//private Connection connection = null;

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
		} finally {
			if (_connection != null)
				try {
					_connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return users;
	}
}
