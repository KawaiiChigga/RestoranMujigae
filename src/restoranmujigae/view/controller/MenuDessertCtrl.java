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

public class MenuDessertCtrl extends MenuCtrl {
    public MenuDessertCtrl() {
        super();
    }
    
    @FXML
    private void getBanana(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Banana").get(0));
    }

    @FXML
    private void getCake(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Cake Berries").get(0));
    }

    @FXML
    private void getClassic(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Classic Ice Cream").get(0));
    }

    @FXML
    private void getFruit(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Fruit Salad").get(0));
    }

    @FXML
    private void getChoco(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Choco Cookies").get(0));
    }

    @FXML
    private void getOreo(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Oreo Cake").get(0));
    }

    @FXML
    private void getPan(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Pan - Cake").get(0));
    }

    @FXML
    private void getShortcake(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Short Cake").get(0));
    }
}
