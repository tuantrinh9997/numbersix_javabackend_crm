package service;

import java.util.List;

import entity.StatisticAllProject;
import entity.StatisticStatus;

public interface StatisticService {

	List<StatisticAllProject> getStatisticAllProject();

	List<StatisticStatus> getStatisticStatusOfTask(int id, String role);

}
