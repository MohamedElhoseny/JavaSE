package Practical_Code.packaging.pkg2;

import Practical_Code.base.StringHandling;

public class Test2 
{
	public static void main(String[] args) 
	{
		
		StringHandling objHandling = new StringHandling();
		
		objHandling.publicString = "public memeber";
		//objHandling.protectedString = "protected member";
		//objHandling.noModifierString  = "noModifier memeber";
		//objHandling.privateString = "private member";      not visible in same package- non subclass
	}
}
