package Practical_Code.Input_Output;

import java.io.IOException;
import java.io.PipedInputStream;

public class Reciver_inPipe extends Thread
{
    PipedInputStream in;   //in prog
    public Reciver_inPipe(PipedInputStream o)
    {
    	this.in = o;
    }
    public void run()
    {
    	while(true){
    	try {
			System.out.println("Recived : "+in.read());
		} 
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    }
}
