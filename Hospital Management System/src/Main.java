
import java.sql.*;
import javax.swing.JOptionPane;



public class Main {
//add jdbc driver by Build Path in Java Project -> Add External archives -> select sql driver
	
	public static Connection ConnectDb() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:/Users/may/eclipse-workspace/Hospital Management System/Patient.db";
			Connection conn = DriverManager.getConnection(url);
			//System.out.println("hello");
				//JOptionPane.showMessageDialog(null, "Connection Made");
				return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
			System.out.println("x");
			return null;
		}
	
	}

}
