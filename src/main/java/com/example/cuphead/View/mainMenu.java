package com.example.cuphead.View;

import com.example.cuphead.Controller.mainMenuController;
import com.example.cuphead.Main;
import com.example.cuphead.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URISyntaxException;

public class mainMenu {

    private static mainMenuController controller;
    private static User user;
    @FXML
    private Button newGameButton;
    @FXML
    private Button continueButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button scoreboardButton;
    @FXML
    private Button exitButton;


    public static void setUp(User use)  {
        controller = new mainMenuController(Main.database);
        user = use;

    }

    public void initialize()  {

    }

    public void newGame(MouseEvent mouseEvent) throws IOException, URISyntaxException {
        Main.changeToGame(user);
    }

    public void continueGame(MouseEvent mouseEvent) {
    }

    public void profileButton(MouseEvent mouseEvent) {
        Main.changeToProfileMenu(user);
    }

    public void scoreBoardButton(MouseEvent mouseEvent) {
            Main.changeToScoreBoardMenu(user);
    }

    public void exitButton(MouseEvent mouseEvent) {
        System.exit(0);
    }
}
