package restoranmujigae.app.controller.menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import restoranmujigae.app.database.DbSQL;
import restoranmujigae.app.model.menu.Menu;

public class MenuCtrl {

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

}
