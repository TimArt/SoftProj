package main;

import Login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
    @FXML private Text actiontarget;

    @FXML private TextField username;
    @FXML private PasswordField password;

    Login loginSystem = new Login();
    String userName = username.getText();
    String passWD = password.getText();

    @FXML protected void handleLogin(ActionEvent event) {

        if( loginSystem.login(userName, passWD, actiontarget ))
        {
            actiontarget.setText("Welcome, "
                    + userName
                    + "!\n");
        }
    }
}
