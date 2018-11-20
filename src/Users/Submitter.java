package Users;


import Others.Artifact;
import Others.Team;

public class Submitter extends User {


    boolean hasTeam;
    // ASSOCIATION: Submitter-Team
    Team apartOf;

    // if it's the first artifact submitted,
    // then new instance of SubmissionGroup sg is created before
    // this function

    public Submitter()
    {
        hasTeam = false;
    }

    public Submitter(String username, int userID) {
        super(username,userID);
        hasTeam = false;
    }

    public boolean getHasTeam()
    {
        return hasTeam;
    }

    public void setHasTeam(boolean hasTeam) {
        this.hasTeam = hasTeam;
    }

    public void setApartOf(Team apartOf) {
        this.apartOf = apartOf;
    }

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
