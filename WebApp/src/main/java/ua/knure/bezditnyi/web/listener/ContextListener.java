package ua.knure.bezditnyi.web.listener;

import ua.knure.bezditnyi.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.knure.bezditnyi.web.listener.factory.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Artem on 10.12.2015.
 */
public class ContextListener implements ServletContextListener {

    private static Logger logger = LogManager.getLogger(ContextListener.class);
    private static final String STORAGE_INIT_PARAMETER = "storage";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        String storageMode = context.getInitParameter(STORAGE_INIT_PARAMETER);

        logger.debug("Try to initialize service for {} storage mode", storageMode);
        UserService userService = ServiceFactory.getUserService(storageMode);
        logger.debug("Service initialized. Service: {}", userService);

        context.setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug("Servlet context is destroyed");
    }
}
