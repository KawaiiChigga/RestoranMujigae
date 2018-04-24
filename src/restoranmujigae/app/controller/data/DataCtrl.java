/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.controller.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import restoranmujigae.app.database.DbSQL;
import restoranmujigae.app.model.order.Meja;
import restoranmujigae.app.model.order.Pelayan;

public class DataCtrl {
    public static boolean createMeja(Meja meja) {
        boolean status = false;
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "insert into meja (noMeja, status) values (?,?)";
            stm = db.getCon().prepareStatement(sql);
            stm.setString(1, meja.getNoMeja());
            stm.setBoolean(2, true);
            int hasil = stm.executeUpdate();
            if (hasil > 0) {
                status = true;
            }
            System.out.println(hasil + " row(s) effected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static boolean createMenu(int id, String nama, double harga, String img_url, int id_kat, String deskripsi) {
        boolean status = false;
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "insert into menu (id,nama,harga,img_url,id_kategori,deskripsi) values (?,?,?,?,?,?)";
            stm = db.getCon().prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, nama);
            stm.setDouble(3, harga);
            stm.setString(4, img_url);
            stm.setInt(5, id_kat);
            stm.setString(6, deskripsi);
            int hasil = stm.executeUpdate();
            if (hasil > 0) {
                status = true;
            }
            System.out.println(hasil + " row(s) effected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static boolean createKategori(int id, String nama, boolean status) {
        boolean stat = false;
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "insert into kategori (id, nama, status) values (?,?,?)";
            stm = db.getCon().prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, nama);
            stm.setBoolean(3, true);
            int hasil = stm.executeUpdate();
            if (hasil > 0) {
                stat = true;
            }
            System.out.println(hasil + " row(s) effected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stat;
    }
    
    public static boolean createWaiter(Pelayan pelayan) {
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            sql = "INSERT INTO waiter (nama, pin) VALUES ("
                    + "'" + pelayan.getNama() + "', "
                    + "'" + pelayan.getPin() + "')";
            stm.executeUpdate(sql);
            db.logOff();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

}
