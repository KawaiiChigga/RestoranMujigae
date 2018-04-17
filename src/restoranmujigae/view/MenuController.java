/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Glenn Hizkia Naftali
 */
public class MenuController {

    @FXML
    private void getAppetizer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Desserts.fxml"));
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
    }
    
    //MAINCOURSE
    
    @FXML
    private void getEggs(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
    }
    @FXML
    private void getGrilled(ActionEvent event) throws IOException {
        System.out.println("Send Checkout");
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

}
