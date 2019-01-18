package Practical_Code.Multi_Threading;


public class Mythread2 extends Thread
{
      int count = 0;
      
      public int getcount()
      {
        return count;
      }
      
      
    /* set priority here if u extend thread class  if u want to set the priority of this thread in main so implement is good*/
    public void run()
    {
		while(count < 10)
		{
			count++;
			System .out.println(Thread.currentThread() + " working ...");
			try {
			Thread.sleep(500);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	
    }
      
}
