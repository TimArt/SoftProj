package main;

import Users.CurrentStaticUser;

import java.sql.*;

public class DatabaseUtil {

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/softproj?useSSL=false",
                "root",
                "Meeral69");
    }

    public static int insertAndGetGeneratedPrimaryKey (Connection database, String query) throws SQLException {

        Statement statement = database.createStatement();
        statement.executeUpdate (query, Statement.RETURN_GENERATED_KEYS);
        ResultSet result = statement.getGeneratedKeys();
        result.next();
        return result.getInt(1);
    }
}
