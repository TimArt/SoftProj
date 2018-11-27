package Login;

import java.sql.*;

public class Login {

    public String login(String email, String password)
    {
        boolean user_exists = false;
        boolean password_correct = false;

        Connection conn = null;

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/softproj?useSSL=false",
                                              "root",
                                          "Meeral69");

            String query = "SELECT * FROM user WHERE email =?";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, email);

            // execute the prepared statement
            ResultSet resultSet = preparedStmt.executeQuery();
            if(resultSet.next()) {
                user_exists = true;
            }


            if( user_exists)
            {
                query = "SELECT * FROM user WHERE email =? AND password = ?";

                // create the mysql insert prepared statement
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, email);
                preparedStmt.setString (2, password);

                // execute the prepared statement
                resultSet = preparedStmt.executeQuery();
                if(resultSet.next()) {
                    password_correct = true;
                }

                if(password_correct)
                {
                    // DO THE ACTION
                    preparedStmt.close();
                    return "Successful Login!";
                }
                else
                {
                    //System.out.println("Password is not correct!");
                    preparedStmt.close();
                    return "Password is not correct!";
                }
            }
            else
            {
                //System.out.println("No user with this username!");
                preparedStmt.close();
                return "No user exists with this email!";
            }

        }catch(SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            return null;
        }
    }
}
