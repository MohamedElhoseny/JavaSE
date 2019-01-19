package Practical_Code.interfacing;

@FunctionalInterface
public interface MyFunctionalInterface 
{
	public void printMsg();

	// public void fun2(); violate concept of function interface

	@Override
	String toString();		// adding inherited object method allowed : Compiled

	@Override
	boolean equals(Object obj);
}
