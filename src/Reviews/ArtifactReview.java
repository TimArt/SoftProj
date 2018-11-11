package Reviews;

import Others.Artifact;
import Users.Reviewer;

public class ArtifactReview {

    boolean isApprovedbyRPM;
    //boolean byWhom? Reviewer|RPM|Lecturer

    // ASSOCIATION: ARTIFACT REVIEW - ARTIFACT
    Artifact reviewFor;
    // ASSOCIATON: ARTIFACT REVIEW - REVIEWER
    Reviewer reviewBy;  //RPM reviewedBy??????

}
