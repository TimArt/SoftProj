package Users;

import java.sql.*;

public class User {

    private String username;
    private static int userID = 0;
    private char[] passwordHash;


    public String register(String username, String useremail, String password , String role){

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
                return "User already exists!";
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

                    return "User Registered Successfully!";

                }catch (SQLException ex) {
                    // handle any errors
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                    preparedStmt.close();
                    return "SQL Error: " + ex.getMessage() + "\n";
                }

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return "SQL Error: " + ex.getMessage() + "\n";
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


