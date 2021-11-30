package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.Project;
import service.ProjectService;
import service.ProjectService_Implement;
import util.JspConst;
import util.UrlConst;

@WebServlet(name = "projectServlet", urlPatterns = {
		UrlConst.PROJECT_HOME,
		UrlConst.PROJECT_ADD,
		UrlConst.PROJECT_UPDATE,
		UrlConst.PROJECT_DELETE,
		UrlConst.PROJECT_INFO
})

public class ProjectServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ProjectService _service;
	private String _action;
	private String _uri;
	
	@Override
	public void init() throws ServletException {
		super.init();
		_service = new ProjectService_Implement();
		_action = "";
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_action = req.getServletPath();
		_uri = req.getContextPath();
		// super de duoi cung neu khong se bi loi khi load web page
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (_action) {
		case UrlConst.PROJECT_HOME:
			getProject(req, resp);
			break;
			
		case UrlConst.PROJECT_ADD:
			req.getRequestDispatcher(JspConst.PROJECT_ADD).forward(req, resp);
			break;
			
		case UrlConst.PROJECT_DELETE:
			deleteProject(req, resp);
			break;
			
		case UrlConst.PROJECT_UPDATE:
			req.getRequestDispatcher(JspConst.PROJECT_UPDATE).forward(req, resp);
			break;
			
		case UrlConst.PROJECT_INFO:
			getInfoProject(req, resp);
			break;
			
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (_action) {
		case UrlConst.PROJECT_ADD:
			addProject(req, resp);
			break;
		
		case UrlConst.PROJECT_UPDATE:
			updateProject(req, resp);
			break;
			
		default:
			break;
		}
	}

	private void updateProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		String description = req.getParameter("description");
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		
		_service.updateProject(id, name, start_date, end_date, description, user_id);
		resp.sendRedirect(_uri+UrlConst.PROJECT_HOME);
	}

	private void addProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		String description = req.getParameter("description");
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		
		_service.addProject(name, start_date, end_date, description, user_id);
		resp.sendRedirect(_uri + UrlConst.PROJECT_HOME);
		
	}
	
	private void getInfoProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Project project = _service.getInfoProject(id);
		req.setAttribute("project", project);
		
		req.getRequestDispatcher(JspConst.PROJECT_INFO).forward(req, resp);
	}
	
	private void deleteProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		_service.deleteProject(id);
		
		resp.sendRedirect(_uri+UrlConst.PROJECT_HOME);
		
	}
	
	private void getProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Project> projects = _service.getProject();
		
		req.setAttribute("projects", projects);
		req.getRequestDispatcher(JspConst.PROJECT_DASHBOARD).forward(req, resp);
		
	}
}
