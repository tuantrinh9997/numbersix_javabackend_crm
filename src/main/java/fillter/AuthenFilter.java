package fillter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

//import org.apache.jasper.tagplugins.jstl.core.ForEach;
//import org.apache.tomcat.util.http.parser.Cookie;

//cimport util.JspConst;
import util.UrlConst;

@WebFilter(urlPatterns = UrlConst.ROOT)
public class AuthenFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse respone, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) respone;
		
		//check co cookie hay ko?
		Cookie[] cookies = req.getCookies();
		
		String username = null;
		String role = null;
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("ck_user")) {
					username = cookie.getValue();
				}
				
				if(cookie.getName().equals("ck_role")) {
					role = cookie.getValue();
				}
			}
		}
		
		String action = req.getServletPath();
		
		boolean isAuthenticated = username != null && username != "";
		boolean isAnonymos = action.equals(UrlConst.AUTHEN_LOGIN) ||
				action.equals(UrlConst.AUTHEN_LOGOUT) ||
				action.contains("/assets/"); // neu gap /assets (cua bootstrap) cung cho qua
		
		if(isAnonymos) {
			chain.doFilter(req, resp);
		} else if (isAuthenticated) {
			req.setAttribute("role", role);
			req.setAttribute("username", username);
			
			chain.doFilter(req, resp);
			
		} else {
			resp.sendRedirect(req.getContextPath()+UrlConst.AUTHEN_LOGIN);
		}
	}
}
