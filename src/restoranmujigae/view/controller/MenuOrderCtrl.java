/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import restoranmujigae.app.model.order.OrderMenuLine;

public class MenuOrderCtrl extends MenuCtrl {

    @FXML
    private TableColumn orderName;
    @FXML
    private TableColumn orderPrice;
    @FXML
    private TableColumn orderQty;
    @FXML
    private TableView<OrderMenuLine> orderTable = new TableView<>();

    private final ObservableList<OrderMenuLine> data
            = FXCollections.observableArrayList(
                    new OrderMenuLine(1, 5000, 5),
                    new OrderMenuLine(2, 12000, 4)
            );

    public MenuOrderCtrl() {
        super();
    }

    @FXML
    private void initialize() throws Exception {
        orderName.setCellValueFactory(
                new PropertyValueFactory<OrderMenuLine, String>("id"));
        orderPrice.setCellValueFactory(
                new PropertyValueFactory<OrderMenuLine, String>("harga"));
        orderQty.setCellValueFactory(
                new PropertyValueFactory<OrderMenuLine, String>("qty"));
        orderTable.setItems(data);
    }
}
