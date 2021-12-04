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
	//Dùng inner join đúng hơn
	public static final String PROJECT_WITH_USER_ID = "SELECT p.id as project_id, p.name as project_name, start_date, end_date, description, u.id as user_id, u.fullname as user_name\r\n"
			+ "FROM project p \r\n"
			+ "LEFT JOIN users u ON p.creat_user = u.id\r\n"
			+ "WHERE u.id = ";
	
	public static final String PROJECT_WITH_USER = "SELECT p.id as project_id, p.name as project_name, start_date, end_date, description,  u.id as user_id, u.fullname as user_name\r\n"
			+ "FROM project p \r\n"
			+ "LEFT JOIN users u ON p.creat_user = u.id\r\n;";
	
	public static final String ADD_PROJECT = "insert into project (name, start_date, end_date, description, creat_user)\r\n"
			+ "values\r\n"
			+ "	(?, ?, ?, ?, ?);";
	
	public static final String PROJECT_WITH_ID = "SELECT p.id as project_id, p.name as project_name, start_date, end_date, description, u.id as user_id, u.fullname as user_name\r\n"
			+ "FROM project p \r\n"
			+ "LEFT JOIN users u ON p.creat_user = u.id\r\n"
			+ "WHERE p.id = ";
	
	/* TASK */
	//inner join đúng hơn
	public static final String TASK_WITH_USER_AND_PROJECT = "SELECT t.id as task_id, t.name as task_name, t.start_date, t.end_date, u.id as user_id, u.fullname as assignee, p.id as project_id, p.name as project_name, s.id as status_id, s.name as status, t.description\r\n"
			+ "FROM task t \r\n"
			+ "INNER JOIN users u ON t.assignee = u.id\r\n"
			+ "INNER join status s on t.status = s.id\r\n"
			+ "INNER join project p on t.project = p.id;";
	
	//CÁI NÀY OK
	public static final String TASK_ADD = "insert into task (name, start_date, end_date, assignee, project, description)\r\n"
			+ "values\r\n"
			+ "	(?, ?, ?, ?, ?, ?);";
	
	//Nên dùng prepare statement ?
	public static final String TASK_WITH_USER_ID = "SELECT t.id as task_id, t.name as task_name, t.start_date, t.end_date, p.id as project_id, p.name as project_name, s.id as status_id, s.name as status, t.description, t.assignee, u.id as user_id \r\n"
			+ "FROM task t \r\n"
			+ "INNER JOIN users u ON t.assignee = u.id\r\n"
			+ "INNER join status s on t.status = s.id\r\n"
			+ "INNER join project p on t.project = p.id\r\n"
			+ "where u.id = ";
	
	public static final String TASK_WITH_LEADER_ID = "select t.id as task_id, t.name as task_name, t.start_date, t.end_date, t.assignee, p.id as project_id, p.name as project_name, s.id as status_id, s.name as status, t.description, u.id as user_id \r\n"
			+ "from task t\r\n"
			+ "INNER join project p on t.project = p.id\r\n"
			+ "INNER join users u on p.creat_user = u.id\r\n"
			+ "INNER join status s on t.status = s.id\r\n"
			+ "where u.id = ";
}
