package fillter;

import javax.servlet.annotation.WebFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

import util.UrlConst;
@WebFilter(filterName = "sitemesh", urlPatterns = UrlConst.ROOT)
public class SiteMesh extends SiteMeshFilter{

}
