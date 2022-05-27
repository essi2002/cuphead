package com.example.cuphead;

import com.example.cuphead.Model.Boss;
import com.example.cuphead.Model.CupHead;
import com.example.cuphead.Model.Database;
import com.example.cuphead.Model.User;
import com.example.cuphead.View.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class Main extends Application{
    private static Scene scene;
    public static MediaPlayer media;
    public static Database database = new Database();
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        media = new MediaPlayer(new Media(Main.class.getResource("MenuMusic.mp3").toURI().toString()));
        media.setCycleCount(MediaPlayer.INDEFINITE);
        media.play();

        loginMenu.setUp();
        URL address_login_page = new URL(Main.class.getResource("loginMenuFxml.fxml").toString());
        Parent root = FXMLLoader.load(address_login_page);
        Scene scene = new Scene(root);
        Main.scene = scene;
        stage.setScene(scene);
        stage.show();

    }
    public static void changeToLoginMenu() throws IOException {
        loginMenu.setUp();
        Parent root = getFxml("loginMenuFxml.fxml");
        Main.scene.setRoot(root);
    }
    public static void changeToMainMenu(User user) throws IOException {
        mainMenu.setUp(user);
        Parent root = getFxml("mainMenuFXML.fxml");
        Main.scene.setRoot(root);
    }
    public static void changeToScoreBoardMenu(User user){
        scoreBoard.setUp(user);
        Parent root = getFxml("ScoreFXML.fxml");
        Main.scene.setRoot(root);
    }

    public static void changeToProfileMenu(User user){
        Profile.setUp(user);
        Parent root = getFxml("profileMenuFxml.fxml");
        Main.scene.setRoot(root);
    }
    public static void changeToAvatarMenu(User user){
        Avatar.setUp(user);
        Parent root = getFxml("AvatarFxml.fxml");
        Main.scene.setRoot(root);
    }
    public static void changeToGame(User user) throws IOException, URISyntaxException {
        media = new MediaPlayer(new Media(Main.class.getResource("Game.mp3").toURI().toString()));
        media.play();
        GameMenu.setUp(user);
      //  GameMenu.controller.createBullet();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("GameFxml.fxml"));
        Parent root = loader.load();
        GameMenu game = loader.getController();

        Main.scene.setRoot(root);
        game.cupHeadMove();



    }

    public static void changeToFinishedMenu(Boss boss, User user, CupHead cuphead) throws IOException {
        GameMenuFinished.setUp(boss,user,cuphead);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("FinishedLiveFxml.fxml"));
        Parent root = loader.load();
       GameMenuFinished controller = loader.getController();
        controller.setRectangle();
        Main.scene.setRoot(root);



    }
    private static Parent getFxml(String name){
        try {
            URL addressMain = new URL(Main.class.getResource(name).toExternalForm());
            return FXMLLoader.load(addressMain);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}