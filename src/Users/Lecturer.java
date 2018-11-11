package Users;

import Reviews.FinalReview;

import java.util.ArrayList;

public class Lecturer extends User {

    /* Lecturer doesn't need to have managesRPM, reviewsRPM, reviewsReviewer
       variables, because when needed, Controller class will obtain list of
       those objects from database and pass it to Lecturer.
    private ArrayList<RPM> managesRPM = new ArrayList<RPM>();
    private ArrayList<RPM> reviewsRPM = new ArrayList<RPM>();
    private ArrayList<Reviewer> reviewsReviewer = new ArrayList<Reviewer>();
     */

    // ASSOCIATION: Lecturer - SubmissionGroup
    ArrayList<FinalReview> creates = new ArrayList<>();


    public void approveTeamRegistration(int teamId)
    {
        return;
    }

    public void assignRPMToTeam(int teamId, int rpmId)
    {
        return;
    }

    public void reviewRPM(int rating,String description, int submissionGroupId, int rpmId)
    {
        return;
    }

    public void reviewReviewer(int rating,String description, int artifactId, int reviewerId)
    {
        return;
    }

    public void reviewArtifact(int rating, String description, int submissionGroupId)
    {
        return;
    }

}
