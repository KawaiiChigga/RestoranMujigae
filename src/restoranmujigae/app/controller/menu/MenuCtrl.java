package restoranmujigae.app.controller.menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import restoranmujigae.app.database.DbSQL;

public class MenuCtrl {

//    public static List<Menu> getAllMenu() throws SQLException {
//        List<Menu> list = new LinkedList();
//        DBConnector conn = new DBConnector();
//        conn.connect();
//        Statement stm = conn.con.createStatement();
//        ResultSet hasil = stm.executeQuery("SELECT * FROM menu");
//        while (hasil.next()) {
//            Menu menu = new Menu(
//                hasil.getInt("id"), 
//                hasil.getString("nama"),
//                hasil.getDouble("harga"), 
//                hasil.getBoolean("status")
//            );
//            list.add(menu);
//        }
//        conn.disconnect();
//        return list;
//    }

}
