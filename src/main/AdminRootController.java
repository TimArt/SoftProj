package main;

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

import java.io.IOException;
import java.sql.SQLException;

public class AdminRootController {

    @FXML private TreeView<String> submissionTreeView;

    @FXML private ListView<String> unapprovedUserListView;
    private ObservableList<String> unapprovedUserList = FXCollections.observableArrayList();

    @FXML private ListView<String> approvedUserListView;
    private ObservableList<String> approvedUserList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws SQLException {

        // Setup User View
        unapprovedUserList.addAll (DatabaseUtil.getUnapprovedUsers());
        approvedUserList.addAll (DatabaseUtil.getApprovedUsers());
        unapprovedUserListView.setItems(unapprovedUserList);
        approvedUserListView.setItems(approvedUserList);


        // Setup Submission View
        submissionTreeView.setRoot(DatabaseUtil.getTreeViewRootOfArtifacts(false));
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
