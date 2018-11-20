package Users;

import Others.Artifact;
import Reviews.ArtifactReview;

import java.util.ArrayList;

public class Reviewer extends User {

    // ASSOCIATION: Reviewer - Artifact: ?? List of single ??
    // Can Reviewer be assigned to several artifacts at the same time??
    ArrayList<Artifact> reviews = new ArrayList<>();

    // ASSOCIATION: Reviewer - ArtifactReview: ??? NO NEED ???


    public ArtifactReview reviewArtifact(int artifactID, int rating, String description)
    {
        ArtifactReview dummy = new ArtifactReview();



        return dummy;
    }

    public Reviewer(String username, int userID) {
        super(username,userID);
    }

}