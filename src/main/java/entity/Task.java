package entity;

public class Task {
	/* properties */
	private int id;
	private String name;
	private String description;
	private String start_date;
	private String end_date;
	
	private int status_id;
	private Status status;
	
	private int project_id;
	private Project project;
	private int user_id;
	private User assignee;

	/* contructor */
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param start_date
	 * @param end_date
	 * @param status
	 * @param project
	 * @param assignee
	 */
	public Task(int id, String name, String description, String start_date, String end_date, Status status,
			Project project, User assignee) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
		this.project = project;
		this.assignee = assignee;
	}
	public Task() {
		
	}

	/* getter/setter */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public User getAssignee() {
		return assignee;
	}
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
	
	/* method */
}
