package Part_I;

         /** Table of Content **/
/*      1-introduction
 *      2-motivation
 *      3-collection framework and generic
 *      4-type naming
 *      5-generic methods and constructor
 *      6-type inference
 *      7-bounded type parameter
 *      8-multiple bounds
 *      9-generic and subtype
 *      10-wildcards
 *         upperbound wildcards
 *         lowerbound wildcards
 *         unbounded wildcards
 *      11-wildcard and subtyping
 *      12-type erasure
 *      13-backward compatibility
 *      14-restrictions on generics
 * 
 */
 
public class Generic_Programming 
{
     /*  intro :
      *  java generic help us to detect more bugs at compile time and fix them 
      *  define :
      *    Generic allow us to parameterized Classes , Interfaces , Methods
      *    So its posible to write general purpose classes and methods that operate on object
      * 
      *   ClassCastException => dh exception be fire lma ab3t le class parameter w hwa bysht8l 3la no3 tane lw 3wz amn3 el problem dh p5le el parameter
      *                         brmoz msh String wla Object b7es 2ne ytb3tlo ay no3 dh lw ana 3wz kda  <t>  t->generic information
      *                         w bst5dmo gwa el class 3ade l2ne ana asln 3mlo generic 3shan ana b5do parameter w asht8l 3leh
      *                         remove all generic information using a process called "earsure" dh be delete all t w t7t mkano el Object Type aw ay 7aga hyb3tha
      *                         
      *    Some Notes :           wrapper<String> x = new wrapper<>();  kda el class dh kol el <T> httshal w tb2a string yb2a mynfsh ab3tlo integer
      *                                kda yb2a compilation error  la a3ml object gded  b2a  wrapper<integer> x = new wrapper<>()
      * 
      *     Used :   all Collection Framework use generic  also some interfaces as : Comparable
      *     
      *    Generic Term :
      *             list<E> , list<Integer> , <T extends Comparable> , list<?> , <? extends T> ,  <T extends Comparable<T>>
      * 
      *  Generic Methods : like classes and interface , methods including constructor may use type parameter and are called generic methods 
      *                    They are useful if we dont want to make the whole class generic
      *                     ex  :   <T> void print(T obj) { }    =>  myobj.print(new integer(2));  ,  myobj.print(new String("ok"));  , myobj.print(2);  //T is integer
      *                                   Same For Constructor   
      *    
      */

}
