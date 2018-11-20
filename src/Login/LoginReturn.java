package Login;

import Users.User;

public class LoginReturn {
    public boolean isSuccessful;
    public String type;
    public User returnedUser;

    public LoginReturn()
    {
        isSuccessful = false;
        type = "(empty)";
    }
}
