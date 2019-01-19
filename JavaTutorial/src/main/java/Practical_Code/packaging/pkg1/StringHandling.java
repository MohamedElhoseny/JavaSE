package Practical_Code.packaging.pkg1;

public class StringHandling 
{
	
	//for testing package encapsulation
	public String publicString;
	private String privateString;
	protected String protectedString;
	String noModifierString;
	
	public StringHandling()
	{
		this.privateString = "my private member";
		System.out.println(privateString);
	}
}
