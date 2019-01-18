package Practical_Code.Generic_Programming;



 //extends means =>  that type T must be sub-type  of Number Class or Number Interface   , extends (for classes and interfaces)

public class Restricted_class<T extends Number>
{

    public void print(T obj)
    {
	    System.out.println(obj.getClass().getName());
    }
}



//public class Restricted_Class<T extends Comparable<T>>   y3ne el T dh lazem ykon 3aml implement le Comparable interface

/**  Multiple Bounds  **/
  //public class Restricted_class<T extends Number & Object>          this is an error subtyping error

  //correct  ... 

 //public class Restricted_class<T extends Object & Number>  


/*another forms u can think*/

// <T extends number , V>
// <T extends Object , E extends Comparable<E>>       