package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentSubmitController {

    @FXML private ImageView dragAndDropFileArea;
    @FXML private ListView<ListArtifact> artifactListView;
    private ObservableList<ListArtifact> artifactList = FXCollections.observableArrayList();

    //private List<File> filesList = new ArrayList<>();

    @FXML
    void initialize() {
        assert artifactListView != null : "fx:id=\"artifactList\" was not injected: check your FXML file 'CustomList.fxml'.";

        artifactListView.setItems(artifactList);
        artifactListView.setCellFactory(listView -> new ArtifactListViewCell());
    }

    @FXML
    protected void handleDragOver(DragEvent event) throws IOException {
        if (event.getGestureSource() != dragAndDropFileArea
                && event.getDragboard().hasFiles())
        {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    protected void handleDragDrop(DragEvent event) throws IOException {

        Dragboard dragboard = event.getDragboard();

        boolean successfulDragDrop;
        if (successfulDragDrop = dragboard.hasFiles()) {
            artifactList.add (new ListArtifact(dragboard.getFiles().get(0)));
        }

        // Let drag source know if successful completion or not
        event.setDropCompleted(successfulDragDrop);
        event.consume();
    }


    /**
     * Handles when the submit button is pressed.
     * IMPLEMENT DATABASE CONNECTION HERE
     * @param event
     */
    @FXML protected void handleSubmit(ActionEvent event) {

        boolean artifactsReady = true;
        for (ListArtifact artifact : artifactList) {
            if (!artifact.hasPhaseAndTypeSpecified()) {
                artifactsReady = false;
                break;
            }
        }

        // If all Artifacts have been labeled with phase and type
        if (artifactsReady) {
            // Submit these artifacts by adding their file paths, phase, and type to the database
            for (ListArtifact artifact : artifactList) {
                System.out.println(artifact.file.getName() + " - "
                        + artifact.artifactPhase + " - " + artifact.artifactType);
            }
        } else {
            // Notify user to specify phase and type
            System.out.println("Please Specify Artifact Phase and Type");

        }
    }
}
