package Others;

import Users.RPM;
import Users.Submitter;

import java.util.ArrayList;

public class Team {

    private static int teamID = 0;
    private boolean isApproved;
    private int id;

    public Team()
    {
        id = teamID;
        teamID += 1;
        isApproved = false;
    }

    // ASSOCIATION: Team - Submitter
    private ArrayList<Submitter> consistsOf = new ArrayList<Submitter>();
    // ASSOCIATION: Team - RPM
    private RPM isAssignedTo;
    // ASSOCIATION: Team - Submission Group
    private ArrayList<SubmissionGroup> submitted = new ArrayList<>();

    public void add(Submitter sbmtr)
    {
        consistsOf.add(sbmtr);
    }


}
