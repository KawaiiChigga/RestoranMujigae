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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import restoranmujigae.app.model.menu.Menu;

public class MenuCtrl {
    protected void orderMenu(Menu menu) {
        TextInputDialog dialog = new TextInputDialog("1");
        dialog.setGraphic(null);
        dialog.setTitle("Input Quantity");
        dialog.setHeaderText("Ordering " + menu.getNama());
        dialog.setContentText("Please enter quantity:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
//            System.out.println("Egg Quantity: " + result.get());
        }
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
    protected void getMainCourse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Maincourse.fxml"));
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
    protected void getDrinks(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Drinks.fxml"));
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
    protected void getDesserts(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Desserts.fxml"));
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
    protected void getMyOrder(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/MyOrder.fxml"));
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
    protected void getStart(ActionEvent event) throws IOException {
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
}
