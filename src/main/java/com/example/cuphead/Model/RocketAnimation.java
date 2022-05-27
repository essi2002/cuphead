package com.example.cuphead.Model;

import javafx.animation.Transition;
import javafx.util.Duration;

public class RocketAnimation extends Transition {
    private CupHead cuphead;
    public RocketAnimation(CupHead cup){
        this.cuphead = cup;
        setCycleDuration(Duration.millis(500));
    }
    @Override
    protected void interpolate(double v) {
        int frame = (int)Math.floor(v * 14);
        frame++;
        if(frame < 10){
            cuphead.setBackGround("mm_shmup_super_intro_000" + frame + ".png");
        }else{
            cuphead.setBackGround("mm_shmup_super_intro_00" + frame  + ".png");
        }

    }
}
