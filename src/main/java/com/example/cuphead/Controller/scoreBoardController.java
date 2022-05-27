package com.example.cuphead.Controller;

import com.example.cuphead.Main;
import com.example.cuphead.Model.Database;
import com.example.cuphead.Model.User;

import java.io.IOException;
import java.util.ArrayList;

public class scoreBoardController {
    private Database database;
    public scoreBoardController(Database database){
        this.database = database;
    }


    public ArrayList<User> sortArrayListOfUser() throws IOException {
         ArrayList<User> emptyUsers = new ArrayList<>();
         ArrayList<User> allUser = this.database.getUsers();
         for(int i = 0 ; i < allUser.size();i++){
             emptyUsers.add(allUser.get(i));
         }
         for (int i = 0 ; i < emptyUsers.size();i++){
             for(int j =  i + 1; j < emptyUsers.size();j++){
                 if(emptyUsers.get(i).getScore() < emptyUsers.get(j).getScore()){
                     User temp = emptyUsers.get(i);
                     emptyUsers.set(i,emptyUsers.get(j));
                     emptyUsers.set(j,temp);
                 }else if(emptyUsers.get(i).getScore() == emptyUsers.get(j).getScore()){
                     if(emptyUsers.get(i).getTurn() > emptyUsers.get(j).getTurn()){
                         User temp = emptyUsers.get(i);
                         emptyUsers.set(i,emptyUsers.get(j));
                         emptyUsers.set(j,temp);
                     }
                 }
             }
         }
         saveData save = new saveData(null, Main.database);
         save.saveScoreUsers(emptyUsers);
         return emptyUsers;
    }

}
