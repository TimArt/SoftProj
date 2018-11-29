package main.guiComponents;


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


public class UnapprovedUserListViewCell extends ListCell<User>
{

    private Button  approveButton = new Button("Approve");
    Label userLabel = new Label("(empty)");

    // Layout Management
    HBox hbox = new HBox();
    Pane pane = new Pane();


    public UnapprovedUserListViewCell( ) {

        super();
        hbox.getChildren().addAll(userLabel, pane, approveButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        hbox.setPrefWidth(422.0);
        hbox.setSpacing(-20.0);
        userLabel.setMaxWidth(200.0);
        userLabel.setMinWidth(200.0);
        pane.setMaxWidth(15.0);
        approveButton.setMaxWidth(100.0);
        hbox.setSpacing(5.0);

        approveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String email = userLabel.getText().substring(userLabel.getText().lastIndexOf(">") + 1);
                DatabaseUtil.approveUser(email);
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
