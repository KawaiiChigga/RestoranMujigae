/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.model.order;

import java.time.LocalDateTime;
import restoranmujigae.app.controller.order.OrderCtrl;
import restoranmujigae.app.model.menu.Menu;

public class OrderMenuLine {
    public int id;
    public int qty;
    public double harga;
    private int id_order;
    private int id_menu;
    private LocalDateTime created_at;
    private boolean is_deleted;
    private boolean status;
    private OrderMenu order;
    private Menu menu;

    // Create OrderMenuLine
    public OrderMenuLine(int id, double harga, int qty) {
        this.id = id;
        this.harga = harga;
        this.qty = qty;
    }

// Create OrderMenuLine
    public OrderMenuLine(int qty, double harga, OrderMenu order, Menu menu) {
        this.qty = qty;
        this.harga = harga;
        this.order = order;
        this.menu = menu;
    }

    // Get OrderMenuLine
    public OrderMenuLine(int id, int qty, double harga, int id_order, int id_menu, LocalDateTime created_at, boolean is_deleted, boolean status) {
        this.id = id;
        this.qty = qty;
        this.harga = harga;
        this.id_order = id_order;
        this.id_menu = id_menu;
        this.created_at = created_at;
        this.is_deleted = is_deleted;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public OrderMenu getOrder() {
        return order;
    }

    public void setOrder(OrderMenu order) {
        this.order = order;
    }

    public Menu getMenu() {
        return OrderCtrl.getMenu(id_menu);
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
