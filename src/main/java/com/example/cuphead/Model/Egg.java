package com.example.cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Egg extends ImageView {

    private CupHead cuphead;
    private Boss boss;
    private Pane pane;
    public Egg(Image image,Pane pane,double x,double y,Boss boss,CupHead cuphead){
        super(image);
        this.cuphead = cuphead;
        this.pane = pane;
        this.setX(x);
        this.setY(y);
        this.boss = boss;
    }

    public void Move(double x,double y){
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
    public CupHead hasCollisionCuphead(){
        if(cuphead.getBoundsInParent().intersects(this.getLayoutBounds())){
            return cuphead;
        }
        return null;
    }
    public Boss getBoss(){
        return this.boss;
    }
    public CupHead getCupHead(){
        return this.cuphead;
    }
}
