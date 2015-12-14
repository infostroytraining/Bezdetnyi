package ua.knure.bezditnyi.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.knure.bezditnyi.dao.exception.DaoException;
import ua.knure.bezditnyi.db.exception.TransactionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Artem on 13.12.2015.
 */
public class TransactionManager {

    private static final String URL = "jdbc:postgres//localhost:5432/userdb";
    private static final String USER = "app";
    private static final String PASSWORD = "qwerty";

    public static Logger log = LogManager.getLogger();

    public <T> T doTask(Transaction<T> transaction, int transactionIsolation) throws TransactionException {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            ConnectionHolder.setConnection(connection);
            // initialize connection with DB
            T result = transaction.execute();
            // close connection with DB
            connection.close();
            return result;
        } catch (SQLException e) {
            log.fatal("SQLException occurred during connection initialization", e);
            throw new TransactionException(e);
        } catch (DaoException e) {
            log.error("DaoException occurred when executing the transaction", e);
            throw new TransactionException(e);
        }
    }
}
