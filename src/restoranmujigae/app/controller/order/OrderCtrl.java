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
import restoranmujigae.app.database.DbSQL;
import restoranmujigae.app.model.menu.Menu;
import restoranmujigae.app.model.order.OrderMenu;

/**
 *
 * @author Richard
 */
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
     
     public static List<Menu> getMenuByCategory() {
        return null;
    }
     
    public static List<Menu> searchMenu(){
         return null;
        
    }
    
    public static List<OrderMenu> getCartByMeja() {
        return null;
    }
        
    public static void addToCart(){
        
    }
    
    
    
    
}
