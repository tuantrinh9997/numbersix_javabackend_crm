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
		UrlConst.USER_DELETE,
		UrlConst.USER_UPDATE
})
public class UserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService _userService;
	private String action;
	
	@Override
	public void init() throws ServletException {
		super.init();
		_userService = new UserService_Implement();
		action = "";
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getServletPath();
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (action) {
		case UrlConst.USER_DASHBOARD:
			
			List<User> users = _userService.getUser();
			req.setAttribute("users", users);
			
			req.getRequestDispatcher(JspConst.USER_DASHBOARD)
				.forward(req, resp);
			break;
			
		case UrlConst.USER_ADD:
			req.getRequestDispatcher(JspConst.USER_ADD)
				.forward(req, resp);
			//doPost(req, resp);
			
			
			
			break;
			
		case UrlConst.USER_DELETE:
			
			break;
			
		case UrlConst.USER_UPDATE:
			
			break;
			
		case UrlConst.USER_PROFILE:
			
			break;
			
		case UrlConst.USER_FIND:
			
			break;
			
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		int role = Integer.parseInt(req.getParameter("role"));
		String address = req.getParameter("address");
		
		_userService.addUser(email, password, fullname, phone, address, role);
		
		req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
}
