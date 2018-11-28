package main;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class StringListViewCell extends ListCell<String> {


    // Teammate username label:
    Label lbl = new Label("(empty)");

    HBox hbox = new HBox();

    public StringListViewCell()
    {
        super();

        hbox.getChildren().add(lbl);
    }

    @Override
    public void updateItem(String item, boolean empty)
    {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setGraphic(null);
        } else {
            //setText(item.toString());
            lbl.setText(item != null ? item : "<null>");
            setGraphic(hbox);
        }
        setText(null);
    }
}
