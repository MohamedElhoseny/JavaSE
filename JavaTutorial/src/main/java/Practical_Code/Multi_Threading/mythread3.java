package Practical_Code.Multi_Threading;

public class mythread3 extends Thread
{
    RaceCondition  x;    //aggregation [reference]
    
    public mythread3(RaceCondition y)
    {
	    this.x = y;   //3shan access  nfs el object
        start();
    }
    
    public void run()
    {
        for (int i = 0; i < 10000; i++)
        {
            x.dec();
        }
    }
}
