package com.example.cuphead.View;

import com.example.cuphead.Controller.GameController;
import com.example.cuphead.Main;
import com.example.cuphead.Model.User;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameMenu {

    private static User user;
    public static GameController controller;

    @FXML
    private Pane paneSample;





    public static void setUp(User use){
        user = use;
        controller = new GameController(Main.database,use);
    }

    public void cupHeadMove(){
        controller.setRequestFocus(paneSample);

    }



   public  void initialize()  {
       DoubleProperty xPosition = new SimpleDoubleProperty(0);
       xPosition.addListener((observable, oldValue, newValue) -> setBackgroundPositions(paneSample, xPosition.get()));
       Timeline timeline = new Timeline(
               new KeyFrame(Duration.ZERO, new KeyValue(xPosition, 0)),
               new KeyFrame(Duration.seconds(200), new KeyValue(xPosition, -15000))
       );
       timeline.play();

       controller.setPaneSample(paneSample);
       controller.createMiniBoss(paneSample);
       controller.createBoss(paneSample);
       controller.createBullet(paneSample);
       controller.createEgg(paneSample);
       controller.createProgressBarOfBoss(paneSample);
       controller.createUsersLiveAndScore(paneSample);
   }

    public void setBackgroundPositions(Pane region, double xPosition) {
        String style = "-fx-background-position: " +
                "left " + xPosition/6 + "px bottom," +
                "left " + xPosition/5 + "px bottom," +
                "left " + xPosition/4 + "px bottom," +
                "left " + xPosition/3 + "px bottom," +
                "left " + xPosition/2 + "px bottom," +
                "left " + xPosition + "px bottom;";
        region.setStyle(style);
    }


}
