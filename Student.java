package day21.reflection;

import java.io.Serializable;
import java.sql.SQLException;

public class Student extends Person implements Serializable,Cloneable,Comparable<Student>{
		public int rno;
		public String sname;
		private String password;
		private final String temp;
		
		//public Student() {}
		public Student(String temp)
		{
			this.temp=temp;
		}
		


		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public void acceptStudent(int a, int b)
		{
			
		}
		
		public void displayStudent(double a, double b)
		{
			
		}

		public String getTemp() {
			return temp;
		}
		
		
}
