package main;

import Login.Login;
import Users.Admin;
import Users.User;
import com.intellij.ide.ui.EditorOptionsTopHitProvider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {


    /*
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        primaryStage.setTitle("SoftProj Register");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    */
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("SoftProj Login");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
