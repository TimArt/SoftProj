package Login;

import javafx.scene.text.Text;
import java.sql.*;

public class Login {

    //PasswordAuthentication authenticator = new PasswordAuthentication();
    //String filename = "Users.txt";

    public boolean login(String username, String password, Text actiontarget)
    {
        boolean result = false;
        boolean user_exists = false;
        boolean password_correct = false;

        Connection conn = null;
        //File file  = new File(filename);
        //Scanner inputFile = null;
        /*try {
            inputFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        /*while(inputFile.hasNext())
        {
            String us_name = inputFile.next();
            String pass_toked = inputFile.next();
            String us_type = inputFile.next();
            if(us_name.equals(username))
            {
                user_exists = true;
                if(authenticator.authenticate(password,pass_toked))
                {
                    password_correct = true;
                }
                break;
            }
        }*/
        if( user_exists)
        {
            if(password_correct)
            {
                // DO THE ACTION
                result = true;
            }
            else
            {
                //System.out.println("Password is not correct!");
                actiontarget.setText("Password is not correct!");
            }
        }
        else
        {
            //System.out.println("No user with this username!");
            actiontarget.setText("No user with this username!");
        }
        //inputFile.close();
        return  result;
    }

    /*
    public boolean addUser(String username, String passwd, String usertype)
    {
        boolean result = false;
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(filename,true); //the true will append the new data
            String passwd_token = authenticator.hash(passwd);
            fw.write(username+" "+passwd_token+" "+usertype+"\n");//appends the string to the file
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
        finally {
            try {
                if (fw != null) {
                    fw.flush();
                    fw.close();
                    result = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    */
}
