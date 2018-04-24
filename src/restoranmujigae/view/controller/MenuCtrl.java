/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view.controller;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import restoranmujigae.app.model.menu.Menu;

public class MenuCtrl {

    static int qty;
    
    protected void orderMenu(Menu menu) {
        qty = 1;
        TextInputDialog dialog = new TextInputDialog("" + qty);
        dialog.setGraphic(null);
        dialog.setTitle("Input Quantity");
        dialog.setHeaderText("Ordering " + menu.getNama());
        dialog.setContentText("Please enter quantity:");

        GridPane grid = new GridPane();
        grid.setHgap(3);
        grid.setVgap(1);
        grid.setPadding(new Insets(20, 150, 10, 10));

        Button min = new Button("-");
        TextField field_qty = new TextField("" + qty);
        Button plus = new Button("+");
        
        min.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (qty <= 1) {
                    qty = 1;
                } else {
                    qty--;
                }
                field_qty.setText("" + qty);
                grid.getChildren().remove(field_qty);
                grid.add(field_qty, 1, 1);
                dialog.getDialogPane().setContent(grid);
            }
        });
        
        plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                qty++;
                field_qty.setText("" + qty);
                grid.getChildren().remove(field_qty);
                grid.add(field_qty, 1, 1);
                dialog.getDialogPane().setContent(grid);
            }
        });
        
        grid.add(min, 0, 1);
        grid.add(field_qty, 1, 1);
        grid.add(plus, 2, 1);

        dialog.getDialogPane().setContent(grid);

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();

//        boolean finished = false;

        

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
