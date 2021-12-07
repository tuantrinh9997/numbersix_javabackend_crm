package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.StatisticAllProject;
import entity.StatisticStatus;
import util.JspConst;
import util.UrlConst;

@WebServlet(name = "statisticServlet", urlPatterns = {
		UrlConst.STATISTIC
})
public class StatisticServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = (String) req.getAttribute("role");
		switch (_action) {
		case UrlConst.STATISTIC:
			if (role.equalsIgnoreCase("admin")) {
				statisticAllProject(req, resp);
			} else getStatisticStatusOfTask(req, resp);
			break;

		default:
			break;
		}
	}


	private void getStatisticStatusOfTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt((String) req.getAttribute("id"));
		String role = (String) req.getAttribute("role");
		List<StatisticStatus> statisticStatus = _statisticService.getStatisticStatusOfTask(id, role);
		
		req.setAttribute("statisticStatus", statisticStatus);
		
		req.getRequestDispatcher(JspConst.STATISTIC_STATUS_TASK).forward(req, resp);
	}

	private void statisticAllProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StatisticAllProject> statisticAllProjects = _statisticService.getStatisticAllProject();
		
		req.setAttribute("statisticAllProjects", statisticAllProjects);
		
		req.getRequestDispatcher(JspConst.STATISTIC_PROJECT).forward(req, resp);
		
	}
}
