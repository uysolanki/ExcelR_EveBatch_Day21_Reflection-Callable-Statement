package day20.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableMySQL {

	public static void main(String[] args) throws SQLException,Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		//Class.forName("com.mysql.cj.jdbc.Driver"); latest version 8.0.3
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/execommdb","root","");
		
		Statement st=con.createStatement();
		
		String query="CREATE TABLE player (\r\n"
				+ "  jerseyno int(5) NOT NULL DEFAULT 0,\r\n"
				+ "  playername varchar(20) DEFAULT NULL,\r\n"
				+ "  matchesplayed varchar(20) DEFAULT NULL,\r\n"
				+ "  runscored varchar(20) DEFAULT NULL,\r\n"
				+ "  notnout int(5) DEFAULT NULL,\r\n"
				+ "  PRIMARY KEY (jerseyno)\r\n"
				+ ")";
		st.execute(query);
		System.out.println("Table created");
		
		st.close();
		con.close();
	}

}
