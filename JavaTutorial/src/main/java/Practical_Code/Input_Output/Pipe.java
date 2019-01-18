package Practical_Code.Input_Output;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Pipe {

	public static void main(String[] args) throws IOException
	{
		PipedOutputStream writer = new PipedOutputStream();
		PipedInputStream  reader = new PipedInputStream(writer);
		
		new Reciver_inPipe(reader).start();
		new Sender_inPipe(writer).start();
	}

}
