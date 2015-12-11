package ua.knure.bezditnyi.web.listener;

import ua.knure.bezditnyi.dao.MemoryUserDao;
import ua.knure.bezditnyi.dao.UserDao;
import ua.knure.bezditnyi.service.UserService;
import ua.knure.bezditnyi.storage.UserStorage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Artem on 10.12.2015.
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserStorage storage = new UserStorage();
        UserDao userDao = new MemoryUserDao(storage);
        UserService userService = new UserService(userDao);

        servletContextEvent.getServletContext().setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
