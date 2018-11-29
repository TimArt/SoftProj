package main.guiComponents;

import Users.CurrentStaticUser;
import Users.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import main.DatabaseUtil;

import javax.xml.crypto.Data;

public class UnapprovedUserListViewCell extends ListCell<User>
{

    private Button  approveButton = new Button("Approve");
    Label userLabel = new Label("(empty)");

    // Layout Management
    HBox hbox = new HBox();
    Pane pane = new Pane();


    public UnapprovedUserListViewCell() {

        super();
        hbox.getChildren().addAll(userLabel, pane, approveButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        hbox.setPrefWidth(425.0);
        userLabel.setMaxWidth(70.0);
        userLabel.setMinWidth(70.0);
        pane.setMaxWidth(200.0);
        pane.setMinWidth(200.0);

        approveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtil.approveUser(userLabel.getText());
            }
        });

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
