package my.vaadin.web;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(
    name = "Vaadin Application Servlet",
    urlPatterns = "/*",
    initParams = {
            @WebInitParam(name = "applicationBean", value = "my.app"),
            @WebInitParam(name = "productionMode", value = "false")
    }
)
public class MyServlet extends AbstractApplicationServlet {

    private WebApplicationContext applicationContext;
    private Class<? extends Application> applicationClass;
    private String applicationBean;

    @SuppressWarnings("unchecked")
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        applicationBean = servletConfig.getInitParameter("applicationBean");
        if (applicationBean == null) {
            throw new ServletException("ApplicationBean not specified in servlet parameters");
        }
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        applicationClass = (Class<? extends Application>) applicationContext.getType(applicationBean);
    }


    @Override
    protected Application getNewApplication(HttpServletRequest request) throws ServletException {
        return (Application) applicationContext.getBean(applicationBean);
    }

    @Override
    protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
        return applicationClass;
    }
}
