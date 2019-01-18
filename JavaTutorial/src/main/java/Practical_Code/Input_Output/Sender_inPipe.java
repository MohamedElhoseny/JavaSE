package Practical_Code.Input_Output;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Sender_inPipe extends Thread
{
    PipedOutputStream out;
    
    public Sender_inPipe(PipedOutputStream o)
    {
    	this.out=o;
    }
    public void run()
    {
    	while(true){
	    	try 
	    	{
	    		int value = (int)(Math.random()*100);
				out.write(value);
				System.out.println("Send : "+value);
				Thread.sleep(1000);
			} 
	    	catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
