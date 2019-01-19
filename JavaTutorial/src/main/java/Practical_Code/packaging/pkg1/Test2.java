package Practical_Code.packaging.pkg1;

public class Test2 
{
	public static void main(String[] args) {
		
		StringHandling objHandling = new StringHandling();
		
		objHandling.publicString = "public memeber";
		objHandling.protectedString = "protected member";
		objHandling.noModifierString  = "noModifier memeber";
		//objHandling.privateString = "private member";      not visible in same package- non subclass
	}
}
