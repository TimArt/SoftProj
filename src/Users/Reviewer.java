package Users;

import Others.Artifact;
import Reviews.ArtifactReview;
import main.Database;

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

    public ArrayList<User> showListOfReviewers() throws SQLException {
        Connection conn = Database.createConnection();
        ArrayList<CurrentStaticUser> reviewers = new ArrayList<>();

        String query = "SELECT * FROM USER WHERE role = Reviewer" ;
        Statement statement = conn.createStatement();
        ResultSet resultset = statement.executeQuery(query);

        CurrentStaticUser temp = new CurrentStaticUser();
        while(resultset.next()){
            temp.userId = resultset.getInt("userID");
            temp.username = resultset.getString("username");
            temp.password = resultset.getString("password");
            temp.teamId = resultset.getInt("teamId");
            temp.role  = resultset.getString("role");
            temp.email = resultset.getString("email");
            reviewers.add(temp);
        }

        return reviewers;
    }

    public Reviewer(String username, int userID) {
        super(username,userID);
    }

}