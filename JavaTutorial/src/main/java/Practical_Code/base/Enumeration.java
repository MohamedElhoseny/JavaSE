package Practical_Code.base;



enum Week {
	Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday
};
enum CoffeeSize {
    // 8, 10 & 16 are passed to the constructor
    BIG(8), HUGE(10), OVERWHELMING(16);
    
	CoffeeSize(int ounces) {    // constructor
      this.ounces = ounces;
    }
    private int ounces;         // an instance variable
    public int getOunces() {
      return ounces;
    }
}

public class Enumeration 
{
	public static void main(String[] args) 
	{
		Week ap;
		
		ap = Week.Sunday;
		System.out.println("Value of ap : "+ap);
		
		String name = ap.name();
		
		if(name.equals("Sunday"))
			System.out.println("equal");
		
		if(ap == Week.Sunday)
			System.out.println("equal");
		
		switch (ap) 
		{
			case Sunday:
				System.out.println("Sunday");
				break;
			case Monday:
				System.out.println("Monday");
				break;
			default:
			break;
		}
		
		CoffeeSize coffeeSize;
		coffeeSize = CoffeeSize.HUGE;
		System.out.println(coffeeSize.getOunces());
	}
}
