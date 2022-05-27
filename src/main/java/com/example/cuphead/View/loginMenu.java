package com.example.cuphead.View;

import com.example.cuphead.Controller.loginMenuController;
import com.example.cuphead.Controller.saveData;
import com.example.cuphead.Main;
import com.example.cuphead.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URISyntaxException;


public  class loginMenu{

    @FXML
    private Button registerButton;
    @FXML
    private TextField password;
    @FXML
    private TextField username;


    private static loginMenuController controller;


    public static void setUp()  {
        controller = new loginMenuController(Main.database);

    }

    public void typePassword(KeyEvent keyEvent) {
        int length = password.getText().length();
        if(length < 8){
            registerButton.setDisable(true);
            password.setStyle("-fx-border-color: red;");

        }

        else{
            password.setStyle("-fx-border-width: 0");
            registerButton.setDisable(false);
        }

    }

    public void registerProgress(MouseEvent mouseEvent) throws IOException {
        String checkUsername = username.getText();
        String checkPassword = password.getText();
        int caseRegister = controller.registerControll(checkUsername,checkPassword);
        switch(caseRegister){
            case 1:
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("weak password");
                alert.show();
                break;
            case -1:
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setContentText("Repetitious username or password");
                alert1.show();
                break;
            case 0:
                User user = new User(checkUsername,checkPassword);
                Main.database.addUser(user);
                Main.changeToMainMenu(user);
                break;
        }
    }


    public void loginProgress(MouseEvent mouseEvent) throws IOException {
        saveData save = new saveData(null,Main.database);
        save.loadUsers();
        String checkUsername = username.getText();
        String checkPassword = password.getText();
        User login = controller.CanLogin(checkUsername,checkPassword);
        if (login != null) {
            Main.changeToMainMenu(login);
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("wrong username or password");
            alert.show();
        }
    }

    public void skip(MouseEvent mouseEvent) throws IOException, URISyntaxException {
        Main.changeToGame(null);
    }
}