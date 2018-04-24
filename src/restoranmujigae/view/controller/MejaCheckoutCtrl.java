/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import restoranmujigae.app.controller.order.OrderCtrl;
import restoranmujigae.app.model.order.OrderMenuLine;
import restoranmujigae.app.model.menu.Menu;
import restoranmujigae.main.Main;

public class MejaCheckoutCtrl {

    @FXML
    private TableColumn cashierName;
    @FXML
    private TableColumn cashierPrice;
    @FXML
    private TableColumn cashierQty;
    @FXML
    private TableView<Wrapper> checkoutTable = new TableView<>();
    @FXML
    private TextField totalPrice;

    private ObservableList<Wrapper> data;
//    private final ObservableList<OrderMenuLine> data
//            = FXCollections.observableArrayList(
//                    new OrderMenuLine(1, 5000, 5),
//                    new OrderMenuLine(2, 12000, 4)
//            );

    @FXML
    private void initialize() throws Exception {
        double total = 0;
        cashierName.setCellValueFactory(
                new PropertyValueFactory<Wrapper, String>("nama"));
        cashierPrice.setCellValueFactory(
                new PropertyValueFactory<Wrapper, String>("price"));
        cashierQty.setCellValueFactory(
                new PropertyValueFactory<Wrapper, String>("qty"));

        List<OrderMenuLine> cart = OrderCtrl.getCartByMeja(Main.ID_MEJA);
        data = FXCollections.observableArrayList();
        for (OrderMenuLine orderMenuLine : cart) {
            System.out.println(orderMenuLine.getMenu().getNama());
            data.add(new Wrapper(
                    orderMenuLine.getId(), 
                    orderMenuLine.getMenu().getNama(), 
                    orderMenuLine.getHarga(),
                    orderMenuLine.getQty())
            );
            total += orderMenuLine.getHarga();
        }
//
        checkoutTable.setItems(data);
        
        totalPrice.setText(total + "");
    }

    public MejaCheckoutCtrl() {

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
    protected void getCheckout(ActionEvent event) throws IOException {

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
