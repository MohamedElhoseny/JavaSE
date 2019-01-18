package Practical_Code.Reflection;

public class Target implements Imethod
{

	@Override
	public int add(int a, int b) 
	{
       System.out.println("In Add funtion we recieved "+a+" and "+b);
		int result = a+b;
		System.out.println("In Add funtion we Send "+result);
		return result;
	}
  
}
