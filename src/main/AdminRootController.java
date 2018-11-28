package main;

import Users.CurrentStaticUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import main.guiComponents.ArtifactListViewCell;
import main.guiComponents.UserListViewCell;

import java.io.IOException;

public class AdminRootController {

    @FXML private ListView<CurrentStaticUser> userListView;
    private ObservableList<CurrentStaticUser> userList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        assert userListView != null : "fx:id=\"artifactList\" was not injected: check your FXML file 'CustomList.fxml'.";

        userListView.setItems(userList);
        userListView.setCellFactory(listView -> new UserListViewCell());
    }

    @FXML protected void handleLogOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(new Scene(root, 800, 600));
        LoginController controller = fxmlLoader.<LoginController>getController();
        //controller.setVariables(allUsers,false);
        appStage.show();
    }

}
