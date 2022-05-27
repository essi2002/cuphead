package com.example.cuphead.Model;

import com.example.cuphead.Controller.GameController;
import com.example.cuphead.Main;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class miniBossAnimation extends Transition {
    private miniBoss miniBosses;
    private Pane pane;
    private User user;

    public miniBossAnimation(miniBoss miniBoss,Pane pane,User use){
        this.miniBosses  = miniBoss;
        this.pane = pane;
        this.user = use;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(4);
    }
    @Override
    protected void interpolate(double v) {
        int frame = (int)Math.floor(v * 3);
        frame++;

            if(miniBosses.hasCollisionCuphead() != null && miniBosses.hasCollisionCuphead().getCanCost() == true) {
                if( miniBosses.hasCollisionCuphead().getCanCost() == true){
                    miniBosses.hasCollisionCuphead().setLive( miniBosses.hasCollisionCuphead().getLive() - 3);
                }
                if(user != null){
                    user.setScore(-5);
                }
                miniBosses.hasCollisionCuphead().setCanCost(false);
                BlinkCupHead animation = new BlinkCupHead(miniBosses.hasCollisionCuphead(),pane);
                animation.play();
                pane.getChildren().remove(miniBosses);
                this.stop();
             if(miniBosses.hasCollisionCuphead().getLive() <= 0){
                 GameController.endGame = true;
                 try {
                     Main.changeToFinishedMenu(miniBosses.getBoss(),user,miniBosses.getCupHead());
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
             }



            }else{
                miniBosses.setBackground(frame + ".png");
                miniBosses.move(-4,0);
            }

        }

}
