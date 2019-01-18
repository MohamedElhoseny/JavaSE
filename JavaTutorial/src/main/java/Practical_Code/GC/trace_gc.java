package Practical_Code.GC;

public class trace_gc 
{
    protected void finalize()   //must be protected if public it will work but say protected is required
    {
    	System.out.println("Object is Garbage Collected !");
    }
}
