package repository;

import java.sql.Connection;

import db.MySQLConnection;

//Chắc bỏ cái này đi
public abstract class BaseRepository {
	protected Connection _connection;
	public BaseRepository() {
		_connection = MySQLConnection.getConnection();
	}
}
