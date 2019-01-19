package Practical_Code.base;

public class DataTypes 
{

	public static void main(String[] args) 
	{
		// Integers types
		byte b  = 2;    // 8  bit
		short s = 5;	// 16 bit (2 byte)   
		int x   = 5;	// 32 bit (4 byte)   -> default = 0
		long l  = 175;	// 64 nit (8 byte)

		x = 012;   // OCTAL
		System.out.println("Octal representation : "+x);  // 2 * pow(8, 0) + 1 * pow(8, 1) = 2 + 8 = 10
		
		s = 0x23;  // HEXA
		System.out.println(s);
		
		l = 15;  // by default will check if it can store in INT (4 byte) and store it in 4 byte 
		l = 15L; // same but forcing to store 15 in 8 byte
		System.out.println(l);
		
		/* start with JDK 7 */
		x = 0b1010; // BINARY
		System.out.println(x);
		x = 123_456_789;  //123456789
		System.out.println(x);
		x = 0b1101_0101_0001_1010; //54554
		System.out.println(x);
		
		// Floating types
		float f1  = 3.5f;  //without F or f means its double  (default = 0.0)
		double d1 = 10.5;
		
		// Character types
		char c1 = 'a';  //reserve 1 byte and set second to zero
		char c2 = '\u1F72';
		System.out.println(c2);
		
		// Boolean types
		boolean b1 = true;
		//boolean b2 = 0; Incompatible in JAVA
		
		//Casting...
		int v1 = 2;
		byte v2 = 3;
		long v3 = 25;
		char v4 = 'd';
		boolean v5 = true;
		
		v1 = v2;  //widening conversion
		v2 = (byte) v1;  //narrowing conversion
		//v4 = v2;  NO numeric types to char 
		//v5 = v2;	No numeric type to boolean
		
		double var1 = 2.55555, var2 = 2.55555;
		if (var1 == var2) {
			System.out.println("equal");
		}
		
		outer: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 2) 
					break outer;
				
				System.out.println(j);
			}
		}
	}

}
