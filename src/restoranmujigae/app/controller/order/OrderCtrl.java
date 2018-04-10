/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.controller.order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import restoranmujigae.app.database.DbSQL;
import restoranmujigae.app.model.menu.Menu;
import restoranmujigae.app.model.order.OrderMenu;
import restoranmujigae.app.model.order.OrderMenuLine;

public class OrderCtrl {

    public static Menu getMenu(int id) {
        Menu w = null;
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            sql = "SELECT * FROM menu WHERE id = " + id;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                w = new Menu(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getDouble("harga"),
                        rs.getString("img_url"),
                        rs.getInt("id_kategori"),
                        rs.getBoolean("status")
                );
            }
            db.logOff();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return w;
    }

    public static List<Menu> getMenuByKategori(int id_kategori) {
        List<Menu> hasil = new ArrayList();
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            sql = "SELECT * FROM menu WHERE id_kategori = " + id_kategori + "";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                hasil.add(
                    new Menu(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getDouble("harga"),
                        rs.getString("img_url"),
                        rs.getInt("id_kategori"),
                        rs.getBoolean("status")
                    )
                );
            }
            db.logOff();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return hasil;
    }

    public static List<Menu> searchMenu(String nama) {
        List<Menu> hasil = new ArrayList();
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            sql = "SELECT * FROM menu WHERE nama like '%" + nama + "%'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                hasil.add(
                    new Menu(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getDouble("harga"),
                        rs.getString("img_url"),
                        rs.getInt("id_kategori"),
                        rs.getBoolean("status")
                    )
                );
            }
            db.logOff();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return hasil;
    }

    public static List<OrderMenuLine> getCartByMeja(int id_meja) {
        List<OrderMenuLine> hasil = new ArrayList();
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            sql = "SELECT ol.* "
                    + "FROM order_menu o JOIN order_menu_line ol ON o.id = ol.id_order "
                    + "WHERE o.id_meja = " + id_meja + " AND "
                    + "o.status = 1";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                LocalDateTime created_at = LocalDateTime.parse(rs.getTimestamp("created_at").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
                hasil.add(
                    new OrderMenuLine(
                        rs.getInt("id"), 
                        rs.getInt("qty"), 
                        rs.getDouble("harga"), 
                        rs.getInt("id_order"), 
                        rs.getInt("id_menu"),
                        created_at, 
                        rs.getBoolean("is_deleted")
                    )
                );
            }
            db.logOff();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return hasil;
    }

    public static OrderMenu getActiveOrder(int id_meja) {
        OrderMenu hasil = null;
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            sql = "SELECT * FROM order_menu WHERE id_meja = " + id_meja + " AND "
                    + "status = 1";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                LocalDateTime created_at = LocalDateTime.parse(rs.getTimestamp("created_at").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
                hasil = new OrderMenu(
                    rs.getInt("id"), 
                    rs.getBoolean("status"), 
                    rs.getInt("id_meja"), 
                    rs.getInt("id_waiter"), 
                    created_at, 
                    rs.getBoolean("is_deleted")
                );
            }
            db.logOff();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return hasil;
    }
    
    public static boolean addToCart(int id_meja, List<OrderMenuLine> listMenu) {
        OrderMenu order = OrderCtrl.getActiveOrder(id_meja);
        if (order == null) {
            return false;
        }
        return true;

    }

}
