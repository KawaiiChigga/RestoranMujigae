/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.model.order;

public class Meja {
    private int id;
    private String noMeja;
    private boolean status;

    // Create Meja
    public Meja(String noMeja) {
        this.noMeja = noMeja;
    }

    // Get Meja
    public Meja(int id, String noMeja, boolean status) {
        this.id = id;
        this.noMeja = noMeja;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoMeja() {
        return noMeja;
    }

    public void setNoMeja(String noMeja) {
        this.noMeja = noMeja;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}