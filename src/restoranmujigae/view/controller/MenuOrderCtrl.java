/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view.controller;

import java.util.List;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import restoranmujigae.app.controller.order.OrderCtrl;
import restoranmujigae.app.model.order.OrderMenuLine;
import restoranmujigae.main.Main;

public class MenuOrderCtrl extends MenuCtrl {

    @FXML
    private TableColumn orderName;
    @FXML
    private TableColumn orderPrice;
    @FXML
    private TableColumn orderQty;
    @FXML
    private TableView<Wrapper> orderTable = new TableView<>();
    @FXML
    private Button validate;

    private ObservableList<Wrapper> data;

    public MenuOrderCtrl() {
        super();
    }

    @FXML
    private void initialize() throws Exception {
        orderName.setCellValueFactory(
                new PropertyValueFactory<Wrapper, String>("nama"));
        orderPrice.setCellValueFactory(
                new PropertyValueFactory<Wrapper, String>("price"));
        orderQty.setCellValueFactory(
                new PropertyValueFactory<Wrapper, String>("qty"));
        
        List<OrderMenuLine> cart = OrderCtrl.getCartByMeja(Main.ID_MEJA);
        data = FXCollections.observableArrayList();
        for (OrderMenuLine orderMenuLine : cart) {
            data.add(new Wrapper(
                    orderMenuLine.getId(), 
                    orderMenuLine.getMenu().getNama(), 
                    orderMenuLine.getHarga(),
                    orderMenuLine.getQty())
            );
        }
        orderTable.setItems(data);
//        orderTable.setItems(data);
    }
    
    @FXML
    private void getConfirm(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void getValidate(ActionEvent event) throws IOException {
        
    }
    
    public class Wrapper {
        private int id_orderline;
        private String nama;
        private double price;
        private int qty;

        public Wrapper(int id_orderline, String nama, double price, int qty) {
            this.id_orderline = id_orderline;
            this.nama = nama;
            this.price = price;
            this.qty = qty;
        }

        public int getId_orderline() {
            return id_orderline;
        }

        public void setId_orderline(int id_orderline) {
            this.id_orderline = id_orderline;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }
        
        
    }
}
