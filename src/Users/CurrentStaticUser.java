package Users;

public class CurrentStaticUser {
    public static int userId;
    public static String username;
    public static String password;
    public static int teamId;
    public static String role;
    public static String email;

    /*
  userID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  isApproved tinyint(1) DEFAULT '0',
  email varchar(50) UNIQUE NOT NULL,
  teamID INT UNSIGNED DEFAULT NULL,
    * */
}
