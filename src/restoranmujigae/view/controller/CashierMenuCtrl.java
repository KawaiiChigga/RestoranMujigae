/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import restoranmujigae.app.controller.data.DataCtrl;
import restoranmujigae.app.model.order.Meja;

public class CashierMenuCtrl {
    
    @FXML
    private Button meja1;
    @FXML
    private Button meja2;
    @FXML
    private Button meja3;
    @FXML
    private Button meja4;
    @FXML
    private Button meja5;
    @FXML
    private Button meja6;
    @FXML
    private Button meja7;
    @FXML
    private Button meja8;
    @FXML
    private Button meja9;
    @FXML
    private Button meja10;
    @FXML
    private Button meja11;
    @FXML
    private Button meja12;
    
    @FXML
    private void initialize() throws Exception {
        refresh();
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                refresh();
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
    }
    
    @FXML
    protected void getRefresh(ActionEvent event) throws IOException {
        refresh();
    }
    
    public void refresh() {
        List<Meja> temp = DataCtrl.getAllAvailableMeja();
        for (int i = 0; i < temp.size(); i++) {
            boolean call = temp.get(i).isCallcheckout();
            switch (i) {
                case 0: setColor(meja1, call); break;
                case 1: setColor(meja2, call); break;
                case 2: setColor(meja3, call); break;
                case 3: setColor(meja4, call); break;
                case 4: setColor(meja5, call); break;
                case 5: setColor(meja6, call); break;
                case 6: setColor(meja7, call); break;
                case 7: setColor(meja8, call); break;
                case 8: setColor(meja9, call); break;
                case 9: setColor(meja10, call); break;
                case 10: setColor(meja11, call); break;
                case 11: setColor(meja12, call); break;
            }
        }
    }

    public void setColor(Button target, boolean call) {
        if (call) {
            target.setStyle("-fx-background-color:#d9534f");
        } else {
            target.setStyle("-fx-background-color:#90caf9");
        }
    }
    
}
