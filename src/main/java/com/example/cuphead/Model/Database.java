package com.example.cuphead.Model;

import java.util.ArrayList;

public class Database {
    private ArrayList<User> users;
    public Database(){
        this.users = new ArrayList<User>();
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public User getUsernameAndPassword(String Username,String Password){

        for (User user: this.users) {
            if(user.getUsername().equals(Username)){
                return user;
            }
        }

        for (User user: this.users) {
            if(user.getPassword().equals(Password)){
                return user;
            }
        }
        return null;
    }

    public boolean repititousPassword(String newPassword){
        for(int i = 0; i < users.size();i++){
            if(users.get(i).getPassword().equals(newPassword)){
                return true;
            }
        }
        return false;
    }

    public boolean repititousUsername(String newUsername){
        for(int i = 0; i < users.size();i++){
            if(users.get(i).getUsername().equals(newUsername)){
                return true;
            }
        }
        return false;
    }

    public void setUsers(ArrayList<User> use){
        this.users = use;
    }

    public User getUserForLogin(String username,String password){
        for(int i =0 ;i < users.size();i++){
            if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)){
                return users.get(i);
            }
        }
        return null;
    }
}
