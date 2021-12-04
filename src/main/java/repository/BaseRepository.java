package repository;

import java.sql.Connection;

import db.MySQLConnection;

public abstract class BaseRepository {
	protected Connection _connection;
	public BaseRepository() {
		_connection = MySQLConnection.getConnection();
	}
}
