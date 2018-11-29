package main;

import Others.Team;
import Users.RPM;
import Users.Reviewer;
import Users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import main.guiComponents.ReviewerListViewCell;

import java.io.IOException;
import java.sql.SQLException;

public class LecturerController extends GrandPaController {

    @FXML private TreeView<String> submissionTreeView;

    @FXML private ListView<notification> notificationListView;
    private ObservableList<notification> notificationList = FXCollections.observableArrayList();

    @FXML private ListView<String> RPMListView;
    private ObservableList<String> RPMList = FXCollections.observableArrayList();

    @FXML private ListView<User> reviewerListView;
    private ObservableList<User> reviewerList = FXCollections.observableArrayList();

    @FXML private ListView<String> teamsListView;
    private ObservableList<String> teamList = FXCollections.observableArrayList();

    @FXML private ListView<ListArtifact> pendingArtifactsListView;
    private ObservableList<ListArtifact> pendingArtifactsList = FXCollections.observableArrayList();


    @FXML
    void initialize() throws SQLException {

        reviewerList.addAll (DatabaseUtil.getReviewers());
        reviewerListView.setItems(reviewerList);
        reviewerListView.setCellFactory(listView -> new ReviewerListViewCell());

        /*notificationListView.setItems(notificationList);
        notificationListView.setCellFactory(listView -> new notificationListViewCell(2,this));

        RPMListView.setItems(RPMList);
        RPMListView.setCellFactory(listView -> new StringListViewCell());

        ReviewerListView.setItems(ReviewerList);
        ReviewerListView.setCellFactory(listView -> new reviewerListViewCell(0,this));

        teamsListView.setItems(teamList);
        teamsListView.setCellFactory(listView -> new StringListViewCell());

        pendingArtifactsListView.setItems(pendingArtifactsList);
        pendingArtifactsListView.setCellFactory(listView -> new ListArtifactListViewCell(2,this));*/

        submissionTreeView.setRoot(DatabaseUtil.getTreeViewRootOfArtifacts(false));

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
