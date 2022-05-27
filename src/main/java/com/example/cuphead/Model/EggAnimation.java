package com.example.cuphead.Model;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class EggAnimation extends Transition {
    private Boss boss;
    private Egg egg;
    private Pane pane;
    private User user;
    public EggAnimation(Boss boss,Egg egg,Pane pane,User use){
        this.boss = boss;
        this.egg = egg;
        this.pane = pane;
        this.setCycleCount(1);
        this.user = use;
        this.setCycleDuration(Duration.millis(1000));
    }
    @Override
    protected void interpolate(double v) {
        int frame = (int)Math.floor(v * 11);
        frame++;
        if(frame < 5){
            boss.setBackGround("shoot" + frame +".png");
        }else if(frame == 5){
            boss.setBackGround("shoot" + frame +".png");
            pane.getChildren().add(egg);
            EggMoveAnimation animation = new EggMoveAnimation(egg,pane,user
            );
            animation.play();
        }else {
            boss.setBackGround("shoot" + frame +".png");
        }


    }
}
