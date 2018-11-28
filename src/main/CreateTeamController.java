package main;

import Others.Team;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        teammatesListView.setCellFactory(listView -> new StringListViewCell());
    }

    @FXML protected void handleAddUser(ActionEvent event) throws IOException
    {
        String teammate_userName = teammate_username.getText();
        String filename = "Users.txt";
        File file  = new File(filename);
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean user_exists = false;
        boolean isSubmitter = false;
        Integer read_id = new Integer(0);

        while(inputFile.hasNext()) {
            String string_id = inputFile.next();
            read_id = Integer.valueOf(string_id);
            String us_name = inputFile.next();
            String pass_toked = inputFile.next();
            String us_type = inputFile.next();
            if (us_name.equals(teammate_userName)) {
                user_exists = true;
                if(us_type.equals("Submitter"))
                {
                    isSubmitter = true;
                }
                break;
            }
        }

        if(user_exists)
        {
            if(isSubmitter) {
                teammatesList.add(teammate_userName);
                teammates_IDs.add(read_id);
            }
            else{
                target.setText("Username \""+teammate_userName + "\" is not Submitter!\n");
            }
        }
        else
        {
            target.setText("There is no user with username: "+teammate_userName + "\n");
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
        controller.setVariables(allUsers,false);
        appStage.show();
    }
}
