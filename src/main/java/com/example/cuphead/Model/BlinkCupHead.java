package com.example.cuphead.Model;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class BlinkCupHead extends Transition {
    private CupHead cuphead;

    private boolean addPane;
    private Pane pane;
    public BlinkCupHead(CupHead cuphead,Pane pane){
        this.cuphead = cuphead;
        this.pane = pane;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(1);
        this.addPane = true;
    }

    @Override
    protected void interpolate(double v) {


           if(v >= 0.1 && v < 0.2){
               if(addPane == true){
                   pane.getChildren().add(cuphead);
                   addPane = false;
               }

          }

        else if(v >= 0.3 && v < 0.4){
               if(addPane == true){
                   pane.getChildren().add(cuphead);
                   addPane = false;
               }
        }

        else if(v >= 0.5 && v < 0.6){
               if(addPane == true){
                   pane.getChildren().add(cuphead);
                   addPane = false;
               }
        }

        else if(v >= 0.7 && v < 0.8){
               if(addPane == true){
                   pane.getChildren().add(cuphead);
                   addPane = false;
               }
        }

        else if(v >= 0.9 && v <= 1){
               if(addPane == true){
                   cuphead.setCanCost(true);
                   pane.getChildren().add(cuphead);
                   pane.getChildren().get(pane.getChildren().indexOf(cuphead)).requestFocus();
                   addPane = false;
               }
        }else{
                   pane.getChildren().remove(cuphead);
                   addPane = true;


          }
    }
}
