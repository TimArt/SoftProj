package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
    @FXML private Text actiontarget;

    @FXML private TextField username;
    @FXML private PasswordField password;

    @FXML protected void handleLogin(ActionEvent event) {

        actiontarget.setText("Login button pressed with\nUsername: "
                + username.getText()
                + "\nPassword: "
                + password.getText());
    }
}
