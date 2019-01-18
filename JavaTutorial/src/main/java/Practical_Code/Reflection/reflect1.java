package Practical_Code.Reflection;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import Practical_Code.Collection_Framework.Student;

//Modifiers : public , private , protected , final , static , Synchronized , abstract 
//Methods : 
//  classModifiers => public,private,protected,static,final,abstract,strict
//  fieldModiefiers => public,private,protected,static,final,volatile,transient
//  methodModiefies => public,private,protected,static,final,schron , native,abstract,strict
//  constructorModiefiers => public,private,protected

public class reflect1 
{
	private static Method m;
	public static void main(String[] args)
	{
		Student x = new Student(1001, 17, "omda");
		Dynamic_Proxy();
	}
	
	
	public static void Get_info(Student x)
	{
		Class c = x.getClass();     //c is pointer to Object Class X  y3ni pointer 3la class el object x 2le hwa Student
		
		String cname = c.getCanonicalName();
		String sname = c.getSimpleName();  //bygeb asm el class only
		String name = c.getName();  //bygeb asm el class be el packages bt3to
		
		System.out.println("Class info : Cannonical name = "+cname+"\n"+"Simple name = "+sname+"\n"+"Name = "+name); //we detect that getname is same as Canonical
		
		/* 3wz ageb el package yb2a h3ml pointer mn no3 el package w bygeb el package bta3t class object*/
		Package p = c.getPackage();
		
		String pname = p.getName();
		System.out.print("Package Name = "+pname);
	}
    public static void Get_Modifier(Student x)
    {    	
		//��� ������ ������ �� ����� ��� ����� ��� ������ ��� �������
		Class c = x.getClass();
		String mod = Modifier.toString(c.getModifiers());   //c.getModifiers  btrg3 int fa7na lazem n3mlha toString  msh cast 3ade k2nk bt2olo 3wz el String msh int
		/**
		 *  Note : 
		 *   String mod = c.toString(c.getmodifiers());  //dh kda 8lt w a7aaa msh kfaya  2nta 3wz tgeb modifiers yb2a  modifier.toString(tb3tlo 2le htgebo)
		 */
		System.out.println(mod);
		
		c = Serializable.class;
		mod = Modifier.toString(c.getModifiers());
		System.out.println(mod);
    }  
    public static void Get_imp_interface(Student x)
    {
    	Class c = x.getClass();
    //	String i = c.getGenericInterfaces();  by2ole msh hy2dr y7wl mn type[] to string mmken ast5dm el toString bs we leh m3ml variable mn el type
    	Type[] t = c.getGenericInterfaces();
    	for (Type type : t) {
			System.out.println(type);
		}
    	
    	//bygeb el parent bta3 3l class Student 
    	Class s = c.getSuperclass();
    	System.out.println(s);
    }
    
    public static void Get_Methods(Student x)
    {
    	Class c = x.getClass();
    	//getDeclaredMethod => btgeb el method 2le m3mola gwa el class dh  
    	//getMethods => btgeb kol el methods 2le object bta3 el class dh htb2a 3ndo w beltale el notify , wait kolo hytb3
    	Method[] m = c.getDeclaredMethods();
    	for (Method method : m) {
			System.out.println(method);
    	}

    	for (Method method : m) {
			System.out.println("Method = "+method.getName() +" is "+method.getModifiers());
		}
    	System.out.println("there are the methods while printing there modifiers without toString \n Now See With Modifier.ToString(mod)");
    	
    	for (Method method : m) {
			System.out.println("Method = "+method.getName() +" is "+ Modifier.toString(method.getModifiers()));
		}
    	
    	//getConstructors
    	Constructor[] n = c.getConstructors();
    	for (Constructor constructor : n) {
			System.out.println(constructor);
		}
    	
    	//getReturnType()  getParameterTypes()
    }
    public static void Get_Members(Student x)
    {
    	Class c = x.getClass();
    	Field[] f = c.getDeclaredFields();   //also any field or method  hava a Functions  as gettype()  , getName()
    	for (Field field : f) {
			//System.out.println(field);  work but need to work with its functions
    		System.out.println(field.getName() +" => "+field.getType());
		}
    	
    	//To Get Modifier of or check it for Member this is the way :
    	// Modifier.check(Give here the modifier to check by getModifier())
    	for (Field field : f) {
			if (Modifier.isStatic(field.getModifiers())) 
			{
				System.out.println("there is an field which is static ana its name => "+field.getName());
			} else {
               System.out.println("No Static Field Found");
			}
		}
    }
    
    public static void Work_With_Members(Student x)     //members => fields , methods

    {
    	/** Accessing Fields */
	    	/* The Class [Field] have several Methods to get and Set Field Value*/
	    	Class c = x.getClass();	
	    	
	        try {
	        	Field f = c.getDeclaredField("student_id");
	        	f.setAccessible(true);  //to make private accessible So illegal will not fire
				f.setInt(x, 1005);					
				//illegalArgumentException  dh lw ana get access field private  ye fire el exception l2ne ana 3mlt 7aga msh tb3eya (access private)
				//NoSuchFieldException 3shan lw ktbt member w hwa msh mwgod
			} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}      
	        System.out.println(x.getid());
	        
	        //accessing final field also (final cant access or modify  htksr kol dh)
	        
	        String fname = " ";
	        try {
				Field f = c.getDeclaredField("school_name"); //final
				f.setAccessible(true);
				f.set(x, "omar el gdeda");
				fname = (String) f.get(x);   //get return Object
			} 
	        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) 
	        {
				// TODO: handle exception
			}
	        System.out.println("New final Value Now = "+fname);
        
        /** Invoking Methods */
    
	        String s = "java";
	        c = s.getClass();
	        try
	        {
				Method m = c.getDeclaredMethod("lenght");
				m.invoke(s);		
				
				//if method is Private  m.setAccessible()
				
				
			} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}

    }
    public static void Debugging_used_reflection(Student x)
    {
    	/*
    	 *    ����� ���� �� ��������� ��� �� ������ ��� ���� ������ ����� ���� ��� ���� ����� ����� ����� ���� ����� ������ ����� ��� ������� ������� ������� �������� ��� ������ ���
    	 * 
    	 */
    	annotation a = new annotation();  	
    	Method[] m = a.getClass().getDeclaredMethods();  //htle kol el method bto3 el object class  a
    	
    	for (Method method : m){
			call annotation = method.getAnnotation(call.class);    //getAnnotation(AnnotatioClass)
			if (annotation != null) 	{
				try 	{
					method.invoke(a);
				} 
				catch (Exception e)
				{
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
    }
    public static void Dynamic_Proxy()
    {
    	//Proxy => is a module sit between two or more communicating parties
    	// Proxy can intercept , inspect , modify the exchange
    	//VIP NOTE :
    	//��� �������� ��� ������ ���� ���� ���� �� ������� ��� �� ������ ��� ����� ��� ������ ���� ��� ���� ���� ������� ���� �������� ������� ������ ��������� ��������� ���� ���� �� ���� ���������� ��������� ���� ���� ���� ��� ������� 
           /** dh k2no el Caller Class */
    	
    	Target  obj = new Target();
    	
    	
    	int result = obj.add(5, 3);
    	System.out.println("In Caller we send 5 and 3");      //b3tlo
    	System.out.println("In Caller we Recieved "+result);  //b3tleeee
    	//a7na b2a 3wzen ne install proxy ben el Caller w Target Class  b7es lma el caller ynade 3la method gwa el target el proxy ysht8l
        
    	
    	/**  Install Proxy **/
    	//3shan install proxy ana 3wz a Pointer 3la proxy class w ab3tlo el class loader bta3 class 2l target w kol interfaces 2le hwa 3mlha implement w 3wz ab3tlo el object bta3 el target 2le bnade gwah el functions
        //deh kant tre2t install aw create proxy fe main  typ fen b2a el class 2le hktb feh y3ml 2eh w hwa bynade 3la method 
    	//InvocationHandler => dh interface el proxy 2le feh function el invoke 
    
    	 /** Installed */
        Imethod c = (Imethod)Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new Proxy_Security(obj));
          //lw 3mlt Run w mfesh code b3d install msh hysht8l l2ne ana b3t w ast2blt fo2 lazem b3d el install 
        System.out.println("After Install Proxy : \n______________________");
        /** fdelt sa3a 3shan a3rfha lma anade 3la function anade 3leha bst5dam el interface object 2le 3leh el proxy w ana b3tlo fe el a5r obj 3shan y3rf 2no hysh8lha 3la obj dh */
        result = c.add(5, 3);
    	System.out.println("In Caller we send 5 and 3");      //b3tlo
    	System.out.println("In Caller we Recieved "+result);  //b3tleeee
    }
}


