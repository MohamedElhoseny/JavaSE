package Part_I;

//Some Notes
/*
 * In a single-threaded process, there is only one flow to execution of instructions
 * In a multi-threaded process has multiple sets of instructions that are executed concurrently (more than one)
 * 
 * Main Thread =>  it is the first thread that starts running when a program begins
 *  working with thread can cause interruption with cpu so we use InterruptedException to handle if this happen
 *  two ways to define new thread => extending Thread Class (not preferred) , implementing runnable interface
 *
 *  Interrupting a thread means requesting it to stop what it is currently doing and do something else
 *  Suspending and Resuming Thread using wait() , notify()
 */
public class Multi_Threading
{
    public static void main(String args[])
    {
	Thread t = Thread.currentThread();    //reference to current thread executing  "Main Thread"
	
	// some methods
	System.out.println("Current Thread: "+t);  //Thread[main,5,main]  main = name  main = type  5 = priority
	System.out.println("Name: "+t.getName()); //main
	System.out.println("Id: "+t.getId());
	System.out.println("Priority: "+t.getPriority());  //5
	System.out.println("State: "+t.getState());    //Runnable
	System.out.println("Changing name and priority...");
	t.setName("Primary");
	t.setPriority(8);
	System.out.println("After name and priority change...");
	System.out.println("Current Thread: "+t); //Thread[Primary,8,main]   primary = name  8 = priority  main => type
	System.out.println("Name: "+t.getName());
	System.out.println("Priority: "+t.getPriority());	
                
	sleep_thread();
         
        int ii ;
        for(ii=0; ii<10; ii++)
        {
                             
        }
    }
    
                            //sleep method
    public static void sleep_thread()
    {  
        for(;;) 
        {
            System.out.println("Local date and time: "+new java.util.Date());
            try
            {
        	Thread.sleep(3000);
        	// bystana el swane dh w bykml el code 3ade
        	// 1000ms = 1second 
            }catch(InterruptedException ie)
            {
        	    
            }
        }
    }
       //go to tracing files (advanced)
}
