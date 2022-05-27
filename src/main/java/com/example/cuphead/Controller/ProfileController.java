package com.example.cuphead.Controller;

import com.example.cuphead.Model.Database;
import com.example.cuphead.Model.User;

public class ProfileController {
    private Database database;
    public ProfileController(Database database){
        this.database = database;
    }
    public boolean canChangePassword(User user, String newPassword){
        if(user.getPassword().equals(newPassword)){
            return false;
        }
        if(newPassword.length() < 8){
            return false;
        }
        if(loginMenuController.howManyDigitInString(newPassword) < 4){
            return false;
        }
        if(database.repititousPassword(newPassword)){
            return false;
        }
        return true;
    }
    public void changePassword(User user,String newPassword){
          user.setPassword(newPassword);
    }
    public boolean canChangeUsername(User user,String newUsername){
        if(user.getUsername().equals(newUsername)){
            return false;
        }
        if(database.repititousUsername(newUsername)){
            return false;
        }
        return true;
    }
    public void chaneUsername(User user,String newUsername){
        user.setUsername(newUsername);
    }

}

