package ua.knure.bezditnyi.db;

import java.sql.Connection;

/**
 * Created by Artem on 13.12.2015.
 */
public class ConnectionHolder {

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

    public static void setConnection(Connection connection) {
        connectionHolder.set(connection);
    }

    public static Connection getConnection() {
        return connectionHolder.get();
    }
}
