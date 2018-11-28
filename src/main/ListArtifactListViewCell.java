package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;

public class ListArtifactListViewCell extends ListCell<ListArtifact> {

    final double width = 200.0;
    Label name = new Label("(empty)");
    SplitPane buttons = new SplitPane();
    private Button reviewButton = new Button("Review");
    private Button seeButton = new Button("See");
    VBox vbox = new VBox();


    ListArtifactListViewCell(int numButtons)
    {
        super();

        vbox.setPrefWidth(width);
        vbox.setStyle("-fx-padding: 2;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 2;" +
                "-fx-border-radius: 2;" +
                "-fx-border-color: black;");
        name.setMaxWidth(width);
        name.setMinWidth(width);
        if(numButtons == 1)
        {
            buttons.getItems().addAll(seeButton);
        }
        else if(numButtons == 2) {
            buttons.getItems().addAll(seeButton, reviewButton);
        }

        vbox.getChildren().addAll(name,buttons);

        reviewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // ACTION
            }
        });

        seeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // ACTION
            }
        });

    }

    @Override
    public void updateItem(ListArtifact item, boolean empty)
    {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            //setText(item.toString());
            name.setText(item.name);
            setGraphic(vbox);
        }
        setText(null);
    }


}
