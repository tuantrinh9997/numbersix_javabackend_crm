package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbQuerry;
import entity.StatisticAllProject;
import entity.StatisticStatus;

public class StatisticRepository {

	private Connection _connection;
	public StatisticRepository(Connection connection) {
		this._connection = connection;
	}
	
	public List<StatisticAllProject> getStatisticAllProject() {
		List<StatisticAllProject> statisticAllProject = new ArrayList<StatisticAllProject>();
		String query = DbQuerry.PROJECT_COUNT_TASK;
		
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				StatisticAllProject sap = new StatisticAllProject();
				sap.setNameProject(rs.getString("name"));
				sap.setSumOfTask(rs.getInt("sumOfTask"));
				sap.setSumOfMember(rs.getInt("sumOfMember"));
				
				statisticAllProject.add(sap);
			}
			
		} catch (SQLException e) {
			System.out.println("Khong the ket noi de getStatisticAllProject");
			e.printStackTrace();
		}
		return statisticAllProject;
	}

	public List<StatisticStatus> getStatisticStatusOfTask(int id, String role) {
		List<StatisticStatus> statisticStatus = new ArrayList<StatisticStatus>();
		String query = "";
		if (role.equalsIgnoreCase("leader"))
			query = DbQuerry.STATUS_COUNT_TASK;
		else query = DbQuerry.STATUS_COUNT_TASK_BY_MEMBER;
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				StatisticStatus ss = new StatisticStatus();
				ss.setNameTask(rs.getString("status_name"));
				ss.setSumOfMember(rs.getInt("sumOfTask"));
				
				statisticStatus.add(ss);
			}
			
		} catch (SQLException e) {
			System.out.println("Khong the ket noi de getStatisticAllProject");
			e.printStackTrace();
		}
		return statisticStatus;
	}

}
