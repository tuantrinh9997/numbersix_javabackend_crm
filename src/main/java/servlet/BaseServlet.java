package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MySQLConnection;
import service.ProjectService;
import service.ProjectService_Implement;
import service.StatisticService;
import service.Statistic_Implement;
import service.TaskService;
import service.TaskService_Implement;
import service.UserService;
import service.UserService_Implement;

public class BaseServlet extends HttpServlet{
	
	protected static final long serialVersionUID = 1L;
	protected ProjectService _projectService;
	protected TaskService _taskService;
	protected UserService _userService;
	protected StatisticService _statisticService;
	protected String _action;
	protected String _uri;
	protected Connection _connection;
	
	@Override
	public void init() throws ServletException {
		_connection = MySQLConnection.getConnection();
		_projectService = new ProjectService_Implement(_connection);
		_taskService = new TaskService_Implement(_connection);
		_userService = new UserService_Implement(_connection);
		_statisticService = new Statistic_Implement(_connection);
		super.init();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		//close connecttion ở đây
		try {
			if(!_connection.isClosed()) {
				_connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_action = req.getServletPath();
		_uri = req.getContextPath();
		super.service(req, resp);
	}
}
