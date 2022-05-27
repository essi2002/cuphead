package com.example.cuphead.Model;

import com.example.cuphead.Controller.GameController;
import com.example.cuphead.Main;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class BulletAnimation extends Transition {

    private Bullet bullet;
    private Pane pane;
    private User user;
    public BulletAnimation(Bullet bull,Pane pane,User usr){
        this.bullet = bull;
        this.pane = pane;
        this.user = usr;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(100);
    }
    @Override
    protected void interpolate(double v) {
        if(bullet.getX() > 1500){
            pane.getChildren().remove(bullet);
            this.stop();
        }else{
            if(bullet.hasCollisionMinibosses() != null){
                if(user != null){
                    user.setScore(3);
                }
                 bullet.hasCollisionMinibosses().setLive(bullet.hasCollisionMinibosses().getLive() - 50);
                 if(bullet.hasCollisionMinibosses().getLive() <= 0){
                     pane.getChildren().remove(bullet.hasCollisionMinibosses());
                     bullet.getminiBosses().remove(bullet.hasCollisionMinibosses());
                 }
                pane.getChildren().remove(bullet);
                this.stop();


            }else if(bullet.hasCollisionBoss() != null){

                bullet.hasCollisionBoss().setLive(bullet.hasCollisionBoss().getLive() - 10);
                pane.getChildren().remove(bullet);
                this.stop();
                if(user != null){
                    user.setScore(5);
                }
                 if(bullet.hasCollisionBoss().getLive() <= 0){
                      pane.getChildren().remove(bullet.hasCollisionBoss());
                     GameController.endGame = true;
                     try {
                         Main.changeToFinishedMenu(bullet.hasCollisionBoss(),user,bullet.getCuphead());
                     } catch (IOException e) {
                         throw new RuntimeException(e);
                     }
                 }

            }
             else{
                double x = 10;
                double y = 0;
                bullet.move(x,y);
            }
        }



    }
}
