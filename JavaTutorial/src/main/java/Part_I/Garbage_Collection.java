package Part_I;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import Practical_Code.GC.trace_gc;


/*                   HotSpot JVM  Collectors :
*         serial , parallel , parallel compact , concurrent  
*   
*     serial Collector = used single thread to perform all garbage collection works , young and old collect serially in a stop
*                        the world fashion (stop execution until finish)
*                         => used for application in a uni-processor system , the strength of this collector lies in its single thread 
*                            as there is no communication overhead between threads 
*                            
*     parallel Collector = serial is not good solution for heavily application that used multi-threaded having large memory , in that case
*                          parallel collector give better performance than serial                      
*                          => used for applications having medium to large sized data sets that are run on multiprocessor or multi-thread
*                             application ,,  having pause time constraints should not use this collector
*                          => collect young collection by multi thread while old still with single thread   
*
*     parallel compacting = the single thread in parallel collector still degrade performance , parallel compaction allow minor collection even
*                           to collect in parallel 
*                           => Applications having pause time constraints may use this collector as it reduces old generation collection time.
*                           
*     Concurrent Collector = as serial , parallel , parallel compact  Collectors   are stop-the-world  Collectors this mean that they suspend
*                            the application until garbage collector do its task , [ This may be not acceptable for application for which 
*                            Response time is much more important
*                            
*                  Commands to Select Collector :
*                    java -XX:+UseSerialGC 
*                    java -XX:+UseParallelGC  
*                    java -XX:+UseParallelOldGC  
*                    java -XX:+UseConcMarkSweepGC       
*                            
*/



/*                      Some Commands..
 * 
 *      1- print information about GC used :         java -XX:+PrintGCDetails  -version
 *      2- Storing GC information in a file gc.txt : java -XX:+PrintGCDetails -Xloggc:gc.txt -version
 *      3- Show all VM related settings:             java -XshowSettings:vm �version
 *      4- Set maximum Java heap size 120 MB and show VM settings:    java -Xmx120m -XshowSettings:vm �version
 *      5- Set maximum Java heap size 2 MB and print VM details:      java -Xmx2m -XX:+PrintGCDetails �version
 * 
 */


/*
 *            Accessing GC from Java program :
 *      althought , not powerful , we can interact with GC within program such as : inspecting some parameters , invoking garbage collector
 *            
 *       1) inspecting GC parameters :
 *            using the class -> java.lang.Runtime  that corresponds to a JVM
 *            some methoud provide : public long maxMemory()
 *									 public long totalMemory()
 *									 public long freeMemory()
 *    
 *       2) invoking garbage collector :
 *           An  application  can  invoke  the  garbage  collector  explicitly  using  static  gc()   method  of  System  class.
 *           .:. A call to this method causes a major collection. 
 *               System.gc()  is equivalent to  Runtime.getRuntime().gc()
 *               
 *        Note : 
 *           Since,  gc()  always causes a major collection to be done even if a minor collection is sufficient, it 
 *				may greatly impact the performance. Usually, JVM�s determination of when it is appropriate is better. 
 *		    	So, [invoking garbage collector explicitly should be avoided]. If there are still problems related to pause 
 * 				time or others, the parameters of the collector may be carefully selected instead. The JVM may be 
 *				instructed to ignore the explicit call to a collector using  gc()  using  -XX:+DisableExplicitGC  option.       
 */
public class Garbage_Collection 
{	
	/*        VIP Note:
	 *  This program creates an unnamed object and calls the garbage collector explicitly using  System.
     *	gc() . Since the object has no reference pointing to it, it is a garbage object and is collected by the 
	 *	garbage collector. The collector calls the  finalize()  method before collecting it.
	 */
    public static void main(String[] args) throws Exception
    {
    	new trace_gc();
        //System.gc();  same
    	Runtime.getRuntime().gc();  //Garbage Collection occur
    	
    	
    	
    	//Execute Command and get result  [see tables of commands]
    	Process x = Runtime.getRuntime().exec("java -XX:-PrintGCDetails"); 
    	BufferedReader stdInput = new BufferedReader(new InputStreamReader(x.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(x.getErrorStream()));
        
        String s;
        while (( s = stdInput.readLine()) != null)
        {
            System.out.println(s);
        }
        //3shan lw cmd tl3t error yktbhole
        while (( s = stdError.readLine()) != null)
        {
            System.out.println(s);
        }
        
    }
}
