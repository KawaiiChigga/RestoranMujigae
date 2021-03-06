/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.controller.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import restoranmujigae.app.database.DbSQL;
import restoranmujigae.app.model.menu.Menu;
import restoranmujigae.app.model.order.Meja;
import restoranmujigae.app.model.order.OrderMenu;
import restoranmujigae.app.model.order.OrderMenuLine;
import restoranmujigae.app.model.order.Pelayan;

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
                        rs.getBoolean("status"),
                        rs.getString("deskripsi")
                );
            }
            stm.close();
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
                                rs.getBoolean("status"),
                                rs.getString("deskripsi")
                        )
                );
            }
            stm.close();
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
                                rs.getBoolean("status"),
                                rs.getString("deskripsi")
                        )
                );
            }
            stm.close();
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
                    + "o.status = 1 AND ol.is_deleted = 0";
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
                                rs.getBoolean("is_deleted"),
                                rs.getBoolean("status")
                        )
                );
            }
            stm.close();
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
            stm.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return hasil;
    }

    public static boolean createOrderMenu(int id_meja) {
        boolean status = false;
        LocalDateTime ldt = LocalDateTime.now();
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "insert into order_menu (status,id_meja,created_at,is_deleted) values (?,?,?,?)";
            stm = db.getCon().prepareStatement(sql);
            stm.setInt(1, 1);
            stm.setInt(2, id_meja);
            stm.setTimestamp(3, Timestamp.valueOf(ldt));
            stm.setBoolean(4, false);
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

    public static boolean createOrderMenuLine(int qty, double harga, int id_order, int id_menu) {
        boolean status = false;
        LocalDateTime ldt = LocalDateTime.now();
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "insert into order_menu_line (qty,harga,id_order,id_menu,created_at) values (?,?,?,?,?)";
            stm = db.getCon().prepareStatement(sql);
            stm.setInt(1, qty);
            stm.setDouble(2, harga);
            stm.setInt(3, id_order);
            stm.setInt(4, id_menu);
            stm.setTimestamp(5, Timestamp.valueOf(ldt));
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

    public static boolean updateOrderMenuLineStatus(int id_meja) {
        boolean status = false;
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "update meja m join order_menu o on m.id = o.id_meja join order_menu_line om on "
                    + "o.id = om.id_order set om.status = 1 where m.id = ? and o.status = 1 and "
                    + "om.is_deleted = 0";
            stm = db.getCon().prepareStatement(sql);
            stm.setInt(1, id_meja);

            if (stm.executeUpdate() > 0) {
                status = true;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static boolean updateOrderMenuLine(int id_menu_line, boolean delete, int qty) {
        boolean status = false;
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "update order_menu_line set qty = ?, is_deleted = ? where id = ?";
            stm = db.getCon().prepareStatement(sql);
            stm.setInt(1, qty);
            stm.setBoolean(2, delete);
            stm.setInt(3, id_menu_line);

            if (stm.executeUpdate() > 0) {
                status = true;
                System.out.println("sukses");
            } else {
                System.out.println("gagal");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static OrderMenuLine getOrderMenuLine(int id){
        OrderMenuLine om = null;
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            sql = "SELECT * FROM order_menu_line WHERE id = " + id;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                om = new OrderMenuLine(
                        rs.getInt("id"),
                        rs.getInt("qty"),
                        rs.getDouble("harga"),
                        rs.getInt("id_order"),
                        rs.getInt("id_menu"),
                        rs.getBoolean("is_deleted"),
                        rs.getBoolean("status")
                );
            }
            stm.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return om;
    }
    
     public static boolean updateOrderMenuStatus(int id_meja){
        boolean status = false;
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "update order_menu set status = 0 where id_meja = " + id_meja;
            stm = db.getCon().prepareStatement(sql);

            if (stm.executeUpdate() > 0) {
                status = true;
                System.out.println("sukses");
            } else {
                System.out.println("gagal");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static boolean callWaiter(int id, int status)
    {
        boolean result = false;
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "update meja set callwaiter = "+status+" where id = "+id;
            stm = db.getCon().prepareStatement(sql);
            if (stm.executeUpdate() > 0) {
                result = true;
                System.out.println("sukses");
            } else {
                System.out.println("gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static boolean callCheckout(int id, int status)
    {
        boolean result = false;
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "update meja set callcheckout = "+status+" where id = "+id;
            stm = db.getCon().prepareStatement(sql);
            if (stm.executeUpdate() > 0) {
                result = true;
                System.out.println("sukses");
            } else {
                System.out.println("gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
