/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.controller.transaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import restoranmujigae.app.database.DbSQL;
import restoranmujigae.app.model.order.OrderMenu;
import restoranmujigae.app.model.order.Pelayan;

public class CashierCtrl {
    
    public static boolean createTransaction (int id_order, int id_cashier) {
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
}
