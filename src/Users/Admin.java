package Users;

import Login.Login;

public class Admin extends User {


    // Admin creates User object with username and password
    // and informs the User about his/her username and password.
    // User will need to change the password after his/her first login.
    public boolean addUser(String username, String password, String usertype, Login loginSystem)
    {
        return loginSystem.addUser(username,password, usertype);
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
