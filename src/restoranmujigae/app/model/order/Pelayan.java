/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.model.order;

public class Pelayan {
    private int id;
    private String nama;
    private boolean status;
    private String pin;
    
    // Create Pelayan
    public Pelayan(String nama, String pin) {
        this.nama = nama;
        this.pin = pin;
    }

    // Get Pelayan
    public Pelayan(int id, String nama, boolean status, String pin) {
        this.id = id;
        this.nama = nama;
        this.status = status;
        this.pin = pin;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    
    
}
