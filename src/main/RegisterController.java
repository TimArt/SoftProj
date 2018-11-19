package main;

import Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class RegisterController {

    @FXML private Text actiontarget;
    @FXML private TextField username;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private ComboBox role;

    User newUser = new User();
    String result = null;


    @FXML protected void handleRegistration(ActionEvent event) throws IOException {

        String userName = username.getText();
        String userEmail = email.getText();
        String passWord = password.getText();
        String userRole = role.getValue().toString();

        result = newUser.register(userName, userEmail, passWord, userRole);

        actiontarget.setText(result);
    }
}
