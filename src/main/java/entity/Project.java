package entity;

public class Project {
	/* properties */
	private int id;
	private String name;
	private String description;
	private String start_date;
	private String end_date;
	
	//Cái này là created user
	private int user_id;
	private User user;
	
	/* contructor */
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param start_date
	 * @param end_date
	 * @param user
	 */
	public Project(int id, String name, String description, String start_date, String end_date, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.user = user;
	}
	public Project(int id, String name, String description, String start_date, String end_date, int user_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.user_id = user_id;
	}
	public Project() {
		
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	/* method */
}
