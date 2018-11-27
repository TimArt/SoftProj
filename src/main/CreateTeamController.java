package main;

import Others.Team;
import Users.CurrentStaticUser;
import Users.Submitter;
import Users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class CreateTeamController {

    @FXML private ListView<String> teammatesListView;
    private ObservableList<String>  teammatesList = FXCollections.observableArrayList();

    @FXML private TextField teammate_username;
    @FXML private Text target;

    List<Integer> teammates_IDs = new ArrayList<>();
    Submitter team_creator = new Submitter();
    private Map<Integer, User> allUsers = new HashMap<>();

    void setVariables(Submitter usr,Map<Integer, User> users )
    {
        team_creator = usr;
        allUsers = users;
    }

    @FXML
    void initialize() {
        assert teammatesListView != null : "fx:id=\" teammatesList\" was not injected: check your FXML file 'CreateTeam.fxml'.";

        teammatesListView.setItems(teammatesList);
        teammatesListView.setCellFactory(listView -> new TeammatesListViewCell());
    }

    @FXML protected void handleAddUser(ActionEvent event) throws IOException, SQLException {
        String teammate_userName = teammate_username.getText();

        Connection database = Database.createConnection();

        // Get information about the teammate
        String query = "SELECT * FROM User WHERE name = ?";
        PreparedStatement preparedStatement = database.prepareStatement(query);
        preparedStatement.setString(1, teammate_userName);

        ResultSet resultSet = preparedStatement.executeQuery();

        // If the potential Teammate exists
        if(resultSet.next())
        {
            // If they are a student
            if("Student".equals(resultSet.getString("role"))) {

                // Check if we need to create a Team for the current user and their potential teammate
                if (CurrentStaticUser.teamId == 0)
                {
                    query = "INSERT INTO TEAM VALUES ()";
                    Statement statement = database.createStatement();
                    CurrentStaticUser.teamId = statement.executeUpdate (query, Statement.RETURN_GENERATED_KEYS);

                    // Update user to be in the team
                    statement.execute("UPDATE User SET teamID = " + CurrentStaticUser.teamId + " WHERE userID = " + CurrentStaticUser.userId);
                }

                // Update Database so teammate is apart of the team
                Statement statement = database.createStatement();
                statement.execute("UPDATE User SET teamID = "
                        + CurrentStaticUser.teamId + " WHERE userID = "
                        + resultSet.getInt("userID"));

            }
            else{
                target.setText("Username \"" + teammate_userName + "\" is not Submitter!\n");
            }
        }
        else // If Teammate does not exist
        {
            target.setText("There is no user with username: "+teammate_userName + "\n");
        }

        refreshTeamateGUILists(database);

        database.close();

    }

    /**
     * Refreshes the lists shown in the GUI to match what the database says is in the
     * current Team.
     * @param database
     * @throws SQLException
     */
    private void refreshTeamateGUILists(Connection database) throws SQLException {

        String query = "SELECT * FROM User WHERE teamID = ?";
        PreparedStatement preparedStatement = database.prepareStatement(query);
        preparedStatement.setInt(1, CurrentStaticUser.teamId);

        ResultSet resultSet = preparedStatement.executeQuery();

        teammatesList.clear();
        teammates_IDs.clear();

        while (resultSet.next()) {
            teammatesList.add(resultSet.getString("name"));
            teammates_IDs.add(resultSet.getInt("userID"));
        }

    }

    @FXML protected void handleCreateTeam(ActionEvent event) throws IOException {

        Team newTeam = new Team();
        newTeam.add(team_creator);
        team_creator.setHasTeam(true);

        System.out.println("teamCreator: " + team_creator.getUsername());
        System.out.println("teamCreator.getHasTeam(): " + team_creator.getHasTeam());

        for(int i=0; i<teammates_IDs.size(); i++)
        {
            Integer teammate_ID = teammates_IDs.get(i);
            System.out.println("teammate_ID: " + teammate_ID);
            Submitter teamMate = (Submitter) allUsers.get(teammate_ID);
            newTeam.add(teamMate);
            System.out.println("teamMate: " + teamMate.getUsername());
        }

        team_creator.setApartOf(newTeam);
        for(int i=0; i<teammates_IDs.size(); i++) {
            Integer teammate_ID = teammates_IDs.get(i);
            Submitter teamMate = (Submitter) allUsers.get(teammate_ID);
            teamMate.setApartOf(newTeam);
            teamMate.setHasTeam(true);
            System.out.println(" teamMate.getHasTeam(): " +  teamMate.getHasTeam());
        }

        target.setText("Team was created!");
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
