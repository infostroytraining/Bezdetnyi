package ua.knure.bezditnyi.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.knure.bezditnyi.dao.exception.DaoException;
import ua.knure.bezditnyi.dao.interfaces.UserDao;
import ua.knure.bezditnyi.db.ConnectionHolder;
import ua.knure.bezditnyi.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Artem on 13.12.2015.
 */
public class PostgreSqlUserDao implements UserDao {

    public static final String INSERT_QUERY =
            "INSERT INTO user(id, first_name, last_name, email, password) VALUES(0, ?, ?, ?, ?)";
    private static final Logger log = LogManager.getLogger();

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User create() throws DaoException{
        User user = new User();
        log.exit(user);
        try {
            return this.insert(user);
        } catch (DaoException e) {
            log.error("SQLException when trying to create a user record", e);
            throw new DaoException(e);
        }
    }

    @Override
    public User insert(User user) throws DaoException{
        log.entry(user);

        Connection connection = ConnectionHolder.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            prepareStatementForInsert(statement, user);
        } catch (SQLException e){
            log.error("SQLException when trying to insert the user record", e);
            throw new DaoException(e);
        }
        log.exit(user);
        return user;
    }

    private void prepareStatementForInsert(PreparedStatement statement, User user) throws SQLException{
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPassword());
        int count = statement.executeUpdate();
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    private User parseResultSet(ResultSet resultSet) throws DaoException{
        User user = new User();
        try {
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setEmail(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
            }
        } catch (SQLException e){
            log.error("SQLException occurred when parsing ResultSet");
            throw new DaoException(e);
        }
        return user;
    }
}