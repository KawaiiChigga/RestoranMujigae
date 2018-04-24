/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view.controller;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import restoranmujigae.app.controller.order.OrderCtrl;

public class MenuMainCourCtrl extends MenuCtrl {

    public MenuMainCourCtrl() {
        super();
    }

    //MAINCOURSE
    @FXML
    private void getEggs(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Eggs").get(0));
        
    }

    @FXML
    private void getGrilled(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Grilled Chicken").get(0));
    }

    @FXML
    private void getPene(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Pene").get(0));
    }

    @FXML
    private void getQue(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Quesadilla").get(0));
    }

    @FXML
    private void getPulled(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Pulled Pork").get(0));
    }

    @FXML
    private void getSalmon(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Salmon Style").get(0));
    }

    @FXML
    private void getSch(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Schnitzle Tower").get(0));
    }

    @FXML
    private void getSpaghetti(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Pulled Pork").get(0));
    }
}
