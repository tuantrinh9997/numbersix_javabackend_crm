package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JspConst;
import util.UrlConst;

@WebServlet(name = "authenServlet", urlPatterns = {
		UrlConst.AUTHEN_HOME,
		UrlConst.AUTHEN_LOGIN,
		UrlConst.AUTHEN_LOGOUT
})
public class AuthenServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getServletPath();
		switch (url) {
		case UrlConst.AUTHEN_LOGIN:
			loginGetAction(req, resp);
			break;

		default:
			break;
		}
	}
	
	private void loginGetAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.AUTHEN_LOGIN)
			.forward(req, resp);
	}
}
