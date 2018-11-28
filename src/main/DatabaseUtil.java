package main;

import Users.CurrentStaticUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {

    public static int insertAndGetGeneratedPrimaryKey (Connection database, String query) throws SQLException {

        Statement statement = database.createStatement();
        statement.executeUpdate (query, Statement.RETURN_GENERATED_KEYS);
        ResultSet result = statement.getGeneratedKeys();
        result.next();
        return result.getInt(1);
    }
}
