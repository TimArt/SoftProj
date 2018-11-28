package main;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class notificationListViewCell extends ListCell<notification>{


    final double message_height = 80.0;
    final double vbox_child_width = 120.0;

    Label title = new Label("(empty)");
    ListView<Label> messageListView = new ListView<>();
    ObservableList<Label> messageList = FXCollections.observableArrayList();
    Label message = new Label();

    private Button rejectButton = new Button("Reject");
    private Button actionButton = new Button("Action");

    SplitPane buttons = new SplitPane();


    VBox vbox = new VBox();

    notificationListViewCell(int numButtons)
    {
        super();

        vbox.setPrefWidth(vbox_child_width);
        title.setMaxWidth(vbox_child_width);
        title.setMinWidth(vbox_child_width);
        buttons.setPrefWidth(vbox_child_width);
        messageListView.setPrefWidth(vbox_child_width);
        messageListView.setPrefHeight(message_height);
        messageListView.setMaxHeight(message_height);
        message.setMaxHeight(message_height);
        message.setMinHeight(message_height);
        message.setMaxWidth(vbox_child_width);
        message.setMinWidth(vbox_child_width);

        messageList.add(message);

        vbox.setStyle("-fx-padding: 2;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 2;" +
                "-fx-border-radius: 2;" +
                "-fx-border-color: black;");

        if(numButtons == 1)
        {
            buttons.getItems().addAll(actionButton);
        }
        else if(numButtons == 2)
        {
            buttons.getItems().addAll(rejectButton,actionButton);
        }
        vbox.setPadding(new Insets(0));
        vbox.getChildren().addAll(title, messageListView,buttons);
        vbox.setMargin(title, new Insets(0));
        vbox.setMargin(messageListView, new Insets(0));
        vbox.setMargin(buttons, new Insets(0));

        actionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // ACTION
            }
        });

        rejectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // ACTION
            }
        });

    }

    @Override
    public void updateItem(notification item, boolean empty)
    {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            //setText(item.toString());
            title.setText(item.Title != null ? item.Title : "<null>");
            messageList.clear();
            message.setText(item.Message != null ? item.Message : "<null>");
            messageList.add(message);
            setGraphic(vbox);
        }
        setText(null);
    }

}
