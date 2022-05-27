package com.example.cuphead.Model;

import javafx.animation.Transition;
import javafx.util.Duration;

public class BossAnimation extends Transition {
    private Boss boss;
    private int Direction;
    public BossAnimation(Boss boss,int direction){
        this.boss = boss;
        this.Direction = direction;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(1000));
    }
    @Override
    protected void interpolate(double v) {
        if(boss.getY() < 10){
             Direction = 1;

        }else if(boss.getY() > 300){
            Direction = -1;
        }

        switch(Direction){
            case 1:
                int frame = (int)Math.floor(v * 5);
                frame++;
                boss.Move(0,7);
                boss.setBackGround("Bossfly" + frame + ".png");
                break;

            case -1:
                int fram = (int)Math.floor(v * 5);
                fram++;
                boss.Move(0,-7);
                boss.setBackGround("Bossfly" + (6 -fram) + ".png");
                break;
        }



    }
}
