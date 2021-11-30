package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import db.DbQuerry;
import entity.Status;

public class StatusRepository extends BaseRepository{
	public List<Status> getStatus(){
		List<Status> statusList = new LinkedList<Status>();
		String query = DbQuerry.STATUS;
		try {
			PreparedStatement statement = _connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Status status = new Status();
				status.setId(rs.getInt("id"));
				status.setName(rs.getString("name"));
				status.setDescription(rs.getString("description"));
				
				statusList.add(status);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return statusList;
	}
}
