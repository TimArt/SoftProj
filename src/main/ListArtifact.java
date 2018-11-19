package main;

import java.io.File;

public class ListArtifact {
    public File file;
    public String artifactPhase = null;
    public String artifactType = null;

    ListArtifact (File file)
    {
        this.file = file;
    }

    /**
     * Specifies if phase and type have been selected or not. This can be used
     * to easily check before submitting if the options have been selected.
     * @return
     */
    public boolean hasPhaseAndTypeSpecified()
    {
        return (artifactPhase != null) &&
                (artifactType != null);
    }
}
