package com.example.cuphead.Controller;

import com.example.cuphead.Main;
import com.example.cuphead.Model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

public class GameController {
    private Database database;
    private User user;

    private CupHead cuphead;

    private Rectangle rocketRectangle = new Rectangle();

    private Rectangle progressBar = new Rectangle();

    private ArrayList<miniBoss> miniBosses = new ArrayList<>();
    private Pane paneSample;

    private Boss boss = new Boss(new Image(Main.class.getResource("Bossfly1.png").toString()),paneSample,550,80);


    public static boolean endGame = false;




    private ArrayList<Bullet> bullets = new ArrayList<>();


    private ArrayList<verticalBullet> verticalBullets = new ArrayList<>();

    public GameController(Database database,User usr) {
        this.database = database;
        this.user = usr;


    }

    public void setPaneSample(Pane pane){
        this.paneSample = pane;
    }


   private Text score;
    private Text live;

    public void setRequestFocus(Pane paneSample){
        paneSample.getChildren().get(paneSample.getChildren().indexOf(cuphead)).requestFocus();
    }
    public void createBullet(Pane paneSample){
        cuphead =  new CupHead(paneSample,new Image(Main.class.getResource("blue.png").toString()));
        paneSample.getChildren().add(cuphead);
        cuphead.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyName = keyEvent.getCode().getName();
                KeyCode key = keyEvent.getCode();

                if(keyName.equals("Down")) {
                    cuphead.setSpeed(0, 10);
                    cuphead.moveDown();
                }

                else if(keyName.equals("Up")) {
                    cuphead.setSpeed(0, -10);
                    cuphead.moveUp();
                }else if(keyName.equals("Right")) {
                    cuphead.setSpeed(10, 0);
                    cuphead.moveRight();
                }else if(keyName.equals("Left")){
                    cuphead.setSpeed(-10,0);
                    cuphead.moveLeft();
                }else if(key == KeyCode.SPACE){
                    Bullet bull = new Bullet(paneSample,cuphead,new Image(Main.class.getResource("bullet.png").toString()),miniBosses,boss);
                    paneSample.getChildren().add(bull);
                    BulletAnimation animation = new BulletAnimation(bull,paneSample,user);
                    animation.play();
                    ImageView icon = new ImageView(new Image(Main.class.getResource("shmup_icon_bullet_0001.png").toString()));
                    icon.setX(500);
                    icon.setY(500);
                    paneSample.getChildren().add(icon);
                }else if(key == KeyCode.TAB){
                    verticalBullet bull = new verticalBullet(paneSample,cuphead,new Image(Main.class.getResource("vertical.jpg").toString()),miniBosses,boss);
                    paneSample.getChildren().add(bull);
                    verticalBulletAnimation animation = new verticalBulletAnimation(bull,paneSample,user);
                    animation.play();
                    ImageView icon = new ImageView(new Image(Main.class.getResource("shmup_icon_bomb_0001.png").toString()));
                    icon.setX(500);
                    icon.setY(500);
                    paneSample.getChildren().add(icon);
                }else if(key == KeyCode.ENTER){
                    rocketRectangle.setWidth(0);
                    cuphead.setIsRocket(true);
                    RocketAnimation animation = new RocketAnimation(cuphead);
                    animation.play();
                    RocketMoveAnimation anim = new RocketMoveAnimation(cuphead,paneSample,boss,user);
                    anim.play();

                }


            }
        });
        Rectangle father = new Rectangle();
        father.setX(15);
        father.setY(15);
        father.setWidth(80);
        father.setHeight(20);
        father.setArcWidth(20);
        father.setArcHeight(20);
        if(paneSample.getChildren().contains(father)){
            paneSample.getChildren().remove(father);
        }
        paneSample.getChildren().add(father);

        rocketRectangle.setX(15);
        rocketRectangle.setY(15);
        rocketRectangle.setWidth(0);
        rocketRectangle.setHeight(20);
        rocketRectangle.setArcWidth(20);
        rocketRectangle.setArcHeight(20);
        rocketRectangle.setFill(Color.CYAN);
        if(paneSample.getChildren().contains(rocketRectangle)){
            paneSample.getChildren().remove(rocketRectangle);
        }
        paneSample.getChildren().add(rocketRectangle);


        Timeline time = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(rocketRectangle.getWidth() < 80){
                    rocketRectangle.setWidth(rocketRectangle.getWidth() + 1);
                }
            }
        }));
        time.setCycleCount(1000);
        time.play();





    }

    public void  generateMiniBossSeries(Pane pane){
        if(pane.getChildren().containsAll(miniBosses)){
            pane.getChildren().removeAll(miniBosses);
        }
        miniBosses.clear();
        miniBoss boss1 = new miniBoss(new Image(Main.class.getResource("1.png").toString()),pane,400,30,100,cuphead,boss);
        miniBoss boss2 = new miniBoss(new Image(Main.class.getResource("1.png").toString()),pane,510,30,100,cuphead,boss);
        miniBoss boss3 = new miniBoss(new Image(Main.class.getResource("1.png").toString()),pane,620,30,100,cuphead,boss);
        miniBoss boss4 = new miniBoss(new Image(Main.class.getResource("1.png").toString()),pane,730,30,100,cuphead,boss);
        miniBosses.add(boss1);
        miniBosses.add(boss2);
        miniBosses.add(boss3);
        miniBosses.add(boss4);
        pane.getChildren().addAll(miniBosses);
        for(int i = 0; i < miniBosses.size();i++){
            miniBossAnimation animation = new miniBossAnimation(miniBosses.get(i),pane,user);
            animation.play();
        }


    }
    public void createMiniBoss(Pane paneSample){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                generateMiniBossSeries(paneSample);
            }
        }));
        timeline.setCycleCount(-1);
        timeline.play();
    }



    public void createBoss(Pane paneSample){
      //  Boss boss = new Boss(new Image(Main.class.getResource("Bossfly1.png").toString()),paneSample,550,80);
        if(paneSample.getChildren().contains(boss)){
            paneSample.getChildren().remove(boss);
        }
       // this.boss = boss;
        paneSample.getChildren().add(boss);

        BossAnimation animation = new BossAnimation(boss,1);
        animation.play();

    }

    public void createEgg(Pane paneSample){


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Egg egg = new Egg(new Image(Main.class.getResource("egg.png").toString()),paneSample,boss.getX() - 10,boss.getY() + 230,boss,cuphead);
                EggAnimation animation = new EggAnimation(boss,egg,paneSample,user);
                animation.play();
            }
        }));
        timeline.setCycleCount(-1);
        timeline.play();
    }

    public void createProgressBarOfBoss(Pane paneSample) {
        Text text = new Text();
        text.setFill(Color.RED);
        text.setX(600);
        text.setY(20);

        if(paneSample.getChildren().contains(text)){
            paneSample.getChildren().remove(text);
        }
        paneSample.getChildren().add(text);
        Rectangle fatherBar = new Rectangle();
        fatherBar.setX(655);
        fatherBar.setY(15);
        fatherBar.setWidth(80);
        fatherBar.setHeight(20);
        fatherBar.setArcWidth(20);
        fatherBar.setArcHeight(20);
        if(paneSample.getChildren().contains(fatherBar)){
            paneSample.getChildren().remove(fatherBar);
        }
        paneSample.getChildren().add(fatherBar);

        progressBar.setX(655);
        progressBar.setY(15);


        progressBar.setHeight(20);
        progressBar.setArcWidth(20);
        progressBar.setArcHeight(20);
        progressBar.setFill(Color.BLUE);
        if(paneSample.getChildren().contains(progressBar)){
            paneSample.getChildren().remove(progressBar);
        }
        paneSample.getChildren().add(progressBar);


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(boss.getLive() < 18){
                    progressBar.setFill(Color.RED);
                }else{
                    progressBar.setFill(Color.BLUE);
                }

                text.setText(Integer.toString(boss.getLive()));
                progressBar.setWidth(((double)boss.getLive() / (double)100) * 80);

            }
        }));
        timeline.setCycleCount(-1);
        timeline.play();
    }

    public void createUsersLiveAndScore(Pane pane){
         score = new Text();
         live = new Text();

        score.setFill(Color.BLACK);
        live.setFill(Color.BLACK);
        score.setX(12);
        score.setY(120);

        live.setX(12);
        live.setY(135);

        pane.getChildren().add(score);
        pane.getChildren().add(live);


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
              live.setText("live :" + cuphead.getLive());
              score.setText("score :" + user.getScore());
            }
        }));
        timeline.setCycleCount(-1);
        timeline.play();


    }



}

