package main.guiComponents;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import main.ListArtifact;

public class ArtifactListViewCell extends ListCell<ListArtifact>
{
    // Artifact Phase
    private final ToggleGroup artifactPhaseToggleGroup = new ToggleGroup();
    private ToggleButton requirementsBtn = new ToggleButton("Requirements");
    private ToggleButton designBtn = new ToggleButton("Design");
    private ToggleButton implementationBtn = new ToggleButton("Implementation");

    // Artifact Type
    private final ToggleGroup artifactTypeToggleGroup = new ToggleGroup();
    private ToggleButton writtenDocBtn  = new ToggleButton("Written Doc");
    private ToggleButton umlDocBtn = new ToggleButton("UML Model");

    private ToggleButton partialCodeBtn = new ToggleButton("Partial Code");
    private ToggleButton finishedCodeBtn = new ToggleButton("Finished Code");
    private ToggleButton applicationBtn = new ToggleButton("Application");

    // File Label
    Label fileLabel = new Label("(empty)");


    // Layout Management
    HBox hbox = new HBox();
    Pane pane1 = new Pane();
    Pane pane2 = new Pane();


    public ArtifactListViewCell () {
        super();

        // Visual Layout
        hbox.getChildren().addAll(fileLabel, pane1, requirementsBtn, designBtn, implementationBtn, pane2);
        HBox.setHgrow(pane1, Priority.ALWAYS);
        HBox.setHgrow(pane2, Priority.ALWAYS);
        fileLabel.setMaxWidth(200.0);
        fileLabel.setMinWidth(200.0);

        // Phase Toggle Group
        requirementsBtn.setToggleGroup(artifactPhaseToggleGroup);
        designBtn.setToggleGroup(artifactPhaseToggleGroup);
        implementationBtn.setToggleGroup(artifactPhaseToggleGroup);

        // Type Toggle Group
        writtenDocBtn.setToggleGroup(artifactTypeToggleGroup);
        umlDocBtn.setToggleGroup(artifactTypeToggleGroup);
        partialCodeBtn.setToggleGroup(artifactTypeToggleGroup);
        finishedCodeBtn.setToggleGroup(artifactTypeToggleGroup);
        applicationBtn.setToggleGroup(artifactTypeToggleGroup);



        // Phase Toggle callback
        artifactPhaseToggleGroup.selectedToggleProperty().addListener((ov, lastToggle, nextToggle) -> {

            if (lastToggle == requirementsBtn || lastToggle == designBtn) {
                hbox.getChildren().removeAll(writtenDocBtn, umlDocBtn);
            } else if (lastToggle == implementationBtn) {
                hbox.getChildren().removeAll(partialCodeBtn, finishedCodeBtn, applicationBtn);
            }

            if (nextToggle == requirementsBtn || nextToggle == designBtn) {
                hbox.getChildren().addAll(writtenDocBtn, umlDocBtn);
            }
            else if (nextToggle == implementationBtn) {
                hbox.getChildren().addAll(partialCodeBtn, finishedCodeBtn, applicationBtn);
            }
            else {
               // Don't worry about adding anything if nothing selected
            }

            // Set the artifact phase
            if (nextToggle != null) {
                getItem().artifactPhase = ((ToggleButton) nextToggle).getText();
                commitEdit(getItem());
            } else {
                getItem().artifactPhase = null;
                commitEdit(getItem());
            }
        });

        // Type Toggle callback
        artifactTypeToggleGroup.selectedToggleProperty().addListener((ov, lastToggle, nextToggle) -> {

            // Set the artifact type
            if (nextToggle != null) {
                getItem().artifactType = ((ToggleButton) nextToggle).getText();
                commitEdit(getItem());
            }
            else
            {
                getItem().artifactType = null;
                commitEdit(getItem());
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
            fileLabel.setText(item.file.getName() != null ? item.file.getName() : "<null>");
            setGraphic(hbox);
        }
        setText(null);
    }
}
