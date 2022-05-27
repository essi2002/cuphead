package com.example.cuphead.View;

import com.example.cuphead.Controller.scoreBoardController;
import com.example.cuphead.Main;
import com.example.cuphead.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class scoreBoard {

    private static scoreBoardController controller;
    private static User user;
    @FXML
    private  Label firstPlace;
    @FXML
    private  Label secondPlace;
    @FXML
    private  Label thirdPlace;
    @FXML
    private  Label fourthPlace;
    @FXML
    private  Label fifthPlace;
    @FXML
    private  Label sixthPlace;
    @FXML
    private  Label seventhPlace;
    @FXML
    private  Label eightPlace;
    @FXML
    private  Label ninthPlace;
    @FXML
    private  Label tenthPlace;

    public static void setUp(User use){
        controller = new scoreBoardController(Main.database);
        user = use;
    }

    public void normalScore(MouseEvent mouseEvent) throws IOException {
        ArrayList<User> readyToShow = controller.sortArrayListOfUser();
        HashMap<Integer,Label> connections = new HashMap<>();
        connections.put(1, firstPlace);
        connections.put(2, secondPlace);
        connections.put(3, thirdPlace);
        connections.put(4, fourthPlace);
        connections.put(5, fifthPlace);
        connections.put(6, sixthPlace);
        connections.put(7, seventhPlace);
        connections.put(8, eightPlace);
        connections.put(9, ninthPlace);
        connections.put(10, tenthPlace);

        int size = 0;
        if(readyToShow.size() <= 10){
            size = readyToShow.size();
        }else{
            size = 10;
        }

         for(int i = 0; i < size;i++){
           Label temp = connections.get(i + 1);
           temp.setText(i + 1 +"-"+ readyToShow.get(i).getUsername() +":" +readyToShow.get(i).getScore());
         }
    }


    public void devilModeScore(MouseEvent mouseEvent) {
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.changeToMainMenu(user);
    }
}
