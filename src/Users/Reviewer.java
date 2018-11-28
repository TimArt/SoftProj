package Users;

import Others.Artifact;
import Reviews.ArtifactReview;
import main.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;

public class Reviewer extends User {

    // Can Reviewer be assigned to several artifacts at the same time?? -- yes, they can
    ArrayList<Artifact> reviews = new ArrayList<>();


    public ArtifactReview reviewArtifact(int artifactID, int rating, String description)
    {
        ArtifactReview dummy = new ArtifactReview();
        return dummy;
    }


    public ArrayList<CurrentStaticUser> showListOfReviewers() throws SQLException {
        Connection conn = DatabaseUtil.createConnection();
        ArrayList<CurrentStaticUser> reviewers = new ArrayList<>();

        String query = "SELECT * FROM USER WHERE role = Reviewer" ;
        Statement statement = conn.createStatement();
        ResultSet resultset = statement.executeQuery(query);

        CurrentStaticUser tempUser = new CurrentStaticUser();
        while(resultset.next()){
            tempUser.userId = resultset.getInt("userID");
            tempUser.username = resultset.getString("username");
            tempUser.password = resultset.getString("password");
            tempUser.teamId = resultset.getInt("teamId");
            tempUser.role  = resultset.getString("role");
            tempUser.email = resultset.getString("email");
            reviewers.add(tempUser);
        }

        return reviewers;
    }


    public Reviewer(String username, int userID) {
        super(username,userID);
    }

}