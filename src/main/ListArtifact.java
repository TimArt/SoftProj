package main;

import java.io.File;

public class ListArtifact {
    public int id;
    public File file;
    public String name;
    public String artifactPhase = null;
    public String artifactType = null;

    ListArtifact (){}
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
