package com.example.cuphead.Model;

import com.example.cuphead.Controller.GameController;
import com.example.cuphead.Main;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class RocketMoveAnimation extends Transition {
    private CupHead cuphead;
    private Pane pane;
    private Boss boss;

    private User user;
    public RocketMoveAnimation(CupHead cup,Pane pan,Boss bos,User use){
        this.cuphead = cup;
        this.pane = pan;
        this.boss = bos;
        this.user = use;
        this.setCycleDuration(Duration.millis(500));
        this.setCycleCount(-1);

    }
    @Override
    protected void interpolate(double v) {
        if(cuphead.getX() > 800){
            pane.getChildren().remove(cuphead);
            this.stop();
        }else{
            if(cuphead.hasCollisionBoss(boss) != null){
                ExplodeRocketAnimation animation = new ExplodeRocketAnimation(cuphead,pane);
                animation.play();
                boss.setLive(boss.getLive() - 40);
                if(user != null){
                    user.setScore(15);
                }
                if(boss.getLive() <= 0){
                    pane.getChildren().remove(boss);
                    GameController.endGame = true;
                    try {
                        pane.getChildren().remove(boss);
                        this.stop();
                        Main.changeToFinishedMenu(boss,user,cuphead);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }else{
                cuphead.Move(5,0);
            }

        }

    }
}
