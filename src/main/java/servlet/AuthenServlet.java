package servlet;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.AuthenService;
import service.AuthenService_Implement;
//import service.UserService;
//import service.UserService_Implement;
import util.JspConst;
import util.UrlConst;

@WebServlet(name = "authenServlet", urlPatterns = {
		UrlConst.AUTHEN_HOME,
		UrlConst.AUTHEN_LOGIN,
		UrlConst.AUTHEN_LOGOUT
})
public class AuthenServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuthenService _authenService;
	private String _action;
	private String _uri;
	
	@Override
	public void init() throws ServletException {
		super.init();
		_authenService = new AuthenService_Implement();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_action = req.getServletPath();
		_uri = req.getContextPath();
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		switch (_action) {
		case UrlConst.AUTHEN_LOGIN:
			loginGetAction(req, resp);
			break;
		case UrlConst.AUTHEN_LOGOUT:
			logoutAction(req, resp);
			break;

		default:
			break;
		}
	}
	
	private void logoutAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("chay ham logoutAction");
		
		//Xoa cookie
		Cookie ck_user = new Cookie("ck_user", null);
		ck_user.setPath("/numbersixCRM");
		ck_user.setMaxAge(0);
		
		Cookie ck_role = new Cookie("ck_role", null);
		ck_role.setPath("/numbersixCRM");
		ck_role.setMaxAge(0);
		
		resp.addCookie(ck_user);
		resp.addCookie(ck_role);
		
		//redirect or render view
		loginGetAction(req, resp);
		
	}
	
	
	private void loginGetAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.AUTHEN_LOGIN)
			.forward(req, resp);
	}
	
	private void loginPostAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// lay user kiem tra xem co user hay khong
		User checkLogin = _authenService.login(username, password);
		
		if (checkLogin != null) {
			String role = _authenService.getRoleByUserId(checkLogin.getRole().getId());
			
			//Add cookie here
			Cookie ck_user = new Cookie("ck_user", username);
			ck_user.setPath("/numbersixCRM");
			Cookie ck_role = new Cookie("ck_role", role.toLowerCase());
			ck_role.setPath("/numbersixCRM");
			
			resp.addCookie(ck_user);
			resp.addCookie(ck_role);
			
			resp.sendRedirect(_uri + UrlConst.HOME);
			
		} else {
			loginGetAction(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (_action) {
		case UrlConst.AUTHEN_LOGIN:
			loginPostAction(req, resp);
			break;

		default:
			break;
		}

	}
}
