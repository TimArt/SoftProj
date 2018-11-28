package Login;

import main.DatabaseUtil;

import java.sql.*;

public class Login {

    public Boolean login(String email, String password, StringBuilder errorMessage)
    {
        boolean user_exists = false;
        boolean password_correct = false;

        Connection conn = null;

        try{
            conn = DatabaseUtil.createConnection();

            String query = "SELECT * FROM User WHERE email =?";

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
                query = "SELECT * FROM User WHERE email =? AND password = ?";

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
                    errorMessage.append( "Successful Login!") ;
                    return true;
                }
                else
                {
                    //System.out.println("Password is not correct!");
                    preparedStmt.close();
                    errorMessage.append( "Password is not correct!") ;
                    return false;
                }
            }
            else
            {
                //System.out.println("No user with this username!");
                preparedStmt.close();
                errorMessage.append( "No user exists with this email!") ;
                return false;
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
