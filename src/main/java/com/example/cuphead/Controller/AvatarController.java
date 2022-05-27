package com.example.cuphead.Controller;

import com.example.cuphead.Model.Database;

import java.util.Random;

public class AvatarController {
    private Database database;
    public AvatarController(Database database){
        this.database = database;
    }

    public int avatarCaseRandom(){
        int count = 0;
        Random random = new Random();
        int remainder = Math.abs(random.nextInt()) % 4;
        switch (remainder){
            case 0:
                count = 0;
                break;
            case 1:
                count = 1;
                break;
            case 2:
                count = 2;
                break;
            case 3:
                count = 3;
                break;
        }
        return count;
    }

}
