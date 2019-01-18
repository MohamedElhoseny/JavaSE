package Part_I;

import java.io.FileInputStream;

/*
   *   one properties of JVM that if an exception fire the flow of executation Stops 
   *   so Handling Exception the Main Role of succeeded Software
   * 
   **   Keywords : 
   *     try , catch , throw , throws , finally
   * 
   **   throwing Thread =>  y3ni jvm create object mn class exception w btbd2 t3rf asmo w line of code 2le 7sl feh el 
   *                        exception w b3d kda btshof 7aga asmha (handler) lw l2et handler btnfzo w btkml excutation 
   *                        of flow code ml2tsh handler le exception be te fire exception w yw2f el flow of excutation
   *                        
   **   syntax of handler :
   *         
   *            try
   *            {
   *                //code to inspect
   *            }
   *            catch (...)                 //Can have More than Catch statement
   *            {
   *               //code to handle the exception
   *            }            
   *            finally
   *            {
   *                //this will execute after try ..catch
   *            }
   *             
   **   Types Of Exceptions :  (checked) => y3ne el compiler by2dr yktshfo w ynbhk beh , (unchecked) => dh by7sl at Runtime
   *       note : all Exceptions extend from boss Class called : Throwable  and 2 class extend from it "Exception" , "Error"    
   *        1) Checked Exception : IO , SQL , EOF , FILENOTFOUND , MALFORMED ....
   *        2) Unchecked Exception "Runtime Exceptions" : NullPointer , security , Arithmetic , arrayindexoutofBounds ..  
   *        
   *               
   *    Note : also Java allow us to throw Exceptions as we want idea : if exception happen do something then throw the exception 
   *           try have more than one catch but only one finally          
   *    Q) Why we Need Finally ?  its perfect place to write clean Code as (closing file , Socket or Database Connection)  
   *    
   *            
   **   Custom Exception Classes : 
   *       see work of Exception on your specific work "in tracing files"
   *            
   *      Some Points :
   *        1- Checked Exceptions processed by Java Compiler 
   *        2- Unchecked Exceptions processed by Java interpreter(JVM)     
   **/

public class Exception_Handling 
{
     public static void main(String[] args)
     {
        try
	{
	   int x = 5 / 0 ; 
	} catch (ArithmeticException e)
        {
	 
	    System.out.println("Exception Throw While Calculating X :"+ e.getMessage());  //get error message
	}catch (NullPointerException e) {
	    System.out.println("Exception Throw While Calculating X :"+ e.getMessage());  //get error message
	}
        // Multiple Catch make code ugly if same handle we can combine
        
        try {
            int x = 5 / 0 ;
	} catch (ArithmeticException | NullPointerException e) {
	    System.out.println("Exception Throw While Calculating X :"+ e.getMessage());  //get error message
	}
        
        //throwing Exception
        
        try {
	    divide(5,0);
	} 
        catch (Exception e)
        {
	    // do actions before throwing Exception to user
            throw e;
	}
        finally 
        {
	    System.out.println("Code Thrown Succeded");
	}
        
        
        
        //Finally 
        try
            {
            FileInputStream s = new FileInputStream("omda.txt");
            try
            {
               //file operations
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            finally {
    	    s.close();
    	   }
        }catch(Exception e)      
        {
            System.out.println("handled");
        }
        
                    
     }
                     
     public static void divide(int x , int y)
     {
	 int z = x/y;
     }
}
