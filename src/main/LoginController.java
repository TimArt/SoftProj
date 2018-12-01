package main;

import Login.Login;
import Users.CurrentStaticUser;
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


        StringBuilder errorMessage = new StringBuilder();
        //String result = loginSystem.login(userEmail, passWD);

        if (loginSystem.login(userEmail, passWD, errorMessage))
        {
            Connection conn = null;
            actiontarget.setText(errorMessage.toString());

            try{
                conn = DatabaseUtil.createConnection();

                String query = "SELECT * FROM User WHERE email = ? ";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, userEmail);

                ResultSet resultSet = preparedStmt.executeQuery();

                String userRole = null;

                if(resultSet.next()){

                    userRole = resultSet.getString("role");
                    CurrentStaticUser.userId = resultSet.getInt("userID");
                    CurrentStaticUser.username = resultSet.getString("name");
                    CurrentStaticUser.password = resultSet.getString("password");
                    CurrentStaticUser.teamId = resultSet.getInt("teamId");

                    preparedStmt.close();
                }

                Parent sceneRoot = null;

                // Change view depending on User Role
                switch(userRole){
                    case "Student":
                        if (CurrentStaticUser.teamId != 0)  // Student Root if Student has a team
                            sceneRoot = FXMLLoader.load (getClass().getResource("StudentRoot.fxml"));
                        else // Team creation if Student has no team
                            sceneRoot = FXMLLoader.load (getClass().getResource("CreateTeam.fxml"));
                        break;

                    case "Admin":
                        sceneRoot = FXMLLoader.load (getClass().getResource("AdminRoot.fxml"));
                        break;

                    case "RPM":
                        //sceneRoot = FXMLLoader.load (getClass().getResource("RPMpage.fxml"));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RPMpage.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(new Scene(root, 800, 600));
                        RPMcontroller controller = fxmlLoader.<RPMcontroller>getController();
                        controller.initializeNotifications();
                        appStage.show();
                        break;

                    case "Reviewer":
                        sceneRoot = FXMLLoader.load (getClass().getResource("ReviewerPage.fxml"));
                        break;

                    case "Lecturer":
                        sceneRoot = FXMLLoader.load (getClass().getResource("LecturerPage.fxml"));
                        break;
                }

                // Setup View
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(new Scene (sceneRoot));
                appStage.show();

            }catch(SQLException ex){
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
        else{
            actiontarget.setText(errorMessage.toString());
        }
    }

    @FXML protected  void goToRegistrationPage(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent studentRoot = FXMLLoader.load (getClass().getResource("register.fxml"));
        Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        appStage.setScene(new Scene(studentRoot));
        appStage.show();
    }
}
