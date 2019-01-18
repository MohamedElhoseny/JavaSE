package Part_I;

public class java_XML 
{
    /*     
        XML => Extensible Markup Language that used for Structured Data representation
        DOM => Document Object Model standardized by World Wide Web Consortium (W3C)
               used to represent [Parsing] XML documents
        W3C DOM => Divided into : DOM CORE , XML DOM , HTML DOM
    
                   ...... XML DOM .....
    
        Relations in XML DOM Tree:
           1- Element Node => represent by Circle
           2- Text Node =>  represent by Square
           3- Attribute Node => represent by borderedSquare
    
    ex :
        <Capacity unit='GB'> 80 </Capacity>    
         <capacity> => element node 
          unit='GB' => Attribute node
             80     => Text Node
        
        DOM Tree consists of many type of Node :
         FirstChild , lastChild , nextSlibling , previousSlibling
         fundamental of Node type defined in => Node Interface
       
    
 =>=>  Node Types : DOM Node , Document Node , Element Node  .. etc (TextNode)
       
         1) DOM Node :
            define 12 type of node el 2sasyeen : Document , DocumentFragment , DocumentType , EntityReference , Element , ATTr 
                                                 Comment , Text , CDATASection , Entity , Notation
    
    ______________________________________________________________________________________________________________________________
       *
      * * Node Interface => all types of nodes Inherit The Node Interface Properties and Methods
          --------------
          _||_ Property in Node Interface :
             
              1-nodeType : java provides getNodeType() method that return type of Node
    
                    * some Constant Defined to Check for Node type :
                       ELEMENT_NODE , ATTRIBUTE_NODE , TEXT_NODE 
                     ex :  if( n == Node.ELEMENT_NODE )    // check if the Node is Element  
    
              2-nodeName : java provides getNodeName() method that return Node name  eg:Capacity
              3-nodeValue :  //  //   // getNodeValue() //   //    //     Node Value eg: 80
    
            EX : 
                <html>
                    <head>  
                       <title> </title>  
                    </head> 
                     <body> 
                        <p> this is a paragraph </p> 
                    </body> 
               </html>
                
               Note :  document.documentElement => return reference to the root Element 
     
              4-ChildNodes : this return an array of all child nodes of specific element and can access by ChildNodes[0] ..
                    on EX :
                       <html> is referenced as document.documentElement
                       document.documentElement.ChildNodes  is an array of Child nodes of <html> element
                         SO :
                       document.documentElement.ChildNodes[0]  =  <head>
                       document.documentElement.ChildNodes[1]  =  <body>
               -firstChild , lastChild 
                       document.documentElement.firstChild = <head>
                       document.documentElement.lastChild  = <body>
    
               -nextSlibling , previousSlibling 
                      document.documentElement.firstChild.nextSlibling     = <body>      //2le b3d head
                      document.body.previousSlibling = <head>                            //2le 2bl el body
    
              5-attribute :
                      document.body.attributes["color"].nodeValue          //return value of attribute  lesa fe Element Node hyb2a feh functions le kol info bta3t Node
    ____________________________________________________________________________________________________________________________________
    
       2) Document Node :
           some properties in Document Node : domConfig , inputCoding , xmlEncoding ..
           some methods in Document Node : createAttribute , CreateComment , CreateElement , getElementById , getElementByTagName
                    -this found only in Document Node  (Created from Document interface)
                                      
       3) Element Node : 
           properties => tagName    eg:  <birthday>  tagName=birthday
           Methods => getAttribute , hasAttribute , getElementByTagName , removeAttribute , getAttributeNode ,removeAttributeNode , setAttribute , setIdAttribute
                   -this found only in Element Node  (Created from Element interface)
    
       4) Text Node : 
             properties :  WholeText , isElementContentWhiteSpace
             Methods    :  replaceWholeText
                -this found only in Text Node  (Created from Text interface)
    
       5) Attr Node :
            properties :  isId , name , ownerElement , Value
    
     
               =====================================  Now Lets Go Practical_Code Package to Navigate and Manipulate With XML DOM  Document =====================
   
    note : for any property abc  there is a method getabc() in java 
    */                                                                  
}
