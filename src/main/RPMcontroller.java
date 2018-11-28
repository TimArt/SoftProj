package main;

import Others.Artifact;
import Users.Reviewer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class RPMcontroller extends GrandPaController{

    @FXML
    private ListView<notification> notificationListView;
    private ObservableList<notification> notificationList = FXCollections.observableArrayList();
    @FXML
    private ListView<String> teamListView;
    private ObservableList<String> teamList = FXCollections.observableArrayList();
    @FXML
    private ListView<ListArtifact> reviewedArtifactListView;
    private ObservableList<ListArtifact> reviewedArtifactList = FXCollections.observableArrayList();;
    @FXML
    private ListView<ListArtifact> inProcessArtifactListView;
    private ObservableList<ListArtifact> inProcessArtifactList = FXCollections.observableArrayList();;
    @FXML
    private ListView<Reviewer> reviewersListView;
    private ObservableList<Reviewer> reviewersList = FXCollections.observableArrayList();

    @FXML public Label BigTitle;

    @FXML
    void initialize() {
        assert notificationListView != null : "fx:id=\"notificationList\" was not injected: check your FXML file 'CustomList.fxml'.";

        notificationListView.setItems(notificationList);
        notificationListView.setCellFactory(listView -> new notificationListViewCell(2, "RPMcontroller",this));

        teamListView.setItems(teamList);
        teamListView.setCellFactory(listView -> new StringListViewCell());

        reviewedArtifactListView.setItems(reviewedArtifactList);
        reviewedArtifactListView.setCellFactory(listView -> new ListArtifactListViewCell(1,"RPMcontroller",this));

        inProcessArtifactListView.setItems(inProcessArtifactList);
        inProcessArtifactListView.setCellFactory(listView -> new ListArtifactListViewCell(2,"RPMcontroller",this));

        reviewersListView.setItems(reviewersList);
        reviewersListView.setCellFactory(listView -> new reviewerListViewCell(1,"RPMcontroller",this));

    }

    void initializeNotifications()
    {
        notification n1 = new notification();
        n1.Title = "Title1";
        n1.Message = "FASFASFASFASFASFASFASDFASDFASDFASDFASFASDFASFASFASFASFSAFASDGSAGEGWRGERGEREGERGERGERGERGERGERGERGERGERGERGEGERGERG\n" +
                "FASFASFASFASFASFASFASDFASDFASDFASDFASFASDFASFASFASFASFSAFASDGSAGEGWRGERGEREGERGERGERGERGERGERGERGERGERGERGEGERGERG\n" +
                "FASFASFASFASFASFASFASDFASDFASDFASDFASFASDFASFASFASFASFSAFASDGSAGEGWRGERGEREGERGERGERGERGERGERGERGERGERGERGEGERGERG\n" +
                "FASFASFASFASFASFASFASDFASDFASDFASDFASFASDFASFASFASFASFSAFASDGSAGEGWRGERGEREGERGERGERGERGERGERGERGERGERGERGEGERGERG";
        notification n2 = new notification(); ;
        n2.Title = "Title2";
        n2.Message = "Short\n" +
                "Short\n" +
                "Short\n" +
                "Short\n" +
                "Short";
        notificationList.add(n1);
        notificationList.add(n2);

        Reviewer ab = new Reviewer("Abdik",1);
        ab.setUsername("ABDIK");
        reviewersList.add(ab);

        ListArtifact a1 = new ListArtifact();
        ListArtifact a2 = new ListArtifact();
        a1.name = "The Best Artifact!";
        a2.name = "Boo! The Worst Artifact!";

        inProcessArtifactList.add(a1);
        inProcessArtifactList.add(a2);
        reviewedArtifactList.add(a1);
        reviewedArtifactList.add(a2);

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