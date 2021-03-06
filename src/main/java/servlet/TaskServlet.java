package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Project;
import entity.Task;
import util.JspConst;
import util.UrlConst;

@WebServlet(name = "taskServlet", urlPatterns = { 
		UrlConst.TASK_HOME, 
		UrlConst.TASK_ADD, 
		UrlConst.TASK_UPDATE,
		UrlConst.TASK_DELETE, 
		UrlConst.TASK_INFO 
		})
public class TaskServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = (String) req.getAttribute("role");
		switch (_action) {
		case UrlConst.TASK_HOME:
			getTask(req, resp);
			break;

		case UrlConst.TASK_ADD:
			if (role.equalsIgnoreCase("user"))
				getTask(req, resp);
			else
				req.getRequestDispatcher(JspConst.TASK_ADD).forward(req, resp);
			break;

		case UrlConst.TASK_DELETE:
			if (role.equalsIgnoreCase("user"))
				getTask(req, resp);
			else
				deleteTask(req, resp);
			break;

		case UrlConst.TASK_UPDATE:
			if (role.equalsIgnoreCase("user"))
				req.getRequestDispatcher(JspConst.TASK_UPDATE_USER).forward(req, resp);
			else
				req.getRequestDispatcher(JspConst.TASK_UPDATE).forward(req, resp);
			break;
		
		case UrlConst.TASK_INFO:
			getInfoTask(req, resp);
			break;

		default:
			break;
		}
	}

	private void getInfoTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Task task = _taskService.getInfoTask(id);
		req.setAttribute("task", task);
		
		req.getRequestDispatcher(JspConst.TASK_INFO).forward(req, resp);
	}

	private void deleteTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		_taskService.deleteTask(id);

		resp.sendRedirect(_uri + UrlConst.TASK_HOME);
	}

	private void getTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt((String) req.getAttribute("id"));
		String role = (String) req.getAttribute("role");

		List<Task> tasks = _taskService.getTask(id, role);
		req.setAttribute("tasks", tasks);
		req.getRequestDispatcher(JspConst.TASK_DASHBOARD).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = (String) req.getAttribute("role");
		switch (_action) {
		case UrlConst.TASK_ADD:
			addTask(req, resp);
			break;

		case UrlConst.TASK_UPDATE:
			if (role.equalsIgnoreCase("user"))
				updateTaskByUser(req, resp);
			else
				updateTask(req, resp);
			break;

		default:
			break;
		}
	}
	
	// done
	private void updateTaskByUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		int status = Integer.parseInt(req.getParameter("status"));

		_taskService.updateTaskByUser(id, status);
		resp.sendRedirect(_uri + UrlConst.TASK_HOME);
	}
	
	// 
	private void updateTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		String description = req.getParameter("description");
		int assignee = Integer.parseInt(req.getParameter("user_id"));

		_taskService.updateTask(id, name, start_date, end_date, description, assignee);
		resp.sendRedirect(_uri + UrlConst.TASK_HOME);
	}

	private void addTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		String description = req.getParameter("description");
		int assignee = Integer.parseInt(req.getParameter("user_id"));

		int id_leader = Integer.parseInt((String) req.getAttribute("id"));
		Project project = _taskService.getProject(id_leader);

		_taskService.addTask(name, start_date, end_date, description, assignee, project);
		resp.sendRedirect(_uri + UrlConst.TASK_HOME);
	}

}
