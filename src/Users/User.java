package Users;

public class User {

    private String username;
    private static int userID = 0;
    private char[] passwordHash;
    private boolean isFirstLogin;


    public boolean register(String username, String password ){
        return false;
    }

    public boolean login(String username, String passwword){
        return false;
    }

    public String getname(){
        return username;
    }

    public boolean changePSWD(String oldPassword, String newPassword)
    {
        return false;
    }

}


