package Users;


import Others.Artifact;
import Others.Team;

public class Submitter extends User {

    // ASSOCIATION: Submitter-Team
    Team apartOf;



    // if it's the first artifact submitted,
    // then new instance of SubmissionGroup sg is created before
    // this function

    // after this function sg.addArtifact() is called with
    // returned value as argument
    public Artifact submitArtifact(String name, String content)
    {
        Artifact dummy = new Artifact();


        return dummy;
    }

    public void submitArtifacts(String[] contents)
    {

        return;
    }

    // submitter can create team using either usernames or userID

    public boolean createTeam(String[] usernames)
    {
        return false;
    }
    public boolean createTeam(int[] userIDs)
    {
        return false;
    }

}
