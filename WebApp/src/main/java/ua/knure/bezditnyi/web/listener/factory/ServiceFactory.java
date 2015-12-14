package ua.knure.bezditnyi.web.listener.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.knure.bezditnyi.dao.implementation.MemoryUserDao;
import ua.knure.bezditnyi.dao.implementation.PostgreSqlUserDao;
import ua.knure.bezditnyi.dao.implementation.UserStorage;
import ua.knure.bezditnyi.dao.interfaces.UserDao;
import ua.knure.bezditnyi.db.TransactionManager;
import ua.knure.bezditnyi.service.MemoryUserService;
import ua.knure.bezditnyi.service.UserService;
import ua.knure.bezditnyi.service.TransactionalUserService;

import java.util.ServiceConfigurationError;

/**
 * Created by Artem on 13.12.2015.
 */
public class ServiceFactory {
    public static final String MEMORY = "memory";
    public static final String DB = "db";
    private static final String POSTGRE_DRIVER = "org.postgresql.Driver";

    private static Logger logger = LogManager.getLogger();

    public static UserService getUserService(String type) {
        if (type == null || type.isEmpty()) {
            logger.fatal("Could initialize application. Source type is null or empty");
            throw new IllegalArgumentException();
        }
        if (type.equals(MEMORY)) {
            return initMemoryService();
        } else if (type.equals(DB)) {
            loadPostgreDriver();
            return initTransactionalService();
        } else {
            logger.fatal("Could initialize application with source type {}", type);
            throw new ServiceConfigurationError("Could initialize application with source type [" + type + "]");
        }
    }

    private static void loadPostgreDriver() {
        try {
            Class.forName(POSTGRE_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.fatal("Could load {} driver", POSTGRE_DRIVER);
            throw new ServiceConfigurationError("Could load" + POSTGRE_DRIVER + "driver");
        }
    }

    private static UserService initMemoryService() {
        UserStorage storage = new UserStorage();
        UserDao userDao = new MemoryUserDao(storage);
        return new MemoryUserService(userDao);
    }

    private static UserService initTransactionalService() {
        TransactionManager transactionManager = new TransactionManager();
        UserDao userDdao = new PostgreSqlUserDao();
        return new TransactionalUserService(transactionManager, userDdao);
    }
}
