/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.view.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import restoranmujigae.app.controller.order.OrderCtrl;
import restoranmujigae.app.controller.order.WaiterCtrl;
import restoranmujigae.app.model.order.OrderMenu;
import restoranmujigae.app.model.order.OrderMenuLine;
import restoranmujigae.app.model.order.Pelayan;
import restoranmujigae.main.Main;
import static restoranmujigae.view.controller.MenuCtrl.qty;

public class MenuOrderCtrl extends MenuCtrl {

    static int qty;

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

        refresh();

        orderTable.setRowFactory(tv -> {
            TableRow<Wrapper> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Wrapper clickedRow = row.getItem();

                    if (!clickedRow.isStatus()) {
                        OrderMenuLine om = OrderCtrl.getOrderMenuLine(clickedRow.getId_orderline());
                        qty = om.getQty();
                        TextInputDialog dialog = new TextInputDialog("" + qty);
                        dialog.setGraphic(null);
                        dialog.setTitle("Input Quantity");
                        dialog.setHeaderText(om.getMenu().getNama());
                        dialog.setContentText("Please enter quantity:");

                        GridPane grid = new GridPane();
                        grid.setHgap(5);
                        grid.setVgap(1);
                        grid.setPadding(new Insets(20, 150, 10, 10));

                        Button min = new Button("-");
                        TextField field_qty = new TextField("" + qty);
                        Button plus = new Button("+");
                        Button delete = new Button("Delete");
                        delete.setStyle("-fx-background-color:#d9534f");
                        delete.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                OrderCtrl.updateOrderMenuLine(om.getId(), true, qty);
                                dialog.close();
                                refresh();
                            }
                        });

                        min.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                if (qty <= 1) {
                                    qty = 1;
                                } else {
                                    qty--;
                                }
                                field_qty.setText("" + qty);
                                grid.getChildren().remove(field_qty);
                                grid.add(field_qty, 1, 1);
                                dialog.getDialogPane().setContent(grid);
                            }
                        });

                        plus.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                qty++;
                                field_qty.setText("" + qty);
                                grid.getChildren().remove(field_qty);
                                grid.add(field_qty, 1, 1);
                                dialog.getDialogPane().setContent(grid);
                            }
                        });

                        grid.add(min, 0, 1);
                        grid.add(field_qty, 1, 1);
                        grid.add(plus, 2, 1);
                        grid.add(delete, 4, 1);

                        dialog.getDialogPane().setContent(grid);

                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()) {
                            OrderCtrl.updateOrderMenuLine(om.getId(), false, qty);
                            refresh();
                        }
                    }
                }
            });
            return row;
        });
//        orderTable.setItems(data);
    }

    private void refresh() {
        List<OrderMenuLine> cart = OrderCtrl.getCartByMeja(Main.ID_MEJA);
        data = FXCollections.observableArrayList();
        for (OrderMenuLine orderMenuLine : cart) {
            data.add(new Wrapper(
                    orderMenuLine.getId(),
                    orderMenuLine.getMenu().getNama(),
                    orderMenuLine.getHarga(),
                    orderMenuLine.getQty(),
                    orderMenuLine.isStatus())
            );
        }
        orderTable.setItems(data);
    }

    @FXML
    private void getConfirmOrder(ActionEvent event) throws IOException {
        OrderCtrl.callWaiter(Main.ID_MEJA, 1);
        validate.setVisible(true);
    }

    @FXML
    private void getValidate(ActionEvent event) throws IOException {
        OrderCtrl.callWaiter(Main.ID_MEJA, 0);
        
        List<String> choices = new ArrayList<>();
        List<Pelayan> listPelayan = WaiterCtrl.getAllWaiter();
        for (Pelayan pelayan : listPelayan) {
            choices.add(pelayan.getNama());
        }

        ChoiceDialog<String> dialog2 = new ChoiceDialog<>(listPelayan.get(0).getNama(), choices);
        dialog2.setTitle("Checkout Bill");
        dialog2.setHeaderText("Waiter");
        dialog2.setContentText("Choose your waiter: ");
        dialog2.initStyle(StageStyle.UNDECORATED);

        Optional<String> result2 = dialog2.showAndWait();
        if (result2.isPresent()) {
            boolean cancel = false;
            while (!cancel) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setGraphic(null);
                dialog.setTitle("Checkout Bill");
                dialog.setHeaderText("By Waiter");
                dialog.initStyle(StageStyle.UNDECORATED);

                GridPane grid = new GridPane();
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(20, 150, 10, 10));

                PasswordField password = new PasswordField();
                password.setPromptText("Password");

                grid.add(new Label("PIN:"), 0, 1);
                grid.add(password, 1, 1);

                dialog.getDialogPane().setContent(grid);

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    if (WaiterCtrl.loginPelayan(result2.get(), password.getText())) {
                        OrderCtrl.updateOrderMenuLineStatus(Main.ID_MEJA);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Validated!");
                        alert.setContentText("Please wait! Your order are being prepared");

                        alert.showAndWait();
                        cancel = true;
                    }
                } else {
                    cancel = true;
                }
            }
        }

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
