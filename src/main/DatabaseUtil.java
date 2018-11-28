package main;

import Users.CurrentStaticUser;
import javafx.scene.control.TreeItem;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseUtil {

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/softproj?useSSL=false",
                "root",
                "PUT YO PASSWORD HERE");
    }

    public static int insertAndGetGeneratedPrimaryKey (Connection database, String query) throws SQLException {

        Statement statement = database.createStatement();
        statement.executeUpdate (query, Statement.RETURN_GENERATED_KEYS);
        ResultSet result = statement.getGeneratedKeys();
        result.next();
        return result.getInt(1);
    }

    public static TreeItem getTreeViewRootOfArtifacts (boolean isForCurrentTeam) throws SQLException {
        // Get Submissions
        Connection database = DatabaseUtil.createConnection();

        String submissionQuery;
        if (isForCurrentTeam)
            submissionQuery = "SELECT * FROM Submission WHERE teamId = " + CurrentStaticUser.teamId;
        else
            submissionQuery = "SELECT * FROM Submission";

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

        return treeViewRoot;
    }

    public static ArrayList<String> getApprovedUsers() throws SQLException {
        Connection database = DatabaseUtil.createConnection();
        String query = "SELECT * FROM User WHERE isApproved = TRUE";
        Statement statement = database.createStatement();
        statement.execute(query);
        ResultSet results = statement.getResultSet();
        ArrayList<String> users = new ArrayList<>();
        while (results.next())
        {
            users.add(results.getString("name"));
        }
        return users;
    }

    public static ArrayList<String> getUnapprovedUsers() throws SQLException {
        Connection database = DatabaseUtil.createConnection();
        String query = "SELECT * FROM User WHERE isApproved = FALSE";
        Statement statement = database.createStatement();
        statement.execute(query);
        ResultSet results = statement.getResultSet();
        ArrayList<String> users = new ArrayList<>();
        while (results.next())
        {
            users.add(results.getString("name"));
        }
        return users;
    }
}
