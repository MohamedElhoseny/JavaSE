package Practical_Code.packaging.pkg1;

public class Test1 extends StringHandling
{
	public Test1()
	{
		this.publicString = "public memeber";
		this.protectedString = "protected member";
		this.noModifierString = "noModifier memeber";
		//this.privateString = "private member";      not visible in same package-subclass
	}
}
