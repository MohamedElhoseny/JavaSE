package Practical_Code.base;


public class StringHandling 
{
	
	//for testing package encapsulation
	public String publicString;
	private String privateString;
	protected String protectedString;
	String noModifierString;
	
	public static void main(String[] args) 
	{
		/* Two ways to create String object : String Literal, new */
		
		//#1 String Literal
		String s1 = "Java";  // store this value in string constant pool  
		String s2 = "Java";  // no new object will be created !!
		
		System.out.println(s1 == s2);  //true
		System.out.println(s1.equals(s2));  //true
		
		s1.concat("Programming"); // nothing is concatenated to s1 as its immutable so new object will be created
		System.out.println(s1);  //Java
		
		s1 = s1.concat("Programming"); //new object will created and assign to s1 
		System.out.println(s1); //Java Programming
		System.out.println(s2);  //Nothing happen to s2 
		
		
		//#2 new keyword
		String s3 = new String("Java");
		String s4 = new String("Java");
		
		System.out.println(s3 == s4);  //false
		System.out.println(s3.equals(s4));  //true
	
		s3.concat("Programming"); // nothing is concatenated to s3 as its immutable so new object will be created
		System.out.println(s3);  //Java
		
		s3 = s3.concat("Programming"); //new object will created and assign to s1 
		System.out.println(s3); //Java Programming
		
		
		// Advantages of Immutability -> use less memory
		// DisAdvantage of Immutability -> less efficient  (create a new and throw away the old)
		
		/*
		 * Java has two mutable classes : StringBuilder , StringBuffer
		 * Most different between them Stringbuffer is good on multithreaded environment
		 * */
	}

}
