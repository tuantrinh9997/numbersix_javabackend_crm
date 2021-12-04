package db;

public class DbQuerry {
	/* STATUS */
	public static final String STATUS = "select *\r\n"
			+ "from status;";
	
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
	
	public static final String USER_IS_MEMBER = "SELECT u.id as user_id, u.fullname as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description \r\n"
			+ "FROM users u \r\n"
			+ "LEFT JOIN roles r ON u.role_id = r.id\r\n"
			+ "where r.id = 4";
	
	/* PROJECT */
	public static final String PROJECT_WITH_USER_ID = "SELECT p.id as project_id, p.name as project_name, start_date, end_date, description, u.fullname as user_name\r\n"
			+ "FROM project p \r\n"
			+ "LEFT JOIN users u ON p.creat_user = u.id\r\n"
			+ "WHERE u.id = ";
	
	public static final String PROJECT_WITH_USER = "SELECT p.id as project_id, p.name as project_name, start_date, end_date, description, u.fullname as user_name\r\n"
			+ "FROM project p \r\n"
			+ "LEFT JOIN users u ON p.creat_user = u.id\r\n;";
	
	public static final String ADD_PROJECT = "insert into project (name, start_date, end_date, description, creat_user)\r\n"
			+ "values\r\n"
			+ "	(?, ?, ?, ?, ?);";
	
	public static final String PROJECT_WITH_ID = "SELECT p.id as project_id, p.name as project_name, start_date, end_date, description, u.fullname as user_name\r\n"
			+ "FROM project p \r\n"
			+ "LEFT JOIN users u ON p.creat_user = u.id\r\n"
			+ "WHERE p.id = ";
	
	/* TASK */
	public static final String TASK_WITH_USER_AND_PROJECT = "SELECT t.id as task_id, t.name as task_name, t.start_date, t.end_date, u.fullname as assignee, p.name as project_name, s.name as status, t.description\r\n"
			+ "FROM task t \r\n"
			+ "LEFT JOIN users u ON t.assignee = u.id\r\n"
			+ "left join status s on t.status = s.id\r\n"
			+ "left join project p on t.project = p.id;";
	
	public static final String TASK_ADD = "insert into task (name, start_date, end_date, assignee, project, description)\r\n"
			+ "values\r\n"
			+ "	(?, ?, ?, ?, ?, ?);";
	
	public static final String TASK_WITH_USER_ID = "SELECT t.id as task_id, t.name as task_name, t.start_date, t.end_date, p.name as project_name, s.name as status, t.description, t.assignee \r\n"
			+ "FROM task t \r\n"
			+ "LEFT JOIN users u ON t.assignee = u.id\r\n"
			+ "left join status s on t.status = s.id\r\n"
			+ "left join project p on t.project = p.id\r\n"
			+ "where u.id = ";
	
	public static final String TASK_WITH_LEADER_ID = "select t.id as task_id, t.name as task_name, t.start_date, t.end_date, t.assignee, p.name as project_name, s.name as status, t.description\r\n"
			+ "from task t\r\n"
			+ "left join project p on t.project = p.id\r\n"
			+ "left join users u on p.creat_user = u.id\r\n"
			+ "left join status s on t.status = s.id\r\n"
			+ "where u.id = ";
}
