package service;

import java.sql.Connection;
import java.util.List;

import entity.StatisticAllProject;
import entity.StatisticStatus;
import repository.StatisticRepository;

public class Statistic_Implement implements StatisticService{
	private StatisticRepository statisticRepository;
	
	public Statistic_Implement(Connection connection) {
		statisticRepository = new StatisticRepository(connection);
	}

	public List<StatisticAllProject> getStatisticAllProject() {
		return statisticRepository.getStatisticAllProject();
	}

	public List<StatisticStatus> getStatisticStatusOfTask(int id, String role) {
		return statisticRepository.getStatisticStatusOfTask(id, role);
	}
}
