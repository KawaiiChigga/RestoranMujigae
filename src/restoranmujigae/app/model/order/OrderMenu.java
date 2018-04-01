/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.model.order;

import java.time.LocalDateTime;


public class OrderMenu {
    private int id;
    private boolean status;
    private int id_meja;
    private int id_waiter;
    private LocalDateTime created_at;
    private boolean is_deleted;
    private Meja meja;
    private Pelayan waiter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_meja() {
        return id_meja;
    }

    public void setId_meja(int id_meja) {
        this.id_meja = id_meja;
    }

    public int getId_waiter() {
        return id_waiter;
    }

    public void setId_waiter(int id_waiter) {
        this.id_waiter = id_waiter;
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

    public Meja getMeja() {
        return meja;
    }

    public void setMeja(Meja meja) {
        this.meja = meja;
    }

    public Pelayan getWaiter() {
        return waiter;
    }

    public void setWaiter(Pelayan waiter) {
        this.waiter = waiter;
    }
    
    
}
