/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import restoranmujigae.app.controller.data.PropertiesLoader;

public class MainWaiter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PropertiesLoader.initProperties();
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Waiters.fxml"));
        primaryStage.setTitle("MUJIGAE WAITER");
        primaryStage.setMaximized(false);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
