package com.example.cuphead.Controller;

import com.example.cuphead.Main;
import com.example.cuphead.Model.Database;
import com.example.cuphead.Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class saveData {


    private User user;
    private Database database;
    public saveData(User use, Database database){
        this.user = use;
        this.database = database;
    }




    public void saveNormalUsers() throws IOException {
        FileWriter filewriter = new FileWriter(Main.class.getResource("Users.json").toString());
        filewriter.write(new Gson().toJson(database.getUsers()));
        filewriter.close();
    }


    public void saveScoreUsers(ArrayList<User> users) throws IOException {
        FileWriter filewriter = new FileWriter(Main.class.getResource("UsersScore.json").toString());
        filewriter.write(new Gson().toJson(users));
        filewriter.close();
    }


    public void loadUsers() throws IOException {
        String Users = new String(Files.readAllBytes(Paths.get(Main.class.getResource("Users.json").toString())));
        database.setUsers(new Gson().fromJson(Users,new TypeToken<List<User>>() {
        }.getType()));
    }

}
