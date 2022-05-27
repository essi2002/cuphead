package com.example.cuphead.Model;

import com.example.cuphead.Controller.GameController;
import com.example.cuphead.Main;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class EggMoveAnimation extends Transition {
    private Egg egg;
    private Pane pane;
    private User user;
    public EggMoveAnimation(Egg egg,Pane pane,User use){
      this.egg = egg;
      this.pane = pane;
        this.setCycleCount(-1);
        this.user = use;
        this.setCycleDuration(Duration.millis(1000));
    }
    @Override
    protected void interpolate(double v) {

        if(egg.getX() < -40 || egg.getY() < -40){
            pane.getChildren().remove(egg);
            this.stop();
        }else{
            if(egg.hasCollisionCuphead() != null && egg.hasCollisionCuphead().getCanCost() == true){
                if(egg.hasCollisionCuphead().getCanCost() == true){
                    egg.hasCollisionCuphead().setLive( egg.hasCollisionCuphead().getLive() - 8);
                }
                if(user != null){
                    user.setScore(-7);
                }
                BlinkCupHead animation = new BlinkCupHead(egg.hasCollisionCuphead(),pane);
                egg.hasCollisionCuphead().setCanCost(false);
                animation.play();
                pane.getChildren().remove(egg);
                this.stop();
                if(egg.hasCollisionCuphead().getLive() <= 0){
                    GameController.endGame = true;
                    try {
                        Main.changeToFinishedMenu(egg.getBoss(),user,egg.getCupHead());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }


            }else{
                egg.Move(-4,0);
            }

        }
    }
}
