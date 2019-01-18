package Practical_Code.Input_Output;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class IO_Fundamental {

	public static void main(String[] args) throws IOException 
	{
		
	/********************************   ByteStream   *******************************************************/	
	   // ByteStream  in = new FileInputStream("myfile.txt");      FileInputStream is subclass of InputStream
	   // Byte Stream  : InputStream and OutputStream   (high level Classes)
		
		InputStream in = new FileInputStream("myfile.txt");
         
        int x;
		x = in.read();   //return integer not string
		System.out.println(x);   //73 mean a characters  why this return integers not bits of 73 
		                         // they used integer to use a int that indicate the end of file  ====>  -1
		
		in.close();
		
		in = new FileInputStream("myfile.txt");
		
		OutputStream out = new FileOutputStream("myfile2.txt");
		
		while ((x = in.read()) != -1 )   //means that read until end of file
		{
			System.out.println((char)x);
			out.write(x);
		}
		out.close();	
		in.close();
       /******************************* CharacterStream ***************************************/
		//base class =>  Reader , Write  and alos  InputStreamReader , OutputStreamReader
		
		//1- Reader,Writer  => FileReader , FileWriter
		Reader read = new FileReader("myfile3.txt");
		Writer write = new FileWriter("myfile4.txt");
		
		while((x = read.read()) !=  -1)
		{
			write.write(x);
		}
		read.close();
		write.close();
		
		/* ��� ���� ������ ��������� ���� �� ���� ��� �������� �� �������� ���� �� ����� ������ ���� ��� ����� ������� �������� ��� ��� ����� ���� ������� ��������� ������*/
	                   //InputStreamReader  , OutputStreamWriter
	    
		// read = new InputStreamReader("myfile3.txt"); error
		read = new InputStreamReader(new FileInputStream("myfile5.txt"));
		write = new OutputStreamWriter(new FileOutputStream("myfile6.txt"));
		
		while((x = read.read()) !=  -1)      //k2ne bsht8l 3la Stream bs dh by3ml convert le char auto
		{
			write.write(x);
		}
		read.close();
		write.close();	
		
	  /************************** Java Buffering on ByteStream and CharacterStream *********************************/
			    	// => Return data from buffer as long as Data is there
		           //  => Faster than non-bufferedStream
		
		
		/**  Buffering ByteStream */
		 //BufferedInputStream   ,  BufferedOutputStream 
		 InputStream IN = new BufferedInputStream(new FileInputStream("myfile5.txt"));  //error know it below
		 OutputStream OUT = new BufferedOutputStream(new FileOutputStream("myfile7.txt"));  //also error
		 
		 while((x = IN.read()) != -1)
		 {
			 OUT.write(x);
		 }
		 IN.close();
		 OUT.close();
		/** Buffering CharacterStream */
		 //BufferedReader , BufferedWriter
		 
		 Reader a = new BufferedReader(new FileReader("myfile5.txt"));  //error in buffering its not subset of Reader or Writer
		 //correct line =>  BufferedReader a = new BufferedReader(new fileReader(".txt"));
		 Writer b = new BufferedWriter(new FileWriter("myfile8.txt"));   //also error  and no readline method or other work or performace
		  
		 while ((x = a.read()) != -1) 
		 {
			b.write(x);
		 }
		 
		 b.append("Done by omda");
		 a.close();
		 b.close();
	}

}
