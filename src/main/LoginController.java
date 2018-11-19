package main;

import Login.Login;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class LoginController {
    @FXML private Text actiontarget;

    @FXML private TextField username;
    @FXML private PasswordField password;

    Login loginSystem = new Login();


    @FXML protected void handleLogin(ActionEvent event) throws IOException {

        String userName = username.getText();
        String passWD = password.getText();

        if( loginSystem.login(userName, passWD, actiontarget ))
        {
            actiontarget.setText("Welcome, "
                    + userName
                    + "!\n");


            // If User has been authenticated, determine the type of user
            // (admin, professor, student, etc)

            // Based on the type of user, go to the appropriate page
            // switch (userType) { .... (something like this)

            // IF USER IS STUDENT
            Parent studentRoot = FXMLLoader.load (getClass().getResource("StudentRoot.fxml"));
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(new Scene (studentRoot));
            appStage.show();

        }
    }

    @FXML protected  void goToRegistrationPage(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent studentRoot = FXMLLoader.load (getClass().getResource("register.fxml"));
        Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        appStage.setScene(new Scene(studentRoot));
        appStage.show();
    }
}
