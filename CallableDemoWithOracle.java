package day20.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableDemoWithOracle {
public static void main(String[] args) throws Exception {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	
	int a=18;
	String b ="virat";
	int c=87;
	String d="A";
	
	String query="{call pro1(?,?,?,?,?)}";
	CallableStatement cs=con.prepareCall(query);
	cs.setInt(1,a);
	cs.setString(2,b);
	cs.setInt(3,c);
	cs.setString(4,d);
	
	cs.registerOutParameter(5,java.sql.Types.VARCHAR);
	cs.executeUpdate();
	
	String result=cs.getString(5);
	if(result.equals("true"))
		System.out.println("Record Inserted");
	else
		System.out.println("Record Not Inserted");
}
}
