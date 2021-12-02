package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;
import service.UserService_Implement;
import util.JspConst;
import util.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = { 
		UrlConst.USER_DASHBOARD, 
		UrlConst.USER_ADD, 
		UrlConst.USER_UPDATE,
		UrlConst.USER_DELETE,
		UrlConst.USER_PROFILE
	})
public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService _userService;
	private String action;
	private String _uri;

	@Override
	public void init() throws ServletException {
		super.init();
		_userService = new UserService_Implement();
		action = "";
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getServletPath();
		_uri = req.getContextPath();
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = (String) req.getAttribute("role");
		switch (action) {
		case UrlConst.USER_DASHBOARD:
			getUsers(req, resp);
			break;
		case UrlConst.USER_ADD:
			if (role.equalsIgnoreCase("leader"))
				getUsers(req, resp);
			req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);
			break;

		case UrlConst.USER_DELETE:
			if (role.equalsIgnoreCase("leader"))
				getUsers(req, resp);
			deleteUser(req, resp);
			break;

		case UrlConst.USER_UPDATE:
			if (role.equalsIgnoreCase("leader"))
				getUsers(req, resp);
			req.getRequestDispatcher(JspConst.USER_UPDATE).forward(req, resp);
			break;
		
		case UrlConst.USER_PROFILE:
			showProfile(req, resp);
			break;
			
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (action) {
		case UrlConst.USER_ADD:
			addUser(req, resp);
			break;
		case UrlConst.USER_UPDATE:
			updateUser(req, resp);
			break;
		case UrlConst.USER_DASHBOARD:
			findUser(req, resp);
			break;

		default:
			break;
		}
	}

	protected void getUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = _userService.getUser();
		req.setAttribute("users", users);

		req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
	}

	protected void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		_userService.delUser(id);

		resp.sendRedirect(_uri + UrlConst.USER_DASHBOARD);
	}

	protected void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		int role = Integer.parseInt(req.getParameter("role"));
		String address = req.getParameter("address");

		_userService.addUser(email, password, fullname, phone, address, role);

		resp.sendRedirect(_uri + UrlConst.USER_DASHBOARD);
	}

	protected void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("keyword"));
		User user = _userService.findUser(id);
		
		req.setAttribute("user", user);
		
		req.getRequestDispatcher(JspConst.USER_FIND).forward(req, resp);
		
	}

	protected void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		int role = Integer.parseInt(req.getParameter("role"));
		String address = req.getParameter("address");

		_userService.updateUser(id, email, password, fullname, phone, address, role);
		

		resp.sendRedirect(_uri + UrlConst.USER_DASHBOARD);
	}
	
	protected void showProfile(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("---"+id);
		User user = _userService.findUser(id);
		System.out.println(user.getEmail());
		req.setAttribute("user", user);
		
		req.getRequestDispatcher(JspConst.USER_PROFILE).forward(req, resp);
	}
}
