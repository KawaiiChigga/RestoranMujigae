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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import restoranmujigae.app.database.DbSQL;
import restoranmujigae.app.model.menu.Menu;
import restoranmujigae.app.model.order.Pelayan;

public class WaiterCtrl {

    public static boolean loginPelayan(String nama, String pin) {
        boolean result = false;
        Pelayan tmpLogin = null;
        String sql;
        PreparedStatement stm;
        ResultSet rs;
        try {
            DbSQL db = DbSQL.getInstance();
            sql = "select * from waiter WHERE nama = ? and pin = ?";
            stm = db.getCon().prepareStatement(sql);
            stm.setString(1, nama);
            stm.setString(2, pin);
            rs = stm.executeQuery();
            while (rs.next()) {
                result = true;
                tmpLogin = new Pelayan(rs.getInt("id"), rs.getString("nama"), rs.getString("pin"), rs.getBoolean("status"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }


    public static List<Pelayan> getAllWaiter() {
        List<Pelayan> hasil = new ArrayList();
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            sql = "SELECT * FROM waiter";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                hasil.add(
                        new Pelayan(
                                rs.getInt("id"),
                                rs.getString("nama"),
                                rs.getString("pin"),
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

    public static Pelayan getWaiter(int id) {
        Pelayan w = null;
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            sql = "SELECT * FROM waiter WHERE id = " + id;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                w = new Pelayan(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("pin"),
                        rs.getBoolean("status")
                );
            }
            db.logOff();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return w;
    }

}
