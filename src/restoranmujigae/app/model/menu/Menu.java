/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.model.menu;

public class Menu {
    private int id;
    private String nama;
    private double harga;
    private String img_url;
    private int id_kategori;
    private boolean status;
    private Kategori kategori;
    private String deskripsi;

    public Menu(String nama, double harga, int id_kategori, boolean status, String deskripsi){
        this.nama = nama;
        this.harga = harga;
        this.id_kategori = id_kategori;
        this.status = status;
        this.deskripsi = deskripsi;
    }

    public Menu(int id, String nama, double harga, String img_url, int id_kategori, boolean status, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.img_url = img_url;
        this.id_kategori = id_kategori;
        this.status = status;
        this.deskripsi = deskripsi;
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

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    
    
}
