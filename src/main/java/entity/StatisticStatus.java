package entity;

public class StatisticStatus {
	private String nameTask;
	private int sumOfMember;

	public StatisticStatus(String nameTask, int sumOfMember) {
		this.nameTask = nameTask;
		this.sumOfMember = sumOfMember;
	}
	
	public StatisticStatus() {
		
	}
	
	public String getNameTask() {
		return nameTask;
	}
	
	public void setNameTask(String nameTask) {
		this.nameTask = nameTask;
	}
	
	public int getSumOfMember() {
		return sumOfMember;
	}
	
	public void setSumOfMember(int sumOfMember) {
		this.sumOfMember = sumOfMember;
	}
	
	
}
