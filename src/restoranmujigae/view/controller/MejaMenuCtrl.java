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

public class MejaMenuCtrl {
    
    @FXML
    private void getStart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Start.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("MUJIGAE");
        stage.setMaximized(true);
        stage.setResizable(true);
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
        stage.show();
        stage.setFullScreen(true);
    }
    
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
        
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Checkout.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("MUJIGAE");
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.show();
        /* WOI INI SALAH GLENN!!!!!!!
        System.out.println("Send Checkout");
        List<String> choices = new ArrayList<>();
        choices.add("Waiter 1");
        choices.add("Waiter 2");
        choices.add("Waiter 3");

        ChoiceDialog<String> dialog2 = new ChoiceDialog<>("Waiter 1", choices);
        dialog2.setTitle("Checkout Bill");
        dialog2.setHeaderText("Waiter");
        dialog2.setContentText("Choose your waiter:");

        // Traditional way to get the response value.
        Optional<String> result2 = dialog2.showAndWait();
        if (result2.isPresent()) {
            System.out.println("Your choice: " + result2.get());
        }

//        PasswordField password = new PasswordField();
//        password.setPromptText("Password");
        TextInputDialog dialog = new TextInputDialog();
        dialog.setGraphic(null);
        dialog.setTitle("Checkout Bill");
        dialog.setHeaderText("By Waiter");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

//        TextField username = new TextField();
//        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

//        grid.add(new Label("Username:"), 0, 0);
//        grid.add(username, 1, 0);
        grid.add(new Label("PIN:"), 0, 1);
        grid.add(password, 1, 1);

        dialog.getDialogPane().setContent(grid);
        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("PIN: " + password.getText());
        }
        */
    }
}
