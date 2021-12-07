package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import db.DbQuerry;
import entity.Status;

public class StatusRepository{
	
	private Connection _connection;
	public StatusRepository(Connection connection) {
		_connection = connection;
	}
	
	public Status findById(int statusId) {
		String sql = "Select * from status where id = ?";
		Status rt = null;
		try {
           
            PreparedStatement stmt = _connection.prepareStatement(sql);
            stmt.setInt(1, statusId);
            ResultSet rs = stmt.executeQuery();
            // show data
            while (rs.next()) {
            	rt = new Status(
            			rs.getInt("id"),
            			rs.getString("name"),
            			rs.getString("description")
                		);
            }
            stmt.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return rt;
	}
	
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
