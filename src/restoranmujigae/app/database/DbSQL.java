/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DbSQL {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/restoran_mujigae";
    private static String username = "root";
    private static String password = "";

    private static DbSQL db;
    private Connection con = null;

    private DbSQL() {
    }

    public static synchronized DbSQL getInstance() {
        if (db == null) {
            db = new DbSQL();
            try {
                Class.forName(driver).newInstance();
                db.con = DriverManager.getConnection(url, username, password);
            } catch (Exception ex) {
            }
        }
        return db;
    }
    
    public void logOff(){
        try {
            con.close();
        } catch (Exception ex) {
        }
    }

    public Connection getCon() {
        return con;
    }

    public Connection logOn() {
        try {
            // Load JDBC Driver
            Class.forName(driver).newInstance();
            // Buat object Connection
            con = DriverManager.getConnection(url,
                    username, password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error occoured "
                    + "when LogIn" + ex);
        }
        return con;
    }

    

    public void connect() {
        try {
            con = logOn();
        } catch (Exception e) {
            System.out.println("Error occured " + "when connecting to "
                    + "database");
        }
    }

    public void disconnect() {
        try {
            logOff();
        } catch (Exception e) {
            System.out.println("Error occured " + "when disconnecting to "
                    + "database");
        }
    }
}
