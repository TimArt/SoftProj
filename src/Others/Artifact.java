package Others;

import Users.Reviewer;

import java.util.ArrayList;
import java.util.Date;

public class Artifact {

    private String name;
    private int id;
    private String content;
    private Date submittedTime;

    // ASSOCIATION: Artifact - Artifact
    private Others.Artifact prev;
    // ASSOCIATION: Artifact - Artifact
    private Others.Artifact next;
    // ASSOCIATION: Artifact - Submission Group
    private SubmissionGroup isPartOf;
    // ASSOCIATION: Artifact - Reviewer
    private ArrayList<Reviewer> reviewedBy = new ArrayList<>();

    // name of the Artifact stays the same
    // so no need for "String name" argument
    public Others.Artifact updateArtifact(String newContent)
    {
        Others.Artifact dummy = new Others.Artifact();

        return  dummy;
    }

}
