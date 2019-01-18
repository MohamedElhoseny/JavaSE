package Practical_Code.Input_Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Reading_From_keybord
{
	public static void main(String[] args) throws IOException 
	{
		/** Standard Reading */
         //reading a Character
		 Reader in = new InputStreamReader(System.in);
		 System.out.println("Enter a Char : ");
         System.out.println("Character => "+ (char)in.read());
         
         //reading a String 
         BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Enter a String : ");
         String line = x.readLine();
         System.out.println(line);
         
         //My self
         Scanner get = new Scanner(System.in);
         System.out.println("Enter anything : ");
         line = get.next();   //scan for String
         System.out.println(line);

       /**  Formatting   */
         //All println , printf , format  all method in PrintWriter class
         int a = 5 , b = 6;
         System.out.println(a+b);
         System.out.printf("the result of Summation %d and %d  =  %d", a,b,a+b);
	}

}
