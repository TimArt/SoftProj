package main;

import Others.SubmissionGroup;
import Users.CurrentStaticUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import main.guiComponents.ArtifactListViewCell;
import org.omg.CORBA.Current;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentRootController {

    @FXML
    private TreeView<String> submissionTreeView;
    private ArrayList<ArrayList<TreeItem>> submissionArtifacts;

    @FXML
    void initialize() throws SQLException {
        submissionTreeView.setRoot(DatabaseUtil.getTreeViewRootOfArtifacts(true));
    }

    @FXML
    protected void handleMakeSubmission(ActionEvent event) throws IOException {
        Parent studentRoot = FXMLLoader.load (getClass().getResource("StudentSubmit.fxml"));
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(new Scene(studentRoot));
        appStage.show();
    }

    @FXML
    protected void handleAddTeammates(ActionEvent event) throws IOException {
        Parent studentRoot = FXMLLoader.load (getClass().getResource("CreateTeam.fxml"));
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(new Scene(studentRoot));
        appStage.show();
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
