package main;

import Login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {
    @FXML private Text actiontarget;
    @FXML private TextField email;
    @FXML private PasswordField password;

    Login loginSystem = new Login();


    @FXML protected void handleLogin(ActionEvent event) throws IOException {

        String userEmail = email.getText();
        String passWD = password.getText();

        String result = loginSystem.login(userEmail, passWD);
        if( result != null)
        {
            Connection conn = null;
            actiontarget.setText(result);


            // If User has been authenticated, determine the type of user
            // (admin, professor, student, etc)

            // Based on the type of user, go to the appropriate page
            // switch (userType) { .... (something like this)


            if(result == "Successful Login!"){
                try{
                    conn = Database.createConnection();

                    String query = "SELECT * FROM User WHERE email = ? and role = ?";


                    // IF USER IS STUDENT

                    // create the mysql insert prepared statement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, userEmail);
                    preparedStmt.setString (2, "Student");

                    // execute the prepared statement
                    ResultSet resultSet = preparedStmt.executeQuery();
                    if(resultSet.next()) {
                        preparedStmt.close();
                        Parent studentRoot = FXMLLoader.load (getClass().getResource("StudentRoot.fxml"));
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(new Scene (studentRoot));
                        appStage.show();
                    }

                }catch(SQLException ex){
                    // handle any errors
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                }

            }
        }
        else{
            actiontarget.setText("Login Failed Due to Connection Error!");
        }
    }

    @FXML protected  void goToRegistrationPage(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent studentRoot = FXMLLoader.load (getClass().getResource("register.fxml"));
        Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        appStage.setScene(new Scene(studentRoot));
        appStage.show();
    }
}
