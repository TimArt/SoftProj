package main;
import java.sql.*;

public class Database {
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/softproj?useSSL=false",
                "root",
                "Meeral69");
    }
}
