package db;

public class DbQuerry {
	/* USER */
	public static final String USER_WITH_ROLE = "SELECT u.id as user_id, u.fullname as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description \r\n"
			+ "FROM users u \r\n"
			+ "LEFT JOIN roles r ON u.role_id = r.id;";
	
	public static final String ADD_USER = "insert into users(email, password, fullname, phone, role_id, address)\r\n"
			+ "values\r\n"
			+ "	(?, ?, ?, ?, ?, ?);";
	
	public static final String USER_WITH_ID = "SELECT u.id as user_id, u.fullname as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description \r\n"
			+ "FROM users u \r\n"
			+ "LEFT JOIN roles r ON u.role_id = r.id\r\n"
			+ "where u.id = ";
	
	/* PROJECT */
	public static final String PROJECT_WITH_USER = "SELECT p.id as project_id, p.name as project_name, start_date, end_date, description, u.fullname as user_name\r\n"
			+ "FROM project p \r\n"
			+ "LEFT JOIN users u ON p.creat_user = u.id;";
	
	public static final String ADD_PROJECT = "insert into project (name, start_date, end_date, description, creat_user)\r\n"
			+ "values\r\n"
			+ "	(?, ?, ?, ?, ?);";
}
