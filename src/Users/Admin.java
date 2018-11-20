package Users;

import Login.Login;
import Login.LoginReturn;

public class Admin extends User {


    public Admin(String username, int userID) {
        super(username, userID);
    }

    // Admin creates User object with username and password
    // and informs the User about his/her username and password.
    // User will need to change the password after his/her first login.
    public boolean addUser(String username, String password, String usertype, Login loginSystem)
    {
        //return loginSystem.addUser(username,password, usertype);
        return false;
    }

    public void removeUser(int id)
    {

    }

    public void removeUser(String username)
    {

    }

    public void addreviewTemplate(int artifactType, String data)
    {

    }

    public void addNotificationMapping(int notificationType[])
    {

    }
}
