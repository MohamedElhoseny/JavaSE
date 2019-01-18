package Part_I;

//using of reflection :

import Practical_Code.Reflection.trace;

// enable us to examine or modify the properties or behaviour or other elements of an object ar runtime
/*
 * Given aclass name we can extract all things about it : fields , modifiers , methods ,interfaces that it implements and can operate on it
 * 	
 */

public class Reflection implements trace
{
    /** The foundation of java reflection API is the Class (java.lang.class) a class object represent a class or interface*/   

    public static void main(String[] args)
    {  	
    	/** Some Notes before Start */
    	Class m ;      //kda m dh pointer hyshawr 3la object no3o Class
    	//Class mm = new Class();    dh kda object mn el class zat nfso (new)
    	
 /***********************************  1) Methods to get a Class Object to used a java.lang.Class  Methods to reflect class object **************/                                   	
    	
    	/** using getclass() method */
    	String s = new String("omda");
    	Class c = s.getClass();  
    	System.out.println(c);  	
    	int []arr = new int[10];
    	c = arr.getClass();
    	System.out.println(c);   //[I   => array  
    	trace t = new Reflection();    //By Your Heart
    	c=t.getClass();   //not the interface but the reflection class as t now object for class reflection
    	System.out.println(c);
    	
    	/**  using .class (primitive) == .TYPE (wrapper) */
    	/*used for primitive types not objects*/    	
	    	c = int.class;
	    	//c = int.TYPE; error
	    	c = Integer.TYPE;
    	
    	/**  using forName() method  */
    	try 
    	{
    		c = Class.forName("java.lang.String");
    		c = Class.forName("java.io.Serializable");
    		
		}catch(ClassNotFoundException e) 
    	{
			e.printStackTrace();
		}
    	
     /************************************   2) Let Now Work With a java.lang.Class Methods in Reflection Package   **************/ 	
    	
    }
}
