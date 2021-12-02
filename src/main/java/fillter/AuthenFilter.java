package fillter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		
		String action = req.getServletPath();
		
		boolean allowAnonymos = action.equals(UrlConst.AUTHEN_LOGIN) ||
				action.equals(UrlConst.AUTHEN_LOGOUT) ||
				action.contains("/assets/"); // neu gap /assets (cua bootstrap) cung cho qua
		
		if (allowAnonymos) {
			chain.doFilter(req, resp);
			
		} else {
			Cookie[] cookies = req.getCookies();
			
			String username = null;
			String role = null;
			String id = null;
			String name = null;
			
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if("ck_user".equals(cookie.getName())) {
						username = cookie.getValue();
					}
					if("ck_role".equals(cookie.getName())) {
						role = cookie.getValue();
					}
					if("ck_id".equals(cookie.getName())) {
						id = cookie.getValue();
					}
					if("ck_name".equals(cookie.getName())) {
						name = cookie.getValue();
					}
					
				}
			}
			//check
			boolean isAuthenticated = username != null && username != "";
			if (isAuthenticated) {
				req.setAttribute("role", role);
				req.setAttribute("username", username);
				req.setAttribute("id", id);
				req.setAttribute("name", name);
				System.out.println(name);
				
				chain.doFilter(req, resp);
				
			} else {
				resp.sendRedirect(req.getContextPath() + UrlConst.AUTHEN_LOGIN);
			}
		}		
	}
}
