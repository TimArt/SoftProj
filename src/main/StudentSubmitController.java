package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentSubmitController {

    @FXML private ListView<File> filesList;

    @FXML
    protected void handleDragOver(DragEvent event) throws IOException {
        if (event.getDragboard().hasFiles())
        {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    protected void handleDragDrop(DragEvent event) throws IOException {
        List<File> files = event.getDragboard().getFiles();

        // Add this list to the ListView of Files
        //filesList.add (files);

        //filesView.
    }

}
