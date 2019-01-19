package Practical_Code.base;


import java.util.function.Predicate;

public class Test 
{
	
	private static class Person{
		int age;
		float height;
		boolean result;
		String name;
	}
	
	public static void main(String[] args) 
	{
		Person x = new Person();
		System.out.println(x.age+","+x.height+","+x.result+","+x.name);
		
		int xx = 1;
		System.out.println(xx++ + ++xx + ++xx);
		
		int a = 0;
		int b = 100;
		
		Predicate<Integer> compare = (var) -> var++ == 10;
		//if(!b++ > 100 && compare.test(a)) 
		//	System.out.println(a+b);
		
		
	}

}
