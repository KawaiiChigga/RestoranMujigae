/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view;

import javafx.fxml.FXML;

/**
 *
 * @author Kenny
 */
public class MenuController {
    @FXML
    private void getAppetizer(){
        System.out.println("Return Appetizer");
    }
    
    @FXML
    private void getMainCourse(){
        System.out.println("Return Main Course");
    }
    
    @FXML
    private void getDrinks(){
        System.out.println("Return Drink");
    }
    
    @FXML
    private void getMyOrder(){
        System.out.println("Return Order");
    }
    
    @FXML
    private void getCallWaiter(){
        System.out.println("Return Notify Waiter");
    }
}
