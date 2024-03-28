package day20.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

public class CallableDemoWithMySQL {
public static void main(String[] args) throws Exception {
	Connection con=MySqlConnect.getConnection();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Rno");
	int a=sc.nextInt();
	System.out.println("Enter Name");
	String b=sc.next();
	System.out.println("Enter Per");
	int c=sc.nextInt();
	System.out.println("Enter Division");
	String d=sc.next();
	
	
	String query="{call studpro1(?,?,?,?,?)}";
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
