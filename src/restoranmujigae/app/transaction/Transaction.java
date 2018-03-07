/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.transaction;

import java.sql.Timestamp;
import restoranmujigae.app.order.OrderMenu;

public class Transaction {
    private int id;
    private Timestamp tanggal;
    private int id_order;
    private int id_cashier;
    private Timestamp created_at;
    private boolean is_deleted;
    private OrderMenu order;
    private Cashier cashier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTanggal() {
        return tanggal;
    }

    public void setTanggal(Timestamp tanggal) {
        this.tanggal = tanggal;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_cashier() {
        return id_cashier;
    }

    public void setId_cashier(int id_cashier) {
        this.id_cashier = id_cashier;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
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

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
    
    
}
