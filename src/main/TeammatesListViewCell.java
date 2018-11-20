package main;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class TeammatesListViewCell extends ListCell<String> {


    // Teammate username label:
    Label teammateLabel = new Label("(empty)");

    HBox hbox = new HBox();

    public TeammatesListViewCell()
    {
        super();

        hbox.getChildren().add(teammateLabel);
    }

    @Override
    public void updateItem(String item, boolean empty)
    {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setGraphic(null);
        } else {
            //setText(item.toString());
            teammateLabel.setText(item != null ? item : "<null>");
            setGraphic(hbox);
        }
        setText(null);
    }
}
