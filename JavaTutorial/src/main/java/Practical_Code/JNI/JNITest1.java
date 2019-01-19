
package Practical_Code.JNI;

public class JNITest1 
{
    public native void print();
    
    static {
       System.load(JNITest1.class.getResource("library.c").toString());
    }
}
