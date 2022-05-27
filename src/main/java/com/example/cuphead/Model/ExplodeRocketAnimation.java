package com.example.cuphead.Model;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ExplodeRocketAnimation extends Transition {
    private CupHead cuphead;
    private Pane pane;
    public ExplodeRocketAnimation(CupHead cuphead,Pane pan){
        this.pane = pan;
        this.cuphead = cuphead;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(1);
    }
    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 11);
        frame++;
        if(frame < 10){
            cuphead.setBackGround("mm_shmup_super_boom_000" + frame + ".png");
        }else if(frame < 12){
            cuphead.setBackGround("mm_shmup_super_boom_00" + frame + ".png");
        } else if (frame  == 12) {
            cuphead.setBackGround("blue.png");
            pane.getChildren().get(pane.getChildren().indexOf(cuphead)).requestFocus();
            this.stop();
        }
    }
}
