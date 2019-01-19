package Practical_Code.interfacing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Test2 
{
	/** Very Interesting way of coding ..
	 * @param list  
	 * @param valid
	 * @return a new list of selected element based on @param valid
	 */
	public static List<String> getBeginWith(List<String> list, Predicate<String> valid)
	{
		List<String> selectedList = new ArrayList<String>();
		
		Consumer<String> action = (s) -> {
			if (valid.test(s)) 
				selectedList.add(s);
		};
		list.forEach(action);  //for each element in list apply this action
		
		return selectedList;
	}
	
	public static void main(String[] args) 
	{
		//six basic generic functional interfaces
		
		//BinaryOperator
		BinaryOperator<Integer> binaryOperator = (var1 , var2) -> {
			return var1 * var2;
		};
		int result = binaryOperator.apply(10, 5);
		System.out.println(result);
		binaryOperator = (var1, var2) -> {
			return var1 / var2;
		};
		result = binaryOperator.apply(10, 5);
		System.out.println(result);
		
		//UnaryOperator
		UnaryOperator<Double> unaryOperator = (t) -> 3.14 * ( t + t );
		double r = unaryOperator.apply(2.5);
		System.out.println(r);
		
		//Consumer
		Consumer<Integer> consumer = (var) -> {
			//do anything with this object 
			//invoke a method of the object
			//return void
			System.out.println(var);
		};
		consumer.accept(12);
		consumer.accept(25);
		
		//Function<T, R>
		Function<Integer, String> function = (t) -> {
			return t.toString();
		};
		System.out.println(function.apply(25555));
		
		//Predicate
		Predicate<String> predicate = (s)->{
			return s.contains("java");
		};
		
		if(predicate.test("Hello from java"))
			System.out.println("True");
		
		//Supplier
		Supplier<ArrayList<Integer>> supplier = () -> {
			return new ArrayList<Integer>();
		};
		ArrayList<Integer> myList = supplier.get();
		
		main2(args);
	}
	
	public static void main2(String[] args) 
	{
		String[] names = {
			"Mohamed", "Ahmed", "Omar", "Yasmin", "Salma"
		};
		
		List<String> list = Arrays.asList(names);
		
		System.out.println(getBeginWith(list, (s) -> s.startsWith("M")));  //changing condition flexible
		System.out.println(getBeginWith(list, (s) -> s.contains("ma")));
		System.out.println(getBeginWith(list, (s) -> s.endsWith("d")));
	}
}
