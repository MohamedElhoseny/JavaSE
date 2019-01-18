package Practical_Code.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy_Security implements InvocationHandler
{
	Object Target;
    public Proxy_Security(Object t) 
    {
        this.Target = t;
	}
    
    
    /** Intercept (prevent to execute or pause or wait) , Inspect (Check for parameters or Check for anything before invoke) , Modify (modify args then Send) */
    
    
 	@Override     //hna hwa msh byst2bl el object 2le feh ha access el method hst2blo fe Constructor w ast5dmo1      
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable 
	{
		double start = System.nanoTime();
		
		Object o = m.invoke(Target, args);  //hya dh el invoke
		
		double ellapseTime = System.nanoTime() - start;
		System.out.println(m.getName() +"() took "+ellapseTime+" ns");
		
		return o;
	}

}
