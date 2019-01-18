package Practical_Code.Generic_Programming;

import java.util.List;

public class parameterized_Class <T>
{      
	 //erasure
     T obj;
     
     public void set(T obj)
     {
    	 this.obj=obj;
     }
     public T get()
     {
    	 return this.obj;
     }
     
     
     //generic method
     public <X> void print(X obj)
     {
    	 System.out.println(obj.getClass().getName());  //print class name
     }
     
     //wildcard
     
     public void fun1(List<? extends Number> list)
     {
    	 //y3ne m3naha bst2bl ay no3 list bs ykon el list of any type extends Number (integer , double ....)
     }
     public void fun2(List<? super Number> list)
     {
    	 //y3ne m3naha bst2bl ay no3  el no3 dh hwa Super le Number y3ne el Number belnzba leh Child zy ---> Object 
     }
     public void fun3(List<?> list)
     {
    	 //m3naha 2no byst2bl ay no3 list ya m3lm
     }
     
}
