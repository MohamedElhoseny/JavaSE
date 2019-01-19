package Practical_Code.interfacing;


public class Test1 implements IntStack
{
	private int[] mystack;
	private int tos;
	
	public Test1() {
		mystack = new int[jdk];  //try to use interface constants
		tos = 0;
	}
	
	@Override
	public void push(int item) {
		mystack[tos++] = item;
	}

	@Override
	public int pop() {
		return mystack[--tos];
	}
	
	public void printStack() {
		for (int i = 0; i < mystack.length; i++) {
			System.out.println(mystack[i]);
		}
	}
	
	//testing
	public static void main(String[] args) {
		Test1 stk = new Test1();
		
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		
		stk.popNElements(2);
		stk.printStack();
	}
}
