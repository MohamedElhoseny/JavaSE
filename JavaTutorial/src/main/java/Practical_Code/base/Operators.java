package Practical_Code.base;


import java.util.function.Predicate;

public class Operators 
{
	public static void main(String[] args) 
	{
		//Arithmatic operators
		int x = 5;
		int y = 12;
		
		int r1 = y / x;
		double r2 = y / x;   //no fraction component as expression is INTEGRAL and assignment is last operator done
		System.out.println(r1+ " , "+r2);
		
		double r3 = y / (double) x;  //casting any variable in expression change it to Double expression
		System.out.println(r3);
		
		//Bitwise operators
		int a = 60, b = 13;
		System.out.println("Bitwise AND = "+(a & b));   //bitwise AND or anything return result not boolean
		System.out.println("Bitwise OR = "+ (a | b));
		System.out.println("Bitwise NOT = "+(~a));
		System.out.println("Bitwise XOR = "+(a ^ b));
		System.out.println("a << 2 = "+(a << 2));  //shift left means  multiply 
		System.out.println("a << 2 = "+(a >> 2));  //shift right means  divide
		System.out.println("a >>> 2 = "+(a >>> 2)); //shift right with fill zeros
		
		//Boolean logical operators
		a = 100;	b = 50; 
		
		if(a < b && ++a > 60) //short-circuit AND : (If exp1 is false So no need to execute exp2)
			System.out.println("Condition True : a = "+a);
		else 
			System.out.println("Condition False : a = "+a);
		
		if(a < b & ++a > 60) //Logical AND : (exp1 and exp2 will be executed under any condition)
			System.out.println("Condition True : a = "+a);
		else 
			System.out.println("Condition False : a = "+a);
		
		a = 100;	b = 50; 
		
		if(a > b || ++a > 60) //short-circuit OR : (If exp1 is true So no need to execute exp2)
			System.out.println("Condition True : a = "+a);
		else 
			System.out.println("Condition False : a = "+a);
		
		if(a > b | ++a > 60) //Logical OR : (exp1 and exp2 will be executed under any condition)
			System.out.println("Condition True : a = "+a);
		else 
			System.out.println("Condition False : a = "+a);
		
		//Ternary operators
		int c =  a > b ? 1000 : 10;
		System.out.println(c);
		
		//Relational operators 
		boolean res = a >= b;
		//int res = a >= b;    outcome of relational is boolean
		System.out.println(res);
		
		
		//instanceof operator  (check for type of object in hierarchy)
		String objString = "Java";
		
		if(objString instanceof CharSequence)
			System.out.println("Object objString is instance of CharSequence so it can be cast safety");
		
		//arrow operator ( lambda expression is an anonymous method )
		Predicate<String> stringPredicate = (s) -> s.equals("Java"); 
		
		boolean isequal = stringPredicate.test(objString);
		if(isequal)
			System.out.println("String is equal !");
	}

}
