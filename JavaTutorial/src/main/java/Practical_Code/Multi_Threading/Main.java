package Practical_Code.Multi_Threading;

        /** Content **/
/*   #1 Thread from Class extend Thread
 *   #2 Thread from Class implement Runnable interface
 *   #3  Interrupting Thread   [part1] 
 *   #4  Suspend and Resume Thread (stop and resume)   [part2]
 *   #5  Thread Priority 
 *   #6  join() Threads   
 *   #7  Synchronized Keyword
 *   #8  DeadLock
 */

public class Main 
{
    public static void main(String[] args) throws InterruptedException
      {
	  
 /****************  #1 Thread using object from Class extend Thread   *****************/

          //Mythread t = new Mythread();   //thread only when extend Thread
         // t.start();      only with classes extend thread


 /*************** #2 Thread using object from Class implement Runnable interface  ******/


	  Thread t = new Thread(new Mythread());    //now Thread Created Succeeded
	  System.out.println("Part I");
	  t.start();

	  Thread.sleep(4000);   //sleep for main thread

      /********  Interrupting Thread   [part1] *********/
      // using interrupt() method set the thread's interrupt flag  and all ( sleep(),wait(),join() ) methods throw interruptedException
      // So when using sleep , wait , join must be in try..Catch  to handle this exception

      t.interrupt();


      /********* Suspend and Resume Thread (stop and resume)   [part2] ***********/
      Thread.sleep(2000);
      System.out.println("Part II");

      t = new Thread(new Mythread());
      t.start();  //running

      System.out.println("Hello from main thread before stop 2 second of my executation");
      Thread.sleep(2000);


      t.suspend();  // Stop or make the thread waiting
      System.out.println("Hello from Main Thread after 2 second of stopping [second Thread Stopped]");
      System.out.print("main thread working..\nmain thread working..\nmain thread working..\nmain thread working..\n");

      t.resume(); //make the thread notify to Continue flow of its execution
      System.out.println("Hello again from Main Thread  after resuming my second thread");

      // Q) What's the Different between Sleep and Wait ?

           /******  Thread Priority *******/

     /*   Priorities are represented by integer numbers from 1 (lowest) to 10 (highest) which are represented
          by two static final fields  MIN_PRIORITY  and  MAX_PRIORITY  of  Thread  class respectively.
          A new thread receives its initial priority equal to the priority of its creator thread.
     */


          /*Note:
           * What happens if two threads having same priority are started?
           *  Both of them will not not be executed simultaneously.
           *   It is dependent on the operating system.
           */
      Thread.sleep(1200);  //to finish all work before then start here

      System.out.println("Lowest thread priority: "+Thread.MIN_PRIORITY);
      System.out.println("Normal thread priority: "+Thread.NORM_PRIORITY);
      System.out.println("Highest thread priority: "+Thread.MAX_PRIORITY);

             //part1

    /*     t = Thread.currentThread();
           System.out.println("Main's initial priority: "+t.getPriority());
           t.setPriority(7);
           System.out.println("After change, main's priority: "+t.getPriority());
           new Mythread2().start();
     */


      /*************  join() Threads    **************/

      Mythread2 t1 = new Mythread2();
      Mythread2 t2 = new Mythread2();

      t1.setName("t1");
      t2.setName("t2");
      t1.setPriority(Thread.MAX_PRIORITY);
      t2.setPriority(Thread.MIN_PRIORITY);

      t1.start(); //max
      t2.start(); //min

      //syntax :     join()   //Waits for this thread to die. (to complete his execution)

      t1.join();
      t2.join();

           /**** VIP  ****/
           /* 1-  lma yb2a 3nde 2 thread wra b3d w hma el 2  .join  hy7slo concurrently wlakn 2le fe el main thread hystna lma y5lso   leh ?
           *  2-  3shan 2nta 2bl el t1.join()  3aml start asln le t2  3shan kda hna el rule msh s7  bs lazem nktbha 3shan ndmn 2ne el t2 t5ls belkaml
           *  3-  tyb lw 3wz thread y5ls el 2wl w b3deh el t2 y5osh hn3ml start le t2 b3d t1.join()  w b3d el start bta3 t2 hnktb t2.join() leh ?
           *      zy ma 2olna 3shan el main thread not executed until t1 finish then t2 finish or as u like if u want t1,t2 to work m3 b3d previos
           *  4-  el join() mlhash rules 2nta fhmt el fekra ast5dmha s7 7sb el 7aga 2le 3ndk 3wz m3 b3d w main ystna 3wz kol wa7d el y7sl msh m3 b3d
           *      as application need u do
           */

      Thread.sleep(1000);
      System.out.println("thread 1 count : "+t1.getcount());
      System.out.println("thread 2 count : "+t2.getcount()); /* m3naha 2ne thread t1  2sht8l aktr mn t2 l2eno 3ndo priority a3la*/


           /******  Synchronized keyword ****/

      Thread.sleep(1000);

       /** Problem **/

       RaceCondition ex = new RaceCondition();
       mythread3  th = new mythread3(ex);

       for (int i = 0; i < 10000; i++)   //5le balk lma el loop kant btlf 1000 loop tl3t s7 lma zwt bwzt el donia  " race condition"
       {
           ex.inc();
       }

       th.join();

       System.out.println("value of Counter [must equal zero if work correctly] => "+ ex.value);

       /************* Lock & DeadLock  ************/

          /*              LOCK ??
           *  When a method is declared as synchronized , in java every object has an entity called lock ;
           *    ((( it like a privilege that only one thread can [own] at any one time )))
           *
           *  note : only one thread can occupy lock at any time
           *         So, if a thread does [own] a [lock] of an object, no other thread [can own the lock]
           *         of the same object until [the thread that owns the lock] release it
           *
           *             DeadLock ??
           *    (( Deadlock is a situation where two or more threads wait for each other. ))
           *
           *  two or more threads could each be waiting for one another to release a lock.
           *  As a result, they will end up waiting forever.
           *
           */

       String r1 = "R1", r2 = "R2";

       //System.out.println("DeadLock Problem ..");
       //DeadLock T1 = new DeadLock(1, r1, r2);
       //DeadLock T2 = new DeadLock(2, r2, r1);

       /** Solving DeadLock Problem */

       /*
           One way to prevent deadlock is to make sure that all locks are always taken in the same order
           by any thread. For the following two threads, deadlocks cannot occur
       */
       DeadLock T1 = new DeadLock(1, r1, r2);
       DeadLock T2 = new DeadLock(2, r1, r2);

               /***   Summary Questions  ****/
            // Q1)What is the difference between yield and sleeping?
   /*
                * sleep() causes the thread to definitely stop executing for a given amount of time; if no other thread or
                 process needs to be run,  the CPU will be idle (and probably enter a power saving mode).

                * yield() basically means that the thread is not doing anything particularly important and
                if any other threads or processes need to be run, they should. Otherwise, the current thread will continue to run
   */


            //Q2)Is it possible to create new thread by calling its run() method directly? If not, why?
  /*
               * Because start() will do it as a separate thread.
               * If you were to just call run(), that would be part of your thread (i.e., a function call).
  */


            //Q3)What happens when we make a static method synchronized?
 /*
                 Meanwhile, there are two instances of class Test, testA and testB. And also there are two thread tA and tB
                 trying to access class Test in parallel.

               * locking on instanceMethod: When tA gets the lock on instanceMethod of testA,
                  tB cannot access the the same method in testA, however tB is still free to invoke instanceMethod in testB.
                  Because the synchronization against instanceMethod is instance(object) level locking

               * locking on staticMethod: However, when tA gets the lock on staticMethod,
                 the lock has nothing to do with testA or testB, since synchronization on static method is a class level locking.
                 Which means tB cannot access staticMethod at all until tA release the lock
  */

      }
      

      
}
