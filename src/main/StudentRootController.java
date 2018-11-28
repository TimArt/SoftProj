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

        // Get Submissions
        Connection database = DatabaseUtil.createConnection();
        String submissionQuery = "SELECT * FROM Submission WHERE teamId = " + CurrentStaticUser.teamId;
        Statement submissionStatement = database.createStatement();
        submissionStatement.execute(submissionQuery);
        ResultSet submissions = submissionStatement.getResultSet();
        ArrayList<TreeItem> submissionItems = new ArrayList<>();

        while (submissions.next())
        {
            // Setup Submission Root Item
            StringBuilder sb = new StringBuilder();
            sb.append(submissions.getInt("submissionID"));
            TreeItem submissionRoot = new TreeItem("Submission ID: " + sb.toString());

            // Get Artifacts
            String artifactQuery = "SELECT * FROM Artifact WHERE submissionId = " + submissions.getInt("submissionID");
            Statement artifactStatement = database.createStatement();
            artifactStatement.execute(artifactQuery);
            ResultSet artifacts = artifactStatement.getResultSet();

            // Collect artifacts
            ArrayList<TreeItem> artifactItems = new ArrayList<>();
            while (artifacts.next())
            {
                artifactItems.add(new TreeItem (artifacts.getString("name")));
            }

            submissionRoot.getChildren().addAll(artifactItems);

            submissionItems.add(submissionRoot);
        }

        TreeItem treeViewRoot = new TreeItem();
        treeViewRoot.getChildren().addAll(submissionItems);
        treeViewRoot.setExpanded(true);
        submissionTreeView.setRoot(treeViewRoot);
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
}
