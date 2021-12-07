package entity;

public class StatisticAllProject {
	private String nameProject;
	private int sumOfTask;
	private int sumOfMember;

	public StatisticAllProject(String nameProject, int sumOfTask, int sumOfMember) {
		this.nameProject = nameProject;
		this.sumOfTask = sumOfTask;
		this.sumOfMember = sumOfMember;
	}
	
	public StatisticAllProject() {
		
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public int getSumOfTask() {
		return sumOfTask;
	}

	public void setSumOfTask(int sumOfTask) {
		this.sumOfTask = sumOfTask;
	}

	public int getSumOfMember() {
		return sumOfMember;
	}

	public void setSumOfMember(int sumOfMember) {
		this.sumOfMember = sumOfMember;
	}
	
	
}
