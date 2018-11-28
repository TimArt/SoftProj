package main.guiComponents;

import Users.User;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class ApprovedUserListViewCell extends ListCell<User>
{

    private Button  changeButton = new Button("Change");
    private Button  deleteButton = new Button("Del");

    Label userLabel = new Label("(empty)");

    // Layout Management
    HBox hbox = new HBox();
    Pane pane = new Pane();


    public ApprovedUserListViewCell() {

        super();
        hbox.getChildren().addAll(userLabel, pane, changeButton, deleteButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        userLabel.setMaxWidth(70.0);
        userLabel.setMinWidth(70.0);


        /*approveButon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(" : " + event);
            }
        });*/

    }

    @Override
    public void updateItem(User user, boolean empty)
    {
        super.updateItem(user, empty);
        if (empty || user == null) {
            setGraphic(null);
        } else {
            //setText(item.toString());
            userLabel.setText(user.username != null ? user.username : "<null>");
            setGraphic(hbox);
        }
        setText(null);
    }



}
