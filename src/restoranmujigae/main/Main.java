/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import restoranmujigae.app.controller.data.DataCtrl;
import restoranmujigae.app.model.order.Meja;
import restoranmujigae.app.controller.data.PropertiesLoader;

public class Main extends Application {

    public static int ID_MEJA;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        PropertiesLoader.initProperties();
        Map<String, Integer> map = new LinkedHashMap();
        List<Meja> listMeja = DataCtrl.getAllAvailableMeja();
        for (Meja meja : listMeja) {
            map.put(meja.getNoMeja(), meja.getId());
        }
//        Set<String> choices = map.values();
        ChoiceDialog<String> dialog2 = new ChoiceDialog<>(map.entrySet().iterator().next().getKey(), map.keySet());
        dialog2.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true);
        dialog2.setGraphic(null);
        dialog2.setTitle("Table Selection");
        dialog2.setHeaderText("Table");
        dialog2.setContentText("Choose table number :");

        dialog2.initStyle(StageStyle.UNDECORATED);
        
        // Traditional way to get the response value.
        Optional<String> result2 = dialog2.showAndWait();
        if (result2.isPresent()) {
            Main.ID_MEJA = map.get(dialog2.getSelectedItem());
        }
        
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Start.fxml"));
        primaryStage.setTitle("MUJIGAE");
        primaryStage.setMaximized(false);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    
}
