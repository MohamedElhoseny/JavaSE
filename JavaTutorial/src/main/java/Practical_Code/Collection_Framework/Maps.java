package Practical_Code.Collection_Framework;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
/*                      Maps interface ..
 *    a set key-value pairs  where key is unique so we can get value using this key 
 *    map define new methods : put() , get() and containskey() , conatainsvalue() , ...
 *                      Classes implement Maps interface :
 *           HashMap , LinkedHashMap  ,  HashTable ,  TreeMap (implement from [Sorted Map] which implements map)
 *      Java provides : Hashmap , LinkedHashMap(contains HashTable and linkedlist) , TreeMap
 */
public class Maps 
{
    public static void main(String[] args)
    {
    	Hashmap();
    }

	public static void Hashmap() 
	{
		/*
		 * the advantage of hashmap it offer constant time O(1) performance
		 * for operations : add() , get() , remove() , size()
		 * 
		 * Map syncMap = Collections.synchronizedMap(new HashMap());
		 * we may use  java.concurrent.ConcurrentHashMap  more safely in hashmap multithread
		 */
		
		HashMap<Object, Object> m = new HashMap<>();   //not safe  in multi-thread
		Map xx = Collections.synchronizedMap(new HashMap<>());     //Thread-safe
		Map<Object,Object> xxx = new ConcurrentHashMap<>();   //more safe

	    /** put , get  **/	
		m.put(1001, "omda");
		m.put(1002, "boba");
		m.put(1003, "omar");	
		String x = (String) m.get(1002);
		System.out.println(x);
		
		/** containskey() , containsvalue() **/
		if (m.containsValue("omar") && m.containsKey(1001)) {
			System.out.println("found");
		}

		/** keySet , values()  **/
		//why use Set for Keys and collection for Values ???? answer ..

		Set<Object> s = m.keySet();    //have now all keys in set
		for (Object o : s) {
			System.out.println(o+"->"+m.get(o));
		}
		
		Collection<Object> c = m.values();
		for (Object object : c) {
			System.out.println(object);
		}

		/** entryset  **/
		Set entries = m.entrySet();  //entrySet => get all keys and values as table
		for (Object object : entries)
		{
			Entry e = (Entry) object;  //3mlt assign le object mn no3 entry(as table)  3shan afr2hm 3n b3d w atb3hm
			System.out.println(e.getKey() +"->"+ e.getValue());
		}
		
		System.out.println("printing entrySet of HashMap :");
		System.out.println(m.entrySet());
		
		/** remove and clear **/
		m.remove(1001);
		m.clear();
	}
    public static void Linked_Hashmap()
    {
    	// It provides the predictable iteration order
    	//note : iteration time of this proporional to size of map no capacity as HashMap
		// better(y3ne bylf belzbt 3la elements 2le gwa lw feh indexes fadya msh byge n7ytha)
    	//slightly slower than hashmap  bs msh mhm l2no el running time bta3h constant brdo
    	Map orderedmap = new LinkedHashMap();
    	Map<Object, Object> safe = Collections.synchronizedMap(new LinkedHashMap<>());
    	
    	//same operations
    }
    public static void Treemap()
    {
    	/*
    	 *  First it implement SortedMap takes log(n) "sre3a" for operation ,also its a model of sorted map at which entries[Data] are sorted according to
    	 *  natural ordering or using Comparator interface on your class  so it sort according it this is the using of Comparator interface
    	 *   yb2a lma a3oz Map h7ot feh data w 3wzhm ytrtbo fe map be sort m3yn asht8l be TreeMap
    	 *   Methods : firstkey() , lastkey() , headmap(), tailmap() , put() ,get() ,remove() , containskey() also keySet() , entrySet()
    	 */
    	
    	SortedMap<Object, Object> sm = new TreeMap<>();
    	
    	sm.put(1001, "omda");
    	sm.put(1002, "boba");
    	sm.put(1003, "omar");
    	
    	System.out.println(sm.firstKey());
    	System.out.println(sm.lastKey());
  
    }
    public static void HashTable()
    {
    	Hashtable<String, Integer> f_H = new Hashtable<>();
    	f_H.put("A", 3);
    	f_H.put("B", 2);
    	f_H.put("C", 8);
    	
    	f_H.remove(String.valueOf("A"));
    	System.out.println(f_H);
    }


    //When to use Hashmap and HashTable ??
}