/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Glenn Hizkia Naftali
 */
public class MenuController {

    @FXML
    private void getAppetizer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Appetizer.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("MUJIGAE");
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    private void getMainCourse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Maincourse.fxml"));
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
    private void getDrinks(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Drinks.fxml"));
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
    private void getDesserts(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Desserts.fxml"));
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

//    @FXML
//    private void getCallWaiters() {
//        System.out.println("Notify Waiter!");
//    }
    @FXML
    private void getCallWaiters(ActionEvent event) throws IOException {
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
    private void getMyOrder(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MyOrder.fxml"));
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
    private void getStart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
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
    private void getCheckout(ActionEvent event) throws IOException {
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
    }

    //MAINCOURSE
    @FXML
    private void getEggs(ActionEvent event) throws IOException {
        TextInputDialog dialog = new TextInputDialog("1");
        dialog.setGraphic(null);
        dialog.setTitle("Input Quantity");
        dialog.setHeaderText("Ordering Eggs");
        dialog.setContentText("Please enter quantity:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Egg Quantity: " + result.get());
        }
    }

    @FXML
    private void getGrilled(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with Custom Actions");
        alert.setHeaderText("Look, a Confirmation Dialog with Custom Actions");
        alert.setContentText("Choose your option.");
Label label = new Label("The exception stacktrace was:");
        ButtonType buttonTypeOne = new ButtonType("-");
        ButtonType buttonTypeTwo = new ButtonType("+");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            // ... user chose "One"
        } else if (result.get() == buttonTypeTwo) {
            // ... user chose "Two"
        }  else {
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

    //DESSERTS
    @FXML
    private void getBanana(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getCake(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getClassic(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getFruit(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getChoco(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getOreo(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getPan(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getShortcake(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    //APPETIZER
    @FXML
    private void getBacon(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getCari(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getFeta(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getWings(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getSavory(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getTurnip(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getTaco(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getVegetable(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    //APPETIZER
    @FXML
    private void getCoke(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getCute(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getIceCoffee(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getJuice(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getChocoMilkshake(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getOrange(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getPineapple(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }

    @FXML
    private void getSexy(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }
}
