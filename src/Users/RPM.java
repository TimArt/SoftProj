package Users;

import Others.SubmissionGroup;
import Others.Team;

import java.util.ArrayList;

public class RPM extends User {

    // ASSOCIATION: RPM - TEAM
    ArrayList<Team> assignedTo = new ArrayList<>();
    // ASSOCIATION: RPM - SubmissionGroup
    ArrayList<SubmissionGroup> manages = new ArrayList<>();

    public boolean reviewArtifact( int artifactId, int rating, String description)
    {
        return false;
    }

    public void assignReviewerToArtifact( int artifactId, int reviewerId)
    {
        return;
    }

}
