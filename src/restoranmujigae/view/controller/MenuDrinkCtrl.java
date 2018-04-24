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

public class MenuDrinkCtrl extends MenuCtrl {
    public MenuDrinkCtrl() {
        super();
    }
    
    //DRINKS
    @FXML
    private void getCoke(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Coke").get(0));
    }

    @FXML
    private void getCute(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Cute Pink").get(0));
    }

    @FXML
    private void getIceCoffee(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Ice Coffee").get(0));
    }

    @FXML
    private void getJuice(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Juice (random)").get(0));
    }

    @FXML
    private void getChocoMilkshake(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Choco Milkshake").get(0));
    }

    @FXML
    private void getOrange(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Orange").get(0));
    }

    @FXML
    private void getPineapple(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Pineapple").get(0));
    }

    @FXML
    private void getSexy(ActionEvent event) throws IOException {
        orderMenu(OrderCtrl.searchMenu("Sexy").get(0));
    }
}
