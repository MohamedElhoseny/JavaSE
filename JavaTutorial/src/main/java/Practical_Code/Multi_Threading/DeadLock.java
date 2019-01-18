package Practical_Code.Multi_Threading;

class DeadLock extends Thread 
{
    final String r1;
    final String r2;
    int id;
    
    DeadLock(int i, String s1, String s2) 
    { 
        id = i;
        r1 = s1;
        r2 = s2; 
        start();    
    }
    
    public void run() 
    {
        synchronized(r1)  //requesting a thread own a lock on r1
        {
             System.out.println("Thread "+id+" obtained a lock on "+r1);

             try {
                 Thread.sleep(1000);
             }catch(Exception e) {

             }
           
             System.out.println("Thread "+id+" is waiting to obtain a lock on "+r2);
   
            synchronized(r2)   //requesting a thread own a lock on r2
            {
               System.out.println("Thread "+id+" obtained a lock on "+r2);
            }
       }
    }
}