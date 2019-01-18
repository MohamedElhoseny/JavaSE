package Practical_Code.Multi_Threading;

import java.util.Date;

// Creating Thread using implement Runnable interface (Good Practice)

 public class Mythread implements Runnable
 {
     //boolean active = true;   //current state of thread
     
     public synchronized void suspend() throws InterruptedException
     {
	    //active = false;   //stop
	    wait();
     }
     
     public synchronized void resume()
     {
	    //active = true;   //ast2nf
	     notify();        //Wakes up a single thread that is waiting on this object's monitor
     }
     
	 @Override
     public void run()
     {
	    for(int i=0; i<10 ; i++)
	    {
	       System.out.println(new Date());
	       //sleep
	       try {
		       Thread.sleep(500);
	       } catch (InterruptedException e) {
		         System.out.println("Thread Interrupted !");
	       }
	 }
	 
	 
	 /***    @dh 3shan 2wl tgrba
	 while(true) 
	 {
	    
	     System.out.println("Timer running. Date & time: "+new java.util.Date());
	     try 
	     {
	         Thread.sleep(1000);
	     }
	     catch(InterruptedException e)
	     { 
	        System.out.println("Timer was interrupted");
	        return;	    
	     }
	    
         }
          ***/
    }
     
}

 
 // Creating Thread using extend (not good as no multiple inheritance)

/*   
 public class Mythread extends Thread    
 {
    public void run()
    {
        for(int i =0 ; i< 4 ;i++)
        {
 	   System.out.println("Hello from My Specific Thread i = "+i);	
        }
    }
 }
*/

