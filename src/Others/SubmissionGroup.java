package Others;

import Reviews.FinalReview;
import Users.RPM;

import java.util.ArrayList;
import java.util.Date;

public class SubmissionGroup {

    // NEED TO CHECK DATE class
    private final Date timeSubmitted = new Date();
    private boolean isApproved;
    private boolean isMultiple;

    // ASSOCIATION: Submission Group - Team
    private Team createdBy;
    // ASSOCIATION: Submission Group - Artifact
    private ArrayList<Artifact> contains = new ArrayList<>();
    // ASSOCIATION: Submission Group - RPMM
    private RPM isManagedBy;
    // ASSOCIATION: SubmissionGroup - FinalReview
    private FinalReview hasFinalReview;


    public void addArtifact(Artifact a)
    {
        contains.add(a);
        if( contains.size()>1)
        {
            isMultiple = true;
        }

        return;
    }

    public void submit()
    {

    }

}
