package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import util.JspConst;
import util.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = { 
		UrlConst.USER_DASHBOARD, 
		UrlConst.USER_ADD, 
		UrlConst.USER_UPDATE,
		UrlConst.USER_DELETE,
		UrlConst.USER_PROFILE,
		UrlConst.USER_EDIT,
		UrlConst.USER_INFO
	})
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = (String) req.getAttribute("role");
		switch (_action) {
		case UrlConst.USER_DASHBOARD:
			if (role.equalsIgnoreCase("admin"))
				getUsers(req, resp);
			else getUserIsMember(req, resp);
			
			break;
			
		case UrlConst.USER_ADD:
			if (role.equalsIgnoreCase("admin"))
				req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);
			else getUsers(req, resp);
			break;

		case UrlConst.USER_DELETE:
			if (role.equalsIgnoreCase("admin"))
				deleteUserById(req, resp);
			else getUsers(req, resp);
			break;

		case UrlConst.USER_UPDATE:
			if (role.equalsIgnoreCase("admin"))
				req.getRequestDispatcher(JspConst.USER_UPDATE).forward(req, resp);
			else getUsers(req, resp);
			break;
		
		case UrlConst.USER_PROFILE:
			showProfile(req, resp);
			break;
			
		case UrlConst.USER_EDIT:
			req.getRequestDispatcher(JspConst.USER_EDIT).forward(req, resp);
			break;
			
		case UrlConst.USER_INFO:
			infoUser(req, resp);
			break;
			
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (_action) {
		case UrlConst.USER_ADD:
			addUser(req, resp);
			break;
			
		case UrlConst.USER_UPDATE:
			updateUser(req, resp);
			break;
			
		case UrlConst.USER_DASHBOARD:
			findUserById(req, resp);
			break;
			
		case UrlConst.USER_EDIT:
			editAccount(req, resp);
			break;
		default:
			break;
		}
	}
	
	private void getUserIsMember(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = _userService.getUserIsMember();
		req.setAttribute("users", users);

		req.getRequestDispatcher(JspConst.USER_MEMBER).forward(req, resp);
		
	}

	
	private void infoUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = _userService.findUserById(id);
		req.setAttribute("user", user);
		
		req.getRequestDispatcher(JspConst.USER_PROFILE).forward(req, resp);
	}


	private void editAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt((String) req.getAttribute("id")) ;
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		
		_userService.editAccount(id, email, fullname, phone, address, password);
		resp.sendRedirect(_uri+UrlConst.USER_PROFILE);
		
	}

	protected void getUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = _userService.getUserList();
		req.setAttribute("users", users);

		req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
	}

	protected void deleteUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		_userService.delUserById(id);

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

	protected void findUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("keyword"));
		User user = _userService.findUserById(id);
		
		req.setAttribute("user", user);
		
		req.getRequestDispatcher(JspConst.USER_FIND).forward(req, resp);
		
	}

	protected void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		int role = Integer.parseInt(req.getParameter("role"));

		_userService.updateUser(id, email, password, fullname, phone, address, role);
		

		resp.sendRedirect(_uri + UrlConst.USER_DASHBOARD);
	}
	
	protected void showProfile(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		int id = Integer.parseInt((String) req.getAttribute("id"));
		User user = _userService.findUserById(id);
		req.setAttribute("user", user);
		
		req.getRequestDispatcher(JspConst.USER_PROFILE).forward(req, resp);
	}
}
