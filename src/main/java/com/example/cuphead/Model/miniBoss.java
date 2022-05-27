package com.example.cuphead.Model;

import com.example.cuphead.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class miniBoss extends ImageView {
    private CupHead cuphead;
    private Pane pane;
    private Boss boss;
    private int live;
    public miniBoss(Image image,Pane pane,double x,double y,int live,CupHead cuphead,Boss boss){
        super(image);
        this.pane = pane;
        this.setX(x);
        this.setY(y);
        this.live = live;
        this.cuphead = cuphead;
        this.boss = boss;
    }

    public void setLive(int liv){
        this.live = liv;
    }
    public int getLive(){
        return this.live;
    }
    public void move(double x,double y){

        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    public Boss getBoss(){
        return this.boss;
    }
    public CupHead hasCollisionCuphead(){
        if(cuphead.getBoundsInParent().intersects(this.getLayoutBounds())){
            return cuphead;
        }
        return null;
    }

    public CupHead getCupHead(){
        return this.cuphead;
    }

    public void setBackground(String url){
        this.setImage(new Image(Main.class.getResource(url).toString()));
    }
}
