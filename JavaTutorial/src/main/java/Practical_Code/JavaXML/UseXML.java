package Practical_Code.JavaXML;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

//javax.xml.parser  Package to Create Document Object from org.w3c.dom.Document 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//org.w3c.dom Package for DOM NODE : DOM CORE , XML DOM NODE ,HTML DOM
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class UseXML 
{
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException
    {
         //to access DOM tree for XML document we have to create Document Object
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();    //parser =>  t7lel
        Document doc = parser.parse(UseXML.class.getResourceAsStream("XmlDoc1.xml"));            // h3ml t7lel le file XmlDoc1.xml
        
        
        Navigating_XMLDOM(doc);
    }

    public static void Navigating_XMLDOM(Document doc) throws TransformerException, FileNotFoundException
    {
            /******* 1)  Navigating DOM Tree *******/               //navigating => 2ltnkol

        
        /****** using one of three ways :
           1- using root element
           2- using getElementById method of the Document Object
           3- using getElementByTagName  method of  Document Object
        ***************************/
        
        //note : m3na 2no print null 2ne el 7aga deh read-only
        
      //  1) using root element  
        Element root = doc.getDocumentElement();  
        String x = root.getNodeName();
        System.out.println("Root Element Name = "+x);
        
        Node n = root.getFirstChild();
          x = n.getNodeName();
        System.out.println("First Children of Root Node = "+x);    //textNode [mtb3sh el data tb3 Text Node Code ?? solve later]
        
        //Getting all Child Nodes 
        NodeList children = root.getChildNodes();    
       
        for(int i=0; i<children.getLength(); i++)
        {
            //check node type
            Node z = children.item(i);     
            if(z.getNodeType() == Node.ELEMENT_NODE)   //children.item(i).getNodeType()
            {
                System.out.println("element node found : "+z.getNodeName() );
            }
        }
        
       // 2) using getElementByTagName method  
        
        NodeList nl  = root.getElementsByTagName("body");
        
        System.out.println("Number of Children in body element = "+nl.getLength());  //1
        for(int i=0; i<nl.getLength(); i++)
        {
            Node nn = nl.item(i);
            System.out.println("Node["+i+"] Name Found in body Children : "+nn.getFirstChild().getNodeName());
            System.out.println("Node Value of this node : "+nn.getFirstChild().getNodeValue());
            System.out.println("Node type of this node : "+nn.getFirstChild().getNodeType());
        }
           
       // 3) using getElementById method  "VIP Note Here Solves Problems Before"
        
        Element e = doc.getElementById("q1");    //kda dh rg3le reference 3la element dh  <question id="q1"> What is DOM ?</question>
        String value = e.getAttribute("id");   //print q1
        System.out.println("After Using getElementById :  \n Value of attribute 'id' = "+value);  //ok

        value = e.getNodeValue();     //print What is DOM ?  
        System.out.println(value);    // ^_^ no tb3 Null
        value = e.getFirstChild().getNodeValue();  //3la el 2sas 2ne What is Dom? deh attribute node fy3tbr child le <question>
        System.out.println(value);

        System.out.println("Element Type = "+e.getNodeType());  // print 1 3shan deh Element ? 
        System.out.println("Child Element Type = "+e.getFirstChild().getNodeType());  //print 3 3shan dah type bta3 text node
        
        System.out.println("Getting Attributes...");
        NamedNodeMap attr = e.getAttributes();
        for(int i=0; i <attr.getLength(); i++)
        {
            System.out.println("Attribute : "+attr.item(i).getNodeName()+" Value = "+attr.item(i).getNodeValue()); //ok
        }
        
        /** how to Transform DOM Tree and display them***/
        TransformerFactory tfactor = TransformerFactory.newInstance();
        Transformer transformer = tfactor.newTransformer();
        
        DOMSource source = new DOMSource(root); //mn 2wl el root node
        StreamResult result = new StreamResult(System.out);  //aw aktb bdl System.out  new file("")  hyktbhm fe file tane
        transformer.transform(source, result);  //2n2l kol el source le result
        
        //we mmoken bganb 2ne a display xml document aw a7oto fe file  MMKEN kman ashelo kolo fe String
        StringWriter sw = new StringWriter();
         result = new StreamResult(sw);  //aktbhmle fe StringWriter
         transformer.transform(source, result);
         System.out.println(sw); //ok 

        /* Create xml file and write data to it again */
         FileOutputStream out = new FileOutputStream("StoreData.xml");
         result = new StreamResult(out);
         transformer.transform(source, result);
    }
    
    public static void Manipulating_XMLDOMTree(Document doc) throws TransformerConfigurationException, FileNotFoundException, TransformerException
    {
        /* Manipulating DOM Tree Means => add , delete , modify nodes in DOM Tree
        
***************************  1) Adding Node *************************************
        
          Steps :
             1- Creating Element Node
             2- Create Text Node 
             3- Setting Attributes
             4- Adding a Node to Root
         */
        
          Element root = doc.getDocumentElement();  //root of document
          
          Element e = doc.createElement("question");
          Text t = doc.createTextNode("What is DTD");
          e.setAttribute("id", "q3");
          e.appendChild(t);     //aho dh byzbt lma age a2ol e.getfirstChild.getNodeValue(); hygeb Text             
          root.appendChild(e);   //deft el Node le Root typ lw 3wz 2dfha fe node m3yna bgeb reference le node 2le 3wzha mn NodeList w aktbha mkan root
          
          Element e2 = doc.createElement("question");
          e2.setAttribute("id", "q4");
          e2.appendChild(t);
          /*el mara deh 3wz a7otha 2bl 7aga aw b3d node m3yana*/
          NodeList questions = doc.getElementsByTagName("question");
          Node _1st = questions.item(0);
          root.insertBefore(e2, _1st);
          
         //ana w2ft hna w msh la2e t2ser 3la file ?
         //l2n 2nta kda bt3ml DOM Tree w msh bt7tha fe file aw be display 7ta
          
         TransformerFactory factory = TransformerFactory.newInstance();
         Transformer transformer = factory.newTransformer();
         
         DOMSource source = new DOMSource(root);  //bnsaha lazem ab2a 3arf 2ne el transform byn2l data mn source le destination
         
         FileOutputStream out = new FileOutputStream("./src/Practical_Code/JavaXML/XmlDoc1.xml");
         StreamResult result = new StreamResult(out);
         
         transformer.transform(source, result);
     
      /************** 2) Deleting Node ********************/
         NodeList nl = doc.getElementsByTagName("question");
         Node n = nl.item(0);
         root.removeChild(n);  //using removeChild Method
         
      /************* 3) Cloning node ************************/
          n = nl.item(1);
          Node acopy = n.cloneNode(true);
          //since id is unique
          ((Element)acopy) .setAttribute("id", "q123");    //without Casting i can not get method think think think plz
          root.appendChild(n);
    }

    public static void Validating_DTD() throws ParserConfigurationException, SAXException, IOException
    {
        //we can validate that DTD written correctly to insure Constraint of unique id
        //Question : WHAT is DTD Specification ?
        // SOL : DTD tells that every <question> in my file must have a id attribute but no id attr specified for Last <question>

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

        f.setValidating(true);   //Validate DTD Constraint

        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.parse("./src/Practical_Code/JavaXML/XmlDoc1.xml");

        /*  DTD Scheme
          <!DOCTYPE root[
          <!ELEMENT root (question+)>
          <!ELEMENT question (#PCDATA)>
          <!ATTLIST question #REQUIRED>
          ]>

        */

        //hna fe el error by2ole 2ne feh wa7d msh el a5er w msh mktoblo id attribute kda tmam
    }
}
