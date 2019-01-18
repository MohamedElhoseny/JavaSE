
package Practical_Code.JNI;

public class JNITest1 
{
    public native void print();
    static {
       System.load("D:/FCIH/Self-Study/Java/Projects/Advanced Java/JavaSE/src/Practical_Code/JNI/library.c");
    }
}
