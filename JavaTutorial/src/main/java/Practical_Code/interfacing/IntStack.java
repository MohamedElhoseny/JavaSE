package Practical_Code.interfacing;
/**
 * @author Elhoseni
 *
 */
public interface IntStack 
{
	void push(int item);    //by default : public abstract 
	int pop();

	int jdk = 11;	//by default : public static final
	
	default int[] popNElements(int n) {
		return getElements(n);
	}
	
	default int[] skipAndPopNElements(int skip, int n)
	{
		getElements(skip);
		return getElements(n);
	}
	
	private int[] getElements(int n)
	{
		int[] elements = new int[n];
		for (int i = 0; i < n; i++) 
			elements[i] = pop();
		
		return elements;
	}
	
	static void saySomething() {
		System.out.println("Hello from JDK 11");
	}
}
