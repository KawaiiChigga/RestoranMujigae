/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.controller.transaction;

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
import restoranmujigae.app.model.order.OrderMenu;
import restoranmujigae.app.model.order.OrderMenuLine;

/**
 *
 * @author Richard
 */
public class TransactionCtrl {
    
    public static boolean createTransaction(int id_order, int id_cashier)
    {
        boolean status = false;
        String sql;
        PreparedStatement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "insert into transaction (id_order,id_cashier) values (?,?)";
            stm = db.getCon().prepareStatement(sql);
            stm.setInt(1, id_order);
            stm.setInt(2, id_cashier);
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

    
     public static List<OrderMenuLine> getTransactionByMeja(int id_meja) {
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
    
}
