package main;

import Login.Login;
import Login.LoginReturn;
import Users.Submitter;
import Users.User;
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
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    // GUI control variables:
    @FXML private Text actiontarget;
    @FXML private TextField username;
    @FXML private PasswordField password;

    private boolean isFirst=true;
    static private Integer id = 1;
    Map<Integer, User> all_users = new HashMap<>();
    Login loginSystem = new Login(id, all_users,isFirst);

    void setVariables( Map<Integer, User> allUsers, boolean is_first)
    {
        all_users = allUsers;
        loginSystem = new Login(id, all_users,is_first);
    }


    @FXML protected void handleLogin(ActionEvent event) throws IOException {

        String userName = username.getText();
        String passWD = password.getText();

        LoginReturn loginResult = loginSystem.login(userName, passWD, actiontarget );

        if( loginResult.isSuccessful)
        {
            actiontarget.setText("Welcome, "
                    + userName
                    + "!\n" + "UserType: " + loginResult.type+"\n");

            // If User has been authenticated, determine the type of user
            // (admin, professor, student, etc)

            // Based on the type of user, go to the appropriate page
            // switch (userType) { .... (something like this)


            // IF USER IS STUDENT
            if(loginResult.type.equals("Submitter")) {

                Submitter submitter = (Submitter) loginResult.returnedUser;
                System.out.println("LOGIN=>submitter: " + submitter.getUsername());
                System.out.println("LOGIN=>submitter.getHasTeam: " + submitter.getHasTeam());

                if(submitter.getHasTeam()) {
                    Parent studentRoot = FXMLLoader.load(getClass().getResource("StudentRoot.fxml"));
                    Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    appStage.setScene(new Scene(studentRoot));
                    appStage.show();
                }
                else{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateTeam.fxml"));
                    Parent teamRoot = (Parent)fxmlLoader.load();
                    Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    appStage.setScene(new Scene(teamRoot,800,600));
                    CreateTeamController controller = fxmlLoader.<CreateTeamController>getController();
                    controller.setVariables(submitter,all_users);
                    appStage.show();
                }
            }
            else if(loginResult.type.equals("Admin"))
            {

            }
        }
    }

    @FXML protected  void goToRegistrationPage(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent studentRoot = FXMLLoader.load (getClass().getResource("register.fxml"));
        Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        appStage.setScene(new Scene(studentRoot));
        appStage.show();
    }
}
