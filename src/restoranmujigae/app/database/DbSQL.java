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
import restoranmujigae.app.controller.data.PropertiesLoader;

public class DbSQL {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://"+ PropertiesLoader.prop.getProperty("url") + "/restoran_mujigae";
    private static String username = PropertiesLoader.prop.getProperty("dbuser");
    private static String password = PropertiesLoader.prop.getProperty("dbpassword");

    private static DbSQL db;
    private Connection con = null;

    private DbSQL() {
    }

    public static synchronized DbSQL getInstance() throws SQLException {
        if (db == null) {
            db = new DbSQL();
            try {
                Class.forName(driver).newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Driver koneksi tidak ditemukan!");
            }
            db.con = DriverManager.getConnection(url, username, password);
        }
        return db;
    }

    public void logOff() {
        try {
            db.con.close();
            db = null;
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
