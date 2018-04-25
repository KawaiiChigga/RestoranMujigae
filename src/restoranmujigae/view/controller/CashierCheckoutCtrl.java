/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view.controller;

import java.io.IOException;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import restoranmujigae.app.controller.order.OrderCtrl;
import restoranmujigae.app.controller.transaction.TransactionCtrl;
import restoranmujigae.app.model.order.OrderMenu;
import restoranmujigae.app.model.order.OrderMenuLine;
import restoranmujigae.main.Main;
import restoranmujigae.main.MainCashier;

public class CashierCheckoutCtrl {
    @FXML
    private TableColumn cashierName;
    @FXML
    private TableColumn cashierQty;
    @FXML
    private TableColumn cashierPrice;
    @FXML
    private TableView<Wrapper> checkoutTable = new TableView<>();

    private ObservableList<Wrapper> data;
    @FXML
    private TextField totalPrice;
    
    @FXML
    private void initialize() throws Exception {
        cashierName.setCellValueFactory(
                new PropertyValueFactory<Wrapper, String>("nama"));
        cashierPrice.setCellValueFactory(
                new PropertyValueFactory<Wrapper, String>("price"));
        cashierQty.setCellValueFactory(
                new PropertyValueFactory<Wrapper, String>("qty"));
        
        List<OrderMenuLine> cart = OrderCtrl.getCartByMeja(MainCashier.ID_MEJA);
        data = FXCollections.observableArrayList();
        double harga = 0;
        for (OrderMenuLine orderMenuLine : cart) {
            harga += (orderMenuLine.getQty() * orderMenuLine.getHarga());
            data.add(new Wrapper(
                    orderMenuLine.getId(),
                    orderMenuLine.getMenu().getNama(),
                    orderMenuLine.getHarga(),
                    orderMenuLine.getQty(),
                    orderMenuLine.isStatus())
            );
        }
        checkoutTable.setItems(data);
        
        totalPrice.setText(harga + "");
    }
    
    @FXML
    private void checkoutMeja(ActionEvent event) throws IOException {
        OrderMenu om = OrderCtrl.getActiveOrder(MainCashier.ID_MEJA);
        TransactionCtrl.createTransaction(om.getId(), MainCashier.ID_CASHIER);
        OrderCtrl.callCheckout(MainCashier.ID_MEJA, 0);
        OrderCtrl.updateOrderMenuStatus(MainCashier.ID_MEJA);
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Cashier.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("MUJIGAE");
        stage.setMaximized(true);
        stage.setResizable(true);
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
        stage.show();
    }
    
    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/restoranmujigae/view/Cashier.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("MUJIGAE");
        stage.setMaximized(true);
        stage.setResizable(true);
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
        stage.show();
    }
    
    public class Wrapper {

        private int id_orderline;
        private String nama;
        private double price;
        private int qty;
        private boolean status;

        public Wrapper(int id_orderline, String nama, double price, int qty, boolean status) {
            this.id_orderline = id_orderline;
            this.nama = nama;
            this.price = price;
            this.qty = qty;
            this.status = status;
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

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

    }
}
