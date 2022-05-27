package com.example.cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class verticalBullet extends ImageView {

    private Pane pane;
    private CupHead cuphead;

    private ArrayList<miniBoss> miniBosses = new ArrayList<>();

    private Boss boss;

    public verticalBullet(Pane pane, CupHead cuphead, Image image,ArrayList<miniBoss> miniBosses,Boss boss){
        super(image);
        this.setX(cuphead.getX() + 80);
        this.setY(cuphead.getY() + 50);
        this.pane = pane;
        this.cuphead = cuphead;
        this.miniBosses = miniBosses;
        this.boss = boss;

    }
    public void move(double x,double y){
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    public miniBoss hasCollisionMinibosses(){
        for (int i =0; i < miniBosses.size();i++){
            if(miniBosses.get(i).getBoundsInParent().intersects(this.getLayoutBounds())){
                return miniBosses.get(i);
            }
        }
        return null;
    }
    public ArrayList<miniBoss> getminiBosses(){
        return this.miniBosses;
    }


    public CupHead getCupHead(){
        return this.cuphead;
    }

    public Boss hasCollisionBoss(){
        if(boss.getBoundsInParent().intersects(this.getLayoutBounds())){
            return boss;
        }
        return null;
    }
}
