package Practical_Code.interfacing;

interface Jumpable{
	int h = 1;
	default void x() {
		System.out.println(h);
	}
}

interface Moveable{
	int h = 2;
	static void x() {
		System.out.println(h);
	}
}

public class Test3 implements Jumpable, Moveable
{
	int h = 3;    //interface constants can be used by interfaces
	public Test3() {
		x();
	}
	public static void main(String[] args) 
	{
		Jumpable j = new Test3();
		Moveable m = new Test3();
		Test3 t = new Test3();
	}
}
