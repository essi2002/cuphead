package com.example.cuphead.Model;

import com.example.cuphead.Controller.GameController;
import com.example.cuphead.Main;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class verticalBulletAnimation extends Transition {
    private verticalBullet bullet;
    private Pane pane;
    private User user;
    public verticalBulletAnimation(verticalBullet bull,Pane pane,User use){
        this.bullet = bull;
        this.pane = pane;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
        this.user = use;
    }
    @Override
    protected void interpolate(double v) {
        if(bullet.getY() > 750){
            pane.getChildren().remove(bullet);
            this.stop();
        }else{
            if(bullet.hasCollisionMinibosses() != null){
                if(user != null){
                    user.setScore(5);
                }
                bullet.hasCollisionMinibosses().setLive(bullet.hasCollisionMinibosses().getLive() - 100);
                if(bullet.hasCollisionMinibosses().getLive() <= 0){
                    pane.getChildren().remove(bullet.hasCollisionMinibosses());
                    bullet.getminiBosses().remove(bullet.hasCollisionMinibosses());

                }
                pane.getChildren().remove(bullet);
                this.stop();
            }else if(bullet.hasCollisionBoss() != null){
                bullet.hasCollisionBoss().setLive(bullet.hasCollisionBoss().getLive() - 20);
                if(user != null){
                    user.setScore(8);
                }
                if(bullet.hasCollisionBoss().getLive() <= 0){
                    pane.getChildren().remove(bullet.hasCollisionBoss());
                    GameController.endGame = true;
                    try {
                        pane.getChildren().remove(bullet);
                        this.stop();
                        Main.changeToFinishedMenu(bullet.hasCollisionBoss(),user,bullet.getCupHead());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                pane.getChildren().remove(bullet);
                this.stop();


            }else{
                double x = 0;
                double y = 10;
                bullet.move(x,y);
            }
        }


    }
}
