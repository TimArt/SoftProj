package Users;

import Login.Login;
import main.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Users.CurrentStaticUser.email;

public class Admin extends User {


    public Admin(String username, int userID) {
        super(username, userID);
    }

    // Admin creates User object with username and password
    // and informs the User about his/her username and password.
    // User will need to change the password after his/her first login.
    public boolean addUser(String username, String password, String usertype, Login loginSystem)
    {
        //return loginSystem.addUser(username,password, usertype);
        return false;
    }

    /*
    *
    * This Function removes an existing user
    * Takes User E-mail as parameter
    * Returns TRUE if user exists and removed
    * Otherwise returns FALSE if user does not exist in Database
    *
    */
    public boolean removeUser(String email) throws SQLException {

        Connection conn = DatabaseUtil.createConnection();
        String query = "SELECT * FROM USER WHERE email ="+ email;
        Statement statement = conn.createStatement();
        ResultSet userFoundFromDB = statement.executeQuery(query);

        if(userFoundFromDB.next()){
            query = "DELETE FROM USER WHERE email ="+ email;
            statement = conn.createStatement();
            statement.execute(query);
            return true;
        }
        else
            return false;
    }

    /*
     *
     * This Function approves an existing user
     * Takes User E-mail as parameter
     * Returns TRUE if user exists and approved
     * Otherwise returns FALSE if user does not exist in Database
     *
     */
    public boolean approveUser(String email) throws SQLException {

        Connection conn = DatabaseUtil.createConnection();
        String query = "SELECT * FROM USER WHERE email ="+ email;
        Statement statement = conn.createStatement();
        ResultSet userFoundFromDB = statement.executeQuery(query);

        if(userFoundFromDB.next()){
            query = "UPDATE User SET isApproved = TRUE WHERE email ="+ email;
            statement = conn.createStatement();
            statement.execute(query);
            return true;
        }
        else
            return false;
    }

    /*
     *
     * This Function approves an existing user
     * Takes User ID as parameter
     * Returns TRUE if user exists and approved
     * Otherwise returns FALSE if user does not exist in Database
     *
     */
    public boolean approveUser(int userID) throws SQLException {

        Connection conn = DatabaseUtil.createConnection();
        String query = "SELECT * FROM USER WHERE userID ="+ userID;
        Statement statement = conn.createStatement();
        ResultSet userFoundFromDB = statement.executeQuery(query);

        if(userFoundFromDB.next()){
            query = "UPDATE User SET isApproved = TRUE WHERE userID ="+ userID;
            statement = conn.createStatement();
            statement.execute(query);
            return true;
        }
        else
            return false;

    }

    /*
     *
     * This Function removes an existing user
     * Takes User ID as parameter
     * Returns TRUE if user exists and removed
     * Otherwise returns FALSE if user does not exist in Database
     *
     */
    public boolean removeUser(int userID) throws SQLException {
        Connection conn = DatabaseUtil.createConnection();
        String query = "SELECT * FROM USER WHERE userID ="+ userID;
        Statement statement = conn.createStatement();
        ResultSet userFoundFromDB = statement.executeQuery(query);

        if(userFoundFromDB.next()){
            query = "DELETE FROM USER WHERE userID ="+ userID;
            statement = conn.createStatement();
            statement.execute(query);
            return true;
        }
        else
            return false;

    }

    public void addreviewTemplate(int artifactType, String data)
    {

    }

    public void addNotificationMapping(int notificationType[])
    {

    }
}
