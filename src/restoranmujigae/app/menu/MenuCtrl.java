package restoranmujigae.app.menu;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import restoranmujigae.app.database.DBConnector;
import restoranmujigae.app.database.DBConnector;
import restoranmujigae.app.menu.Menu;

public class MenuCtrl {
	
	public LinkedList<Menu> getAllMenu() throws SQLException{
		LinkedList<Menu> list = new LinkedList();
		DBConnector conn = new DBConnector();
		conn.connect();
		Statement stm = conn.con.createStatement();
		ResultSet hasil = stm.executeQuery("Select * from menu");
		while(hasil.next()){
			Menu menu = new Menu(
					hasil.getInt("id"), hasil.getString("nama"),
					hasil.getDouble("harga"), hasil.getBoolean("status"));
			list.add(menu);
		}
		conn.disconnect();
		return list;
	}
	
}
