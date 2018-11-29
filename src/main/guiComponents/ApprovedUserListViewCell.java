package main.guiComponents;

import Users.Admin;
import Users.User;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import main.AdminRootController;
import main.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApprovedUserListViewCell extends ListCell<User>
{

    private Button  changeButton = new Button("Change");
    private Button  deleteButton = new Button("Delete");

    Label userLabel = new Label("(empty)");

    // Layout Management
    HBox hbox = new HBox();
    Pane pane = new Pane();

    AdminRootController admin = new AdminRootController();


    public ApprovedUserListViewCell() {

        super();
        hbox.getChildren().addAll(userLabel, pane, changeButton, deleteButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        hbox.setPrefWidth(420.0);
        userLabel.setMaxWidth(200.0);
        userLabel.setMinWidth(200.0);
        pane.setMaxWidth(5.0);
        changeButton.setMaxWidth(75.0);
        deleteButton.setMaxWidth(75.0);
        hbox.setSpacing(5.0);

        deleteButton.setOnMouseClicked(event -> {
            String email = userLabel.getText().substring(userLabel.getText().lastIndexOf(">") + 1);
            //userLabel.setText(email);
            try {
                DatabaseUtil.removeUser(email);
            } catch (SQLException e) {
                e.printStackTrace();
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
            userLabel.setText(user.username != null ? user.username+"->"+user.email : "<null>");
            setGraphic(hbox);
        }
        setText(null);
    }



}
