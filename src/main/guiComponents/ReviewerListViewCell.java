package main.guiComponents;

import Users.User;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import main.DatabaseUtil;

import java.sql.SQLException;

public class ReviewerListViewCell extends ListCell<User>{

    private Label userLabel = new Label("(empty)");
    private TextField userRating = new TextField("Enter rating..");

    // Layout Management
    HBox hbox = new HBox();
    Pane pane = new Pane();

    public ReviewerListViewCell() {

        super();
        hbox.getChildren().addAll(userLabel, pane, userRating);
        HBox.setHgrow(pane, Priority.ALWAYS);
        hbox.setPrefWidth(216.0);
        userLabel.setMaxWidth(110.0);
        userLabel.setMinWidth(110.0);
        pane.setMaxWidth(5.0);
        userRating.setMaxWidth(100.0);
        hbox.setSpacing(5.0);
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
