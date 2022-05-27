package com.example.cuphead.Model;



import com.example.cuphead.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CupHead extends ImageView {

    private Pane cupHeadPane;

    private int live;

    private boolean canCost;


    private double dx;
    private double dy;

    private boolean isRocket;




    public CupHead(Pane pane, Image image){
        super(image);
        this.setX(100);
        this.setY(200);
        this.cupHeadPane = pane;
        this.isRocket = false;
        this.live = 80;
        this.canCost = true;
    }

    public void setCanCost(boolean bool){
        this.canCost = bool;
    }
    public boolean getCanCost(){
        return this.canCost;
    }
    public void setSpeed(double x,double y){
        this.dx = x;
        this.dy = y;
    }

    public double getDx(){
        return this.dx;
    }
    public double getDy(){
        return this.dy;
    }

    public void setLive(int Liv){
        this.live = Liv;
    }
    public int getLive(){
        return this.live;
    }

    public void Move(double x,double y){
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    public boolean hasCollisionTopWall(){
        if(this.getY() + this.getDy() <= 0){
            return true;
        }
        return false;
    }

    public boolean hasCollisionDownWall(){
        if(this.getY() + this.getDy() >= cupHeadPane.getPrefHeight()){
            return true;
        }
        return false;
    }
    public boolean hasCollisionRightWall(){
        if(this.getX() + this.getDx() >= cupHeadPane.getPrefWidth()){
            return true;
        }
        return false;
    }
    public boolean hasCollisionLeftWall(){
        if(this.getX() + this.getDx() <= 0){
            return true;
        }
        return false;
    }


    public void moveUp(){

        if(hasCollisionTopWall() == false){
            this.setX(this.getX() + this.getDx());
            this.setY(this.getY() + this.getDy());
        }
    }
    public void moveDown(){

        if(hasCollisionDownWall() == false){
            this.setX(this.getX() + this.getDx());
            this.setY(this.getY() + this.getDy());
        }
    }
    public void moveLeft(){

        if(hasCollisionLeftWall() == false){
            this.setX(this.getX() + this.getDx());
            this.setY(this.getY() + this.getDy());
        }
    }
    public void moveRight(){
        //System.out.println("ali");
        if(hasCollisionRightWall() == false){
            System.out.println("ali");
            this.setX(this.getX() + this.getDx());
            this.setY(this.getY() + this.getDy());
        }
    }
    public void setBackGround(String url){
        this.setImage(new Image(Main.class.getResource(url).toString()));
        //System.out.println(url);
    }


    public boolean getIsRocket(){
        return this.isRocket;
    }

    public void setIsRocket(boolean bool){
        this.isRocket = bool;
    }


    public Boss hasCollisionBoss(Boss boss){
        if(boss.getLayoutBounds().intersects(this.getLayoutBounds())){
            return boss;
        }
        return null;
    }

}
