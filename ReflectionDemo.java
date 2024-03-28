package day21.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		//Student
		Class c=Class.forName("day21.reflection.Student");
		System.out.println("Class Name "+ c.getName());
		System.out.println("================================================");
		
		System.out.println("Super Class Name "+ c.getSuperclass().getName());
		System.out.println("================================================");
		
		System.out.print("Interfaces Implemented :");
		Class interfaces[]=c.getInterfaces();
		for(Class intface:interfaces)
		{
			System.out.print(intface.getName()+",");
		}
		System.out.println();
		System.out.println("================================================");
		//public datamembers of current class + public DM of Super class
		System.out.print("Public Data Members Of Current + Super Class :");
		Field fields[] =c.getFields();
		for(Field datamember:fields)
		{
			System.out.print(datamember.getName()+",");
		}
		System.out.println();
		System.out.println("================================================");
		//All datamembers of current class
		System.out.print("All Data Members Of Current Only :");
		Field fields1[] =c.getDeclaredFields();
		for(Field datamember:fields1)
		{
			System.out.println("Property Name " +datamember.getName()+",");
			System.out.println("Datatype " +datamember.getType().getName()+",");
			int i=datamember.getModifiers();
			System.out.println("Access Modifier " +Modifier.toString(i)+",");
		}
		System.out.println();
		System.out.println("================================================");
	
		System.out.print("All 3 public Constructors :");
		Constructor constructors[] =c.getConstructors();
		for(Constructor constructor:constructors)
		{
			System.out.println("Constructor Name " +constructor.getName()+",");
			int i=constructor.getModifiers();
			System.out.println("Access Modifier " +Modifier.toString(i)+",");
		}
		System.out.println();
		System.out.println("================================================");
	
		System.out.print("All 4 Constructors public+private :");
		Constructor constructors1[] =c.getDeclaredConstructors();
		for(Constructor constructor:constructors1)
		{
			System.out.println("Constructor Name " +constructor.getName()+",");
			int i=constructor.getModifiers();
			System.out.println("Access Modifier " +Modifier.toString(i)+",");
			Class parameters[]=constructor.getParameterTypes();
			for(Class c1:parameters)
			{
				System.out.println(c1.getName());
			}
			
			Class exceptions[]=constructor.getExceptionTypes();
			for(Class e1:exceptions)
			{
				System.out.println(e1.getName());
			}
		}
		
		System.out.println();
		System.out.println("================================================");
		System.out.print("Public Method Names Of Current + Super Class :");
		Method methods[]=c.getMethods();
		for(Method m:methods)
		{
			System.out.println("Name : "+m.getName());
		}
		
		System.out.println();
		System.out.println("================================================");
		System.out.print("All Method Names Of Current class only :");
		Method methods1[]=c.getDeclaredMethods();
		for(Method m:methods1)
		{
			System.out.println("Name : "+m.getName());
			int i=m.getModifiers();
			System.out.println("Access Modifier " +Modifier.toString(i)+",");
			
			Class parameters[]=m.getParameterTypes();
			System.out.println("Parameter Names :");
			for(Class p:parameters)
			{
				System.out.print(p.getName()+",");
			}
		}
		
		
	}

}
