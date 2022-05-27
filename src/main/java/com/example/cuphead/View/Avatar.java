package com.example.cuphead.View;

import com.example.cuphead.Controller.AvatarController;
import com.example.cuphead.Main;
import com.example.cuphead.Model.User;
import javafx.fxml.FXML;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Avatar {
    @FXML
    private AnchorPane anchore;
    @FXML
    private Circle myCircleView;


    private static User user;
    private static AvatarController controller;

    public static void setUp(User use){
        controller = new AvatarController(Main.database);
        user = use;
    }

    public void RandomAvatar(MouseEvent mouseEvent) {
        int remainder = controller.avatarCaseRandom();
        switch(remainder){
            case 0:
                Image image = new Image(Main.class.getResource("avatar1.png").toString());
                myCircleView.setFill(new ImagePattern(image));
                myCircleView.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
                break;
            case 1:
                Image image1 = new Image(Main.class.getResource("avatar2.png").toString());
                myCircleView.setFill(new ImagePattern(image1));
                myCircleView.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
                break;

            case 2:
                Image image2 = new Image(Main.class.getResource("avatar3.png").toString());
                myCircleView.setFill(new ImagePattern(image2));
                myCircleView.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
                break;
            case 3:
                Image image3 = new Image(Main.class.getResource("avatar4.png").toString());
                myCircleView.setFill(new ImagePattern(image3));
                myCircleView.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
                break;
        }

    }


    public void Avatar1(MouseEvent mouseEvent) {
        Image image = new Image(Main.class.getResource("avatar1.png").toString());
        myCircleView.setFill(new ImagePattern(image));
        myCircleView.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
    }

    public void Avatar2(MouseEvent mouseEvent) {
        Image image1 = new Image(Main.class.getResource("avatar2.png").toString());
        myCircleView.setFill(new ImagePattern(image1));
        myCircleView.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
    }

    public void Avatar3(MouseEvent mouseEvent) {
        Image image2 = new Image(Main.class.getResource("avatar3.png").toString());
        myCircleView.setFill(new ImagePattern(image2));
        myCircleView.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
    }

    public void Avatar4(MouseEvent mouseEvent) {
        Image image3 = new Image(Main.class.getResource("avatar4.png").toString());
        myCircleView.setFill(new ImagePattern(image3));
        myCircleView.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
    }


    public void FileChooser(MouseEvent mouseEvent) {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("choose photo");
        Stage stage = (Stage)anchore.getScene().getWindow();
        File file = filechooser.showOpenDialog(stage);
        if(file != null){
            Image image1 = new Image(file.toURI().toString());
            myCircleView.setFill(new ImagePattern(image1));
            myCircleView.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        }
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.changeToMainMenu(user);
    }
}
