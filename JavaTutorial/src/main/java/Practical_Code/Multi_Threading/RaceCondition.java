package Practical_Code.Multi_Threading;

public class RaceCondition
{
    public int value = 0;

    
    public void inc()
    {
     value++;	
    }
    public void dec()
    {
      value--;	
    }
    
    /** to solve problem (to prevent the overlapped) */
       /*     
             1)  Synchronized method
             
                public synchronized void inc()
                {
            	   value++;
                }
                public synchronized void dec()
                {
            	   value--;
                }
             
              2)  Synchronized block
              
                 public  void inc()
                {
            	   synchronized (this) 
            	   {
            	    value++;
            	   }
                }
        */
}
