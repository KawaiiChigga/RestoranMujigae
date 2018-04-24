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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import restoranmujigae.app.controller.order.OrderCtrl;
import restoranmujigae.main.Main;

public class CallMenuCtrl extends MejaMenuCtrl {
    
    public CallMenuCtrl() {
        super();
    }
    
    @FXML
    private void initialize(){
        OrderCtrl.callWaiter(Main.ID_MEJA, 1);
    }
    
    @FXML
    protected void getCancel(ActionEvent event) throws IOException {
        OrderCtrl.callWaiter(Main.ID_MEJA, 0);
        getStart(event);
    }
}
