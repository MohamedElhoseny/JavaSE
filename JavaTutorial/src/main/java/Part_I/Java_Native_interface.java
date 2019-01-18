package Part_I;

public class Java_Native_interface 
{
  /*     
    Java_Native_Interface [JNI] 
       allows java code to interoperate with applications and libraries writthen in other programming Language
    
    Native Methods
       -Lw 3wz el java program ye invoke method which implemented in different programming language
       -yb2a lazem el method 2le hndlha tb2a no3ha  (native) w dh 3mla zy keyword el abstract
    
    eg : public native void print();       // m3naha 2ne el implementation bt3ha m3mol mn other programming language
    
       -3han kda lazem el JVM ye load el library 2le feha implementation bta3 function deh 
    
    eg : using System.loadLibrary(test)  Method    suppose 2ne el library name is libtest.so
      OR use it to work with all library type (Load method)
       => System.load("/root/c/libtest.so");   or for dll library file
    
    Note : What's the Static Block ?
    eg :  public native void print();
        static {
          //load library    this means  2no el static block m3nah 2ne el 7aga dh htt3ml 2wl 7aga
        }
            
    ********************** See  First  JNITest file *****************************
    
    
    
    
    
    
 */   
}
