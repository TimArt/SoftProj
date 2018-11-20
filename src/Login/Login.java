package Login;

import Users.Admin;
import Users.Lecturer;
import Users.Submitter;
import Users.User;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    Integer id;
    private Map<Integer, User> allUsers = new HashMap<>();

    public Login(Integer static_id, Map<Integer, User> all_users,boolean isFirst)
    {
        id = static_id;
        allUsers = all_users;

        if(isFirst) {
            //DELETE THIS:
            System.out.println("\t\tPRINT");
            createUserInstance(0, "admin", "Admin");
            createUserInstance(1, "DrSong", "Lecturer");
            createUserInstance(2, "Askar", "Submitter");
            createUserInstance(3, "Tim", "Submitter");
            createUserInstance(4, "Rabeya", "Submitter");
            createUserInstance(5, "Nayma", "Submitter");
            createUserInstance(6, "Jack", "Submitter");
        }
    }

    PasswordAuthentication authenticator = new PasswordAuthentication();
    String filename = "Users.txt";

    public boolean addUser(String username, String passwd, String usertype)
    {
        boolean result = false;
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(filename,true); //the true will append the new data
            String passwd_token = authenticator.hash(passwd);
            fw.write( id.toString() +" "+username+" "+passwd_token+" "+usertype+"\n");//appends the string to the file

            //creating new User instance:
            createUserInstance(id,username,usertype);
            id += 1;

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


    public LoginReturn login(String username, String password, Text actiontarget)
    {
        LoginReturn result = new LoginReturn();
        result.isSuccessful = false;

        File file  = new File(filename);
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean user_exists = false;
        boolean password_correct = false;
        Integer read_id = new Integer(0);
        String us_type = "";
        while(inputFile.hasNext())
        {
            String string_id = inputFile.next();
            read_id = Integer.valueOf(string_id);
            String us_name = inputFile.next();
            String pass_toked = inputFile.next();
            us_type = inputFile.next();
            if(us_name.equals(username))
            {
                user_exists = true;
                if(authenticator.authenticate(password,pass_toked))
                {
                    password_correct = true;
                }
                break;
            }

        }
        if( user_exists)
        {
            if(password_correct)
            {
                // DO THE ACTION
                result.isSuccessful = true;
                result.type = us_type;
                result.returnedUser = allUsers.get(read_id);
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
        inputFile.close();
        return  result;
    }

    //actually it must be private:
    public void createUserInstance(Integer ID, String username, String usertype)
    {
        if( usertype.equals("Submitter"))
        {
            if(!allUsers.containsKey(ID)) {
                allUsers.put(ID, new Submitter(username, ID));
            }
        }
        else if( usertype.equals("Lecturer"))
        {
            if(!allUsers.containsKey(ID)) {
                allUsers.put(ID, new Lecturer(username, ID));
            }
        }
        else if( usertype.equals("Admin"))
        {
            if(!allUsers.containsKey(ID)) {
                allUsers.put(ID, new Admin(username, ID));
            }
        }
    }

}
