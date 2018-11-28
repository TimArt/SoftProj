package main;

import Users.Reviewer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class reviewerListViewCell extends ListCell<Reviewer>{


    final double width = 300.0;
    Label name = new Label("(empty)");
    private Button assignButton = new Button("Assign");

    HBox box = new HBox();

    reviewerListViewCell(int numButtons,String ControllerType, GrandPaController GodFather)
    {
        super();
        box.setPrefWidth(width);
        box.setStyle("-fx-padding: 2;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 2;" +
                "-fx-border-radius: 2;" +
                "-fx-border-color: black;");
        name.setMaxWidth(width);
        name.setMinWidth(width);
        if(numButtons == 0)
        {
            box.getChildren().addAll(name);
        }
        else if(numButtons == 1)
        {
            box.getChildren().addAll(name, assignButton);
        }

        assignButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // ACTION
                if(ControllerType.equals("ReviewerController"))
                {
                    ReviewerController reviewerController = (ReviewerController) GodFather;

                }
                else if(ControllerType.equals("RPMcontroller"))
                {
                    RPMcontroller rpmController = (RPMcontroller) GodFather;
                }
                else if(ControllerType.equals("LecturerController"))
                {
                    LecturerController lecturerController = (LecturerController) GodFather;
                }
            }
        });
    }

    @Override
    public void updateItem(Reviewer item, boolean empty)
    {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            //setText(item.toString());
            name.setText(item.getUsername());
            setGraphic(box);
        }
        setText(null);
    }

}
