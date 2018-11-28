package main;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

public class ListArtifactListViewCell extends ListCell<ListArtifact> {

    final double width = 300.0;
    Label name = new Label("(empty)");
    private Button reviewButton = new Button("Review");
    private Button seeButton = new Button("See");
    VBox vbox = new VBox();


    ListArtifactListViewCell(int numButtons)
    {
        super();

    }

    @Override
    public void updateItem(ListArtifact item, boolean empty)
    {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            //setText(item.toString());

            setGraphic(vbox);
        }
        setText(null);
    }


}
