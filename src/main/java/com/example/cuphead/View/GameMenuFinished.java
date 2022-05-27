package com.example.cuphead.View;

import com.example.cuphead.Controller.GameController;
import com.example.cuphead.Controller.saveData;
import com.example.cuphead.Main;
import com.example.cuphead.Model.Boss;
import com.example.cuphead.Model.CupHead;
import com.example.cuphead.Model.User;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URISyntaxException;

public class GameMenuFinished {
    public AnchorPane myPane;

    private static GameController controller;
    private static Boss boss;
    private static User user;
    private static CupHead cuphead;

    public static void setUp(Boss bos,User use,CupHead cup){
        controller = new GameController(Main.database,use);
        boss = bos;
        user = use;
        cuphead = cup;
    }
    public void setRectangle(){
        Rectangle fatherBar1 = new Rectangle();
        fatherBar1.setX(200);
        fatherBar1.setY(140);
        fatherBar1.setWidth(80);
        fatherBar1.setHeight(20);
        fatherBar1.setArcWidth(20);
        fatherBar1.setArcHeight(20);
        myPane.getChildren().add(fatherBar1);



        Rectangle fat = new Rectangle();
        fat.setFill(Color.CYAN);
        fat.setX(200);
        fat.setY(140);
        fat.setWidth(80 * ((double)(100 - boss.getLive())/ (double)(100)));
        fat.setHeight(20);
        fat.setArcWidth(20);
        fat.setArcHeight(20);
        myPane.getChildren().add(fat);
    }

    public void ExitToMainMenu(MouseEvent mouseEvent) throws IOException {
        Main.changeToMainMenu(user);
    }

    public void Retry(MouseEvent mouseEvent) throws IOException, URISyntaxException {
        Main.changeToGame(user);
    }

    public void quitGame(MouseEvent mouseEvent) throws IOException {
         saveData save = new saveData(user,Main.database);
         save.saveNormalUsers();
         System.exit(0);
    }
}
