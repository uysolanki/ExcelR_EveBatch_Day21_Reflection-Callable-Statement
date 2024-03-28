package day21.reflection;

import java.lang.reflect.Field;

public class ModifyFinalData {

	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		
		Student s1=new Student("Alice");
		System.out.println("Before " +s1.getTemp());
		
		Class c=Class.forName("day21.reflection.Student");
		Field fields[]=c.getDeclaredFields();
		for(Field f:fields)
		{
			//System.out.println(f.getName());
			if(f.getName().equals("temp"))
				{
				f.setAccessible(true);
				f.set(s1,"xyz");
				}
		}
		
		System.out.println("After " +s1.getTemp());
	}

}
