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
			System.out.println("---filter of Action"+ action);
			Cookie[] cookies = req.getCookies();
			
			String username = null;
			String role = null;
			
			if (cookies != null) {
				
				System.out.println("---cookies lenght:"+ cookies.length);
				for (Cookie cookie : cookies) {
					
					System.out.println("---cookie name:"+ cookie.getName());
					System.out.println("---cookie value:"+ cookie.getValue());
					
					if("ck_user".equals(cookie.getName())) {
						username = cookie.getValue();
					}
					if("ck_role".equals(cookie.getName())) {
						role = cookie.getValue();
					}
					
				}
			}
			//check
			//boolean isAuthenticated = username != null && username != "";
			if (username != null) {
				System.out.println("---filter of Action is isAuthenticated: "+ action);
				//System.out.println("---filter isAuthenticated: "+ action);
				System.out.println("----username: "+ username);
				System.out.println("----role: "+ role);
				req.setAttribute("role", role);
				req.setAttribute("username", username);
				
				chain.doFilter(req, resp);
				
			} else {
				System.out.println("----filter of Action is not Authenticated: "+ action);
				System.out.println("----username: "+ username);
				System.out.println("----role: "+ role);
				
				resp.sendRedirect(req.getContextPath() + UrlConst.AUTHEN_LOGIN);
			}
		}		
	}
}
