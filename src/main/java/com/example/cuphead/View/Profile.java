package com.example.cuphead.View;

import com.example.cuphead.Controller.ProfileController;
import com.example.cuphead.Main;
import com.example.cuphead.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Profile {
    private static ProfileController controller;
    private static User user;
    public Button changeButton;
    @FXML
    private TextField newUsername;
    @FXML
    private TextField newPassword;

    public static void setUp(User use){
        controller = new ProfileController(Main.database);
        user = use;
    }
    

    public void changAccount(MouseEvent mouseEvent) {
        String username = newUsername.getText();
        String password = newPassword.getText();

        if(controller.canChangePassword(user,password) && controller.canChangeUsername(user,username)){
            controller.changePassword(user,password);
            controller.chaneUsername(user,username);
        }else{
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setContentText("wrong newPassword or newUsername");
            alert1.show();
        }
    }

    public void deleteAccount(MouseEvent mouseEvent) throws IOException {
        Main.database.getUsers().remove(user);
        Main.changeToLoginMenu();
    }

    public void ExitAccount(MouseEvent mouseEvent) throws IOException {
        Main.changeToLoginMenu();
    }

    public void Avatar(MouseEvent mouseEvent) {
        Main.changeToAvatarMenu(user);
    }

    public void usernameTyped(KeyEvent keyEvent) {
        int length = newUsername.getText().length();
        if(length < 3){
            changeButton.setDisable(true);
            newUsername.setStyle("-fx-border-color: red;");

        }

        else{
            newUsername.setStyle("-fx-border-width: 0");
            changeButton.setDisable(false);
        }
    }

    public void passwordTyped(KeyEvent keyEvent) {
        int length = newPassword.getText().length();
        if(length < 8){
            changeButton.setDisable(true);
            newPassword.setStyle("-fx-border-color: red;");

        }

        else{
            newPassword.setStyle("-fx-border-width: 0");
            changeButton.setDisable(false);
        }
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.changeToMainMenu(user);
    }
}
