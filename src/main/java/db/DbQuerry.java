package db;

public class DbQuerry {
	/* USER */
	public static final String USER_WITH_ROLE = "SELECT u.id as user_id, u.fullname as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description \r\n"
			+ "FROM users u \r\n"
			+ "LEFT JOIN roles r ON u.role_id = r.id;";
	
	public static final String ADD_USER = "insert into users(email, password, fullname, phone, role_id, address)\r\n"
			+ "values\r\n"
			+ "	(?, ?, ?, ?, ?, ?);";
}
