package com.example.cuphead.Controller;

import com.example.cuphead.Model.Database;
import com.example.cuphead.Model.User;

public class loginMenuController {

     private Database database;
      public loginMenuController(Database database){
           this.database = database;
      }


    public static int howManyDigitInString(String input){
        int count = 0;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length;i++){
            if(Character.isDigit(chars[i])){
                count++;
            }
        }
        return count;
    }

    public int registerControll(String username,String password){

          int howManyDigit = howManyDigitInString(password);
          if(howManyDigit < 4){
              return 1;
          }else if(database.getUsernameAndPassword(username,password) != null){
              return -1;
          }

          return 0;
    }

    public User CanLogin(String username,String password){
          if(database.getUserForLogin(username,password) != null){
             return database.getUserForLogin(username,password);
          }
          return null;
    }

}
