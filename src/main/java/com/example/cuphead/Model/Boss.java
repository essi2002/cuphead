package com.example.cuphead.Model;

import com.example.cuphead.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Boss extends ImageView {
    Pane pane;

    private int live;

    public Boss(Image image,Pane pane,double x,double y){
        super(image);
        this.pane = pane;
        this.setX(x);
        this.setY(y);
        this.live = 100;
    }

    public void Move(double x,double y){
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    public void setBackGround(String url){
        this.setImage(new Image(Main.class.getResource(url).toString()));
    }

    public Pane getPane(){
        return this.pane;
    }

    public void setLive(int liv){
        this.live = liv;
    }

    public int getLive(){
        return this.live;
    }
}
