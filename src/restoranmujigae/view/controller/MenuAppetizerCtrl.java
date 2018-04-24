/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import restoranmujigae.app.controller.order.OrderCtrl;

public class MenuAppetizerCtrl extends MenuCtrl {

    public MenuAppetizerCtrl() {
        super();
    }
    
    //APPETIZER
    @FXML
    private void getBacon(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Bacon").get(0));
    }

    @FXML
    private void getCari(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Caribbean").get(0));
    }

    @FXML
    private void getFeta(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Feta").get(0));
    }

    @FXML
    private void getWings(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Grilled Chicken Wings").get(0));
    }

    @FXML
    private void getSavory(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Savory").get(0));
    }

    @FXML
    private void getTurnip(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Turnip").get(0));
    }

    @FXML
    private void getTaco(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Taco").get(0));
    }

    @FXML
    private void getVegetable(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Vegetable").get(0));
    }
}
