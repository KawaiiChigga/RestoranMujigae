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
        String nama = OrderCtrl.searchMenu("Eggs").get(0).getNama();
        System.out.println(nama);
        orderMenu(OrderCtrl.searchMenu("Eggs").get(0));
    }

    @FXML
    private void getGrilled(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with Custom Actions");
        alert.setHeaderText("Look, a Confirmation Dialog with Custom Actions");
        alert.setContentText("Choose your option.");
        Label label = new Label("The exception stacktrace was:");
        ButtonType buttonTypeOne = new ButtonType("-");
        ButtonType buttonTypeTwo = new ButtonType("+");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            // ... user chose "One"
        } else if (result.get() == buttonTypeTwo) {
            // ... user chose "Two"
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @FXML
    private void getPene(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }
 
    @FXML
    private void getQue(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getPulled(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getSalmon(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getSch(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getSpaghetti(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }
}
