package main;

import Others.Artifact;
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

import java.io.IOException;

public class ReviewerController extends GrandPaController{

    @FXML private ListView<notification> notificationListView;
    private ObservableList<notification> notificationList = FXCollections.observableArrayList();
    @FXML private ListView<ListArtifact> assignedArtifactsListView;
    private ObservableList<ListArtifact>  assignedArtifactsList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        notificationListView.setItems(notificationList);
        notificationListView.setCellFactory(listView -> new notificationListViewCell(2,"ReviewerController",this));

        assignedArtifactsListView.setItems(assignedArtifactsList);
        assignedArtifactsListView.setCellFactory(listView -> new ListArtifactListViewCell(2,"ReviewerController",this));
    }

    @FXML
    protected void handleLogOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(new Scene(root, 800, 600));
        LoginController controller = fxmlLoader.<LoginController>getController();
        //controller.setVariables(allUsers,false);
        appStage.show();
    }
}
