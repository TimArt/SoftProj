package Users;

import java.sql.*;

public class User {

    private String username;
    private int userID;
    private char[] passwordHash;

    public User()
    {

    }

    public User(String username, int userID)
    {
        this.username = username;
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public int getUserID() {
        return userID;
    }

    public boolean register(String username, String useremail, String password , String role, StringBuilder errorMessage){

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/softproj?useSSL=false",
                                              "root",
                                          "Meeral69");

            String query = "SELECT * FROM user WHERE email =?";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, useremail);

            // execute the prepared statement
            ResultSet resultSet = preparedStmt.executeQuery();
            if(resultSet.next()) {
                preparedStmt.close();
                errorMessage.append( "User already exists!") ;
                return false;
            }

            else{
                try{
                    query = " insert into user (name, password, role, isApproved, email)" + " values ( ?, ?, ?, ?, ?)";

                    // create the mysql insert preparedstatement
                    preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, username);
                    preparedStmt.setString (2, password);
                    preparedStmt.setString(3, role);
                    preparedStmt.setBoolean(4, false);
                    preparedStmt.setString(5, useremail);

                    // execute the preparedstatement
                    preparedStmt.execute();

                    return true;

                }catch (SQLException ex) {
                    // handle any errors
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                    preparedStmt.close();
                    errorMessage.append( "SQL Error: " + ex.getMessage() + "\n") ;
                    //errorMessage = "SQL Error: " + ex.getMessage() + "\n";
                    return false;
                }

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            errorMessage.append("SQL Error: " + ex.getMessage() + "\n");
            return false;
        }
    }

    public boolean login(String username, String passwword){
        return false;
    }

    public String getname(){
        return username;
    }

    public boolean changePSWD(String oldPassword, String newPassword)
    {
        return false;
    }
}
