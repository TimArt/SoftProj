package Users;

import Others.SubmissionGroup;
import Others.Team;
import main.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public ArrayList<CurrentStaticUser> showListOfRPM() throws SQLException {
        Connection conn = DatabaseUtil.createConnection();
        ArrayList<CurrentStaticUser> rpm = new ArrayList<>();

        String query = "SELECT * FROM USER WHERE role = RPM" ;
        Statement statement = conn.createStatement();
        ResultSet resultset = statement.executeQuery(query);

        CurrentStaticUser temp;
        temp = new CurrentStaticUser();
        while(resultset.next()){
            temp.userId = resultset.getInt("userID");
            temp.username = resultset.getString("username");
            temp.password = resultset.getString("password");
            temp.teamId = resultset.getInt("teamId");
            temp.role  = resultset.getString("role");
            temp.email = resultset.getString("email");
            rpm.add(temp);
        }

        return rpm;
    }

    public RPM(String username, int userID) {
        super(username,userID);
    }

}
