/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.order;

import java.sql.Timestamp;
import restoranmujigae.app.menu.Menu;

public class OrderMenuLine {
    private int id;
    private int qty;
    private int id_order;
    private int id_menu;
    private Timestamp created_at;
    private boolean is_deleted;
    private OrderMenu order;
    private Menu menu;
    
}
