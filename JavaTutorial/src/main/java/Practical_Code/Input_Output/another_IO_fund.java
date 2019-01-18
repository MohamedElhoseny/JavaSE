package Practical_Code.Input_Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Practical_Code.Collection_Framework.Student;

public class another_IO_fund {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		/************************  ObjectStream ******************************************/
		//ObjectInputStream => ReadObject()    ObjectOutputStream => WriteObject()
		
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("mydata.dat"));
		o.writeObject(new Practical_Code.Collection_Framework.Student(1001, 17, "omda"));
		o.close();
		/** Fire Exception => leh 3shan lazem ay class hsht8l 3leh ykon 3mel implement Serializable interface*/
		
		ObjectInputStream i = new ObjectInputStream(new FileInputStream("mydata.dat"));
		Student x = (Student)i.readObject();
		System.out.println("Student age returned = "+x.getage());
		i.close();
		
		//tb3n el object dh el BigBos fa 2nta t2dr t7ot ay 7aga 
		
		/******************* Get file data into Array if u accessed file more   ********/
		byte[] bytes = new byte[1024];  //1mb = 1024byte
		bytes[0] = 5;
		bytes[1] = 10;
		
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);	
		int y;
		while(( y = in.read()) != -1)
		{
			System.out.println(y);
		}
		
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write(5);
		out.write(3);
		
		byte[] b = out.toByteArray();
		int xx = b[0];
		System.out.println(xx);
		
		
		
	}

}
