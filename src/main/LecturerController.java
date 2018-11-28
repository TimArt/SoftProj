package main;

import Others.Team;
import Users.RPM;
import Users.Reviewer;
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

public class LecturerController {

    @FXML private ListView<notification> notificationListView;
    private ObservableList<notification> notificationList = FXCollections.observableArrayList();
    @FXML private ListView<String> RPMListView;
    private ObservableList<String> RPMList = FXCollections.observableArrayList();
    @FXML private ListView<Reviewer> ReviewerListView;
    private ObservableList<Reviewer> ReviewerList = FXCollections.observableArrayList();
    @FXML private ListView<String> teamsListView;
    private ObservableList<String> teamList = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        notificationListView.setItems(notificationList);
        notificationListView.setCellFactory(listView -> new notificationListViewCell(2));

        RPMListView.setItems(RPMList);
        RPMListView.setCellFactory(listView -> new StringListViewCell());

        ReviewerListView.setItems(ReviewerList);
        ReviewerListView.setCellFactory(listView -> new reviewerListViewCell(0));

        teamsListView.setItems(teamList);
        teamsListView.setCellFactory(listView -> new StringListViewCell());

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
