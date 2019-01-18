package Practical_Code.Generic_Programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main
{
     public static void main(String[] args)
     {
    	 /**Motivation**/
    	 
    	 Integer x = 5;
    	 String y = "welcome";
    	 
    	 not_parameterized  obj = new not_parameterized();
    	 obj.set(x);
    	 obj.set(y);
    	 
    	//Integer get_x = (Integer)obj.get();       //Casting is required (fired here ClassCastException )
    	 String  get_y = (String)obj.get();       //Casting is required
    	 // ClassCastException can fired while working ( Casting is not good)   
    	 
    	 /**Solution**/
    	 
    	 parameterized_Class<Integer> i = new parameterized_Class<>();
    	 
    	 i.set(x);
    	 Integer get_x = i.get();     //Casting is not required
    	 System.out.println(get_x);
    	 
       /** Compilation error cannot set Argument of Type String [We prevented Runtime Exception and Obtained Compilation error (can be solved during compiling)]*/   	 
        //i.set(y);  
    	 
    	parameterized_Class<String> ii = new parameterized_Class<>();
    	ii.set(y);  // no compiling error  
    	get_y = ii.get();  //casting not required
     //	ii.set(x);   Compilation error
    	
  	
    	/** Collection Framework and Generic **/ 
        List l = new ArrayList();
        l.add(5);
        l.add(10);     
        Integer element = (Integer)l.get(1);  //Casting is required
        
        List<Integer> L = new ArrayList<>();
        L.add(5);
        L.add(6);     
        element = L.get(1);  //Casting is not Required
        
        /** Type Naming **/
        
        /*
         * T => Type : String , Interger ...
         * V => Value : Value of one of variable 
         * E => Element
         * N => Number
         */
        
     //Para_class2<String, 245242, x>  Obj = new Para_class2<>();   !!error only Type Name then send to set method
        Para_class2<String, Integer, Comparable<Object>> objj = new Para_class2<>();
        
            /*Terms in Generic*/
        /*
         *  List<E>                   Generic Type , E is formal parameter
         *  List<Integer>             parameterized type , y3ne 5las b3t el E be integer
         *  <T extends Comparable>    UpperBound 
         *  List<?>                   unbounded wildcard (any)
         *  <? extends T>             Bounded wildcard
         *  List                      Raw Type
         *  <T extends Comparable<T>> recursize bounded type 
         */
        
        
        
        /** Generic Methods and Constructor **/
        //belblde y3ne h3ml method w msh m7dd no3 el parameter 2le htst2blo
        //Note :- They are useful if i dont want to make whole class generic
        
         i.print(5);
         i.print("welcome");
         i.print(x);   //where x is Integer
         
         //this Called  =========================> Generic Methods
         
         //also Constructor can be generic method
         

         /*** Restriction on Classes to accept certain Parameter ***/
        
         Restricted_class<Integer> r1 = new Restricted_class<>();
         Restricted_class<Double>  r2 = new Restricted_class<>();
         Restricted_class<Float> r3 = new Restricted_class<>();
         
    //  Restricted_class<String> r4 = new Restricted_class<>();   ! error as String not subtype of Number !
    //  Restricted_class<Object> r4 = new Restricted_class<>();   ! error as Object is SuperType  to Number Class not Subtype
         
         
         
         /** Generics And Sub-Type  **/
         
         List<Integer> ll = new ArrayList<>();            //where  arraylist is Subtype of List (y3ne 3amla extend aw implement leh hwa el parent bt3ha)
         Number x1 = 8;    //accept
         Object x2  = new Exception();    //accept as object is the BigBos            
                  /** By Your Heart */
           //integer is subtype of Number but List<integer> Not the subtype of List<number>
         List<Integer> z1 = new ArrayList<>();
         List<Number> z2 = new ArrayList<>();
        /* z2 = z1;     Type mismatch: cannot convert from List<Integer> to List<Number>   */
       
         
         /** WildCard **/
              // ? means unknown type
       /**  1- Upper-Bound Wildcard  <? extends Number>  */
         
         i.fun1(ll);  // accepted as ll is list of integers which extends Number
         List<String> l2 = new ArrayList<>();
         // i.fun1(l2);    Compilation error as l2 is list of string which not extends Number
         
         List<? extends Number> ld = new LinkedList<Double>();   //example
         
      /**  2- Lower-Bound Wildcard  <? Super Number>  */  
         
         List<Object> l3 = new ArrayList<>();
         i.fun2(l3);  //accept  as el object is perent of Object
         //i.fun2(ll);   not accept bec integer not perent to Number its a child to it
         
      /**  3- UnBound Wildcard  <?>  */
         
         i.fun3(ll);
         i.fun3(l2);
         i.fun3(l3);         //accept all types of lists
         
         
         
     }
}
