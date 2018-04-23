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
import restoranmujigae.app.controller.order.WaiterCtrl;
import restoranmujigae.app.model.order.Pelayan;

public class MejaMenuCtrl {
    
    @FXML
    protected void getAppetizer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Appetizer.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("MUJIGAE");
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.show();
    }
    
    @FXML
    protected void getCallWaiters(ActionEvent event) throws IOException {
        /*Parent root = FXMLLoader.load(getClass().getResource("Waiters.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("MUJIGAE");
        stage.setMaximized(true);
        stage.setResizable(true);
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
        stage.show();
        stage.setFullScreen(true);*/
        System.out.println("Send CallWaiter");
    }
    
    @FXML
    protected void getCheckout(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
        List<String> choices = new ArrayList<>();
        List<Pelayan> listPelayan = WaiterCtrl.getAllWaiter();
        for (Pelayan pelayan : listPelayan) {
            choices.add(pelayan.getNama());
        }

        ChoiceDialog<String> dialog2 = new ChoiceDialog<>(listPelayan.get(0).getNama(), choices);
        dialog2.setTitle("Checkout Bill");
        dialog2.setHeaderText("Waiter");
        dialog2.setContentText("Choose your waiter: ");

        Optional<String> result2 = dialog2.showAndWait();
        if (result2.isPresent()) {
            System.out.println("Your choice: " + result2.get());
        }

        TextInputDialog dialog = new TextInputDialog();
        dialog.setGraphic(null);
        dialog.setTitle("Checkout Bill");
        dialog.setHeaderText("By Waiter");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("PIN:"), 0, 1);
        grid.add(password, 1, 1);

        dialog.getDialogPane().setContent(grid);
        
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            if (WaiterCtrl.loginPelayan(result2.get(), password.getText())){
                System.out.println("Login berhasil");
            } else {
                System.out.println("Bohong!");
            }
        }
    }
}
