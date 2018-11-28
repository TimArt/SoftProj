package main.guiComponents;

import Users.CurrentStaticUser;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import main.ListArtifact;

public class UserListViewCell extends ListCell<CurrentStaticUser> {
    //private Button  modifyButon = new Button("Modify");
    private Button  approveButon = new Button("Approve");
    //private Button  deleteButton = new Button("Delete");


    // File Label
    Label userLabel = new Label("(empty)");


    // Layout Management
    HBox hbox = new HBox();
    Pane pane1 = new Pane();
    Pane pane2 = new Pane();

    public UserListViewCell () {
        super();

        // Visual Layout
        hbox.getChildren().addAll(userLabel, pane1, approveButon, pane2);
        HBox.setHgrow(pane1, Priority.ALWAYS);
        HBox.setHgrow(pane2, Priority.ALWAYS);
        userLabel.setMaxWidth(100.0);
        userLabel.setMinWidth(100.0);


    }



}
