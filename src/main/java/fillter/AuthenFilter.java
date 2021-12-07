package fillter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MySQLConnection;
import service.UserService;
import service.UserService_Implement;

//import org.apache.jasper.tagplugins.jstl.core.ForEach;
//import org.apache.tomcat.util.http.parser.Cookie;

//cimport util.JspConst;
import util.UrlConst;

@WebFilter(urlPatterns = UrlConst.ROOT)
public class AuthenFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse respone, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) respone;

		String action = req.getServletPath();

		boolean allowAnonymos = action.equals(UrlConst.AUTHEN_LOGIN) || action.equals(UrlConst.AUTHEN_LOGOUT)
				|| action.contains("/assets/"); // neu gap /assets (cua bootstrap) cung cho qua

		if (allowAnonymos) {
			chain.doFilter(req, resp);

		} else {
			Cookie[] cookies = req.getCookies();

			String role = null;
			String userid = null;

			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("ck_role".equals(cookie.getName())) {
						role = cookie.getValue();
					}
					if ("ck_id".equals(cookie.getName())) {
						userid = cookie.getValue();
					}
				}
			}

			boolean isAuthenticated = userid != null && userid != "";
			if (isAuthenticated) {
				req.setAttribute("role", role);

				req.setAttribute("id", userid);

				Connection connection = MySQLConnection.getConnection();
				
				UserService userService = new UserService_Implement(connection);
				String username = userService.findUserById(Integer.parseInt(userid)).getName();
				req.setAttribute("username", username);

				try {
					if (!connection.isClosed()) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				chain.doFilter(req, resp);

			} else {
				resp.sendRedirect(req.getContextPath() + UrlConst.AUTHEN_LOGIN);
			}
		}
	}
}
