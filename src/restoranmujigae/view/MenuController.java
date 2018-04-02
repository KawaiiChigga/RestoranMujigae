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
public class MenuController{
    @FXML
    private void getBack(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("MUJIGAE");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
        stage.show();
        stage.setFullScreen(true);
    }
    
    @FXML
    private void getAppetizer(){
        System.out.println("Return Appetizer");
        
    }
    
    @FXML
    private void getMainCourse(){
        System.out.println("Return Main Course");
    }
    
    @FXML
    private void getDrinks(ActionEvent event){
        System.out.println("Return Drink");
    }
    
     @FXML
    private void getDesserts(ActionEvent event){
        System.out.println("Return Desserts");
    }
    
      @FXML
    private void getCallWaiters(ActionEvent event){
        System.out.println("Return Desserts");
    }
    
    @FXML
    private void getMyOrder(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MyOrder.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("MUJIGAE");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
        stage.show();
        stage.setFullScreen(true);
    }
    
    @FXML
    private void getCallWaiter(){
        System.out.println("Return Notify Waiter");
    }


}
