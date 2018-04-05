/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.controller.order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import restoranmujigae.app.database.DbSQL;
import restoranmujigae.app.model.menu.Menu;
import restoranmujigae.app.model.order.Pelayan;

public class WaiterCtrl {

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
                        rs.getBoolean("status"),
                        rs.getString("pin")
                );
            }
            db.logOff();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return w;
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

    public static boolean createListWaiter(List<Pelayan> list) {
        String sql;
        Statement stm;
        try {
            DbSQL db = DbSQL.getInstance();
            stm = db.getCon().createStatement();
            for (Pelayan pelayan : list) {
                sql = "INSERT INTO waiter (nama, pin) VALUES ("
                        + "'" + pelayan.getNama() + "', "
                        + "'" + pelayan.getPin() + "')";

                stm.executeUpdate(sql);
            }
            db.logOff();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }
}
