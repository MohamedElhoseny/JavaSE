package Practical_Code.Generic_Programming;

public class Restrictions_On_Generics<T>   //error if  <? extends Number>  WildCards with Collection here can be  <T extends Number>
{
  /**
   *  1- Cannot Specify Primitive Type Argument
   *  2- Cannot declare Static Field of type Parameters
   *  3- Cannot Create Instances of type Parameters
   *  4- Cannot use instanceof
   *  5- Cannot create generic arrays
   *  6- Have Limitations on Exception
   *      throw , catch Clausers Can not used with generic
   *      throws can used 
   */
	
	
	public static void main(String[] args)
	{
		/* List<int> x = new ArrayList<>();      (1)     */
		
     	/*	static T x;                (2)      */
		
		/* T x = new T();             (3)      */
		
		/* List<Integer> [] l1 = new ArrayList<>();     (5)   */
		
		/**  Restriction On Exception */
		
		// 1)  public class Restrictions_On_Generics<T> extends Throwable   !! error generic cannot extends throwable 
		// 2)  Cannot Throw Clause and also Catch Cannot within generic class
		/*
		   try{
			   throw new ArrayList<Integer>();
		   }catch{
			   
		   }
	    */
		
		// Throws Exception on Function Can accept only in generic  see print function
		
	}
	public void print() throws Exception   //accept
	{
		
	}
	
}
