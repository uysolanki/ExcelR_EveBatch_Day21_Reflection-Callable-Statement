package day20.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CallableOracleDeleteQueryDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Product ID to delete");
		int a=sc.nextInt();
		
		String query="{call p55(?,?)}";
		CallableStatement cs=con.prepareCall(query);
		cs.setInt(1,a);

		cs.registerOutParameter(2,java.sql.Types.VARCHAR);
		cs.executeUpdate();
		
		String result=cs.getString(2);
		if(result.equals("true"))
			System.out.println("Record Deleted");
		else
			System.out.println("Record Not Deleted");

	}

}
