/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<String> choices = new ArrayList<>();
        choices.add("Table 1");
        choices.add("Table 2");
        choices.add("Table 3");
        choices.add("Table 4");
        choices.add("Table 5");
        choices.add("Table 6");
        choices.add("Table 7");
        choices.add("Table 8");
        choices.add("Table 9");
        choices.add("Table 10");
        choices.add("Table 11");
        choices.add("Table 12");
        
        ChoiceDialog<String> dialog2 = new ChoiceDialog<>("Table 1", choices);
        dialog2.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true);
        dialog2.setGraphic(null);
        dialog2.setTitle("Table Selection");
        dialog2.setHeaderText("Table");
        dialog2.setContentText("Choose table number :");

        // Traditional way to get the response value.
        Optional<String> result2 = dialog2.showAndWait();
        if (result2.isPresent()) {
            System.out.println("Your choice: " + result2.get());
        }
        
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Start.fxml"));
        primaryStage.setTitle("MUJIGAE");
        primaryStage.setMaximized(false);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    
}
