/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import movierecsys.be.Movie;
import movierecsys.be.User;

/**
 *
 * @author pgn
 */
public class UserDAO
{
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();
        for(User user: users){
            System.out.println(user.getId() + " : " + user.getName());
        }
        User u = dao.getUser(2648853);
        System.out.println(u.getName());
        u.setName("Jeppe");
        dao.updateUser(u);
        User jeppe = dao.getUser(2648853);
        System.out.println(jeppe.getId() + " : " + jeppe.getName());
    }
    private static final String USER_SOURCE = "data/users.txt";

    /**
     * Gets a list of all known users.
     * @return List of users.
     */
    public List<User> getAllUsers()
    {
        List<User> allUsers = new ArrayList<>();
        File file = new File(USER_SOURCE);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {

                    User user = stringToUser(line);
                    allUsers.add(user);
                } catch (Exception ex) {
                    //Do nothing we simply do not accept malformed lines of data.
                    //In a perfect world you should at least log the incident.
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allUsers;
    }

    private User stringToUser(String t) {
        String[] arrUser = t.split(",");

        int id = Integer.parseInt(arrUser[0]);

        String name = arrUser[1];
        if (arrUser.length > 2) {
            for (int i = 2; i < arrUser.length; i++) {
                name += "," + arrUser[i];
            }
        }
        return new User(id, name);

    }
    
    /**
     * Gets a single User by its ID.
     * @param id The ID of the user.
     * @return The User with the ID.
     */
    public User getUser(int id)
    {
        try {
            List<String> lines = Files.readAllLines(Path.of(USER_SOURCE));
            for(String line : lines ){
                if(line!=null) {
                    User currentUser = stringToUser(line);
                    if (currentUser.getId() == id) {
                        return currentUser;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    /**
     * Updates a user so the persistence storage reflects the given User object.
     * @param user The updated user.
     */
    public void updateUser(User user)
    {
        try {
            List<User> users = getAllUsers();

            String userString  = "";
            for(User u : users){
                if(u.getId()==user.getId()){
                    u = user;
                }
                userString += u.getId() + "," +
                        u.getName() + "\n";
            }

            Files.writeString(Path.of(USER_SOURCE),userString);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
