package Part_II;

/**
 * Created by ElHosany on 8/21/2016.
 */
public class Basic_NetworkProgramming
{
    /*
       Java Support 16-bit unicode for international character set
       Java Network Packages :
         [  java.net  ,  java.rmi  , java.mail(this must downloaded from oracle website)  ]
       * A Network Interface => is usually a Network interface Card [NIC] that act as the point of interconnection  between
                                computer and other devices

       Note : System often run with multiple network interfaces such as : Wired , wireless Ethernet , bluetooth

       [ NetworkInterface ]
       Application is usually used NetworkInterface to specify which NIC to use  for a particular network activity
       this class has no public Constructor but provide methods to retrieve details :
         getnetworkinterfaces() , getName() , getDisplayName() , .... etc

       [ InetAddress Class]
       IP Address is represented by this class , method getInetAddress()  return an enumeration of InetAddress

       [URL , URLCONNECTION , HTTPURLCONNECTION]

            Note => The primary classes to access the Network  URL (uniform resource allocator) which identify a resource
                  in the WWW   , HTTPURLCONNECTION

           URL EXCEPTION =>  MalformedException   examine the url format
           Malform of URL :   Protocol://host:[port] / [path [?param] [#anchor]]

           protocols => HTTP , HTTPS , FTP , File
           for http protocol default port = 80

        [URLEncoder , URLDecoder]
           what happen if the url string has spaces which not valid in url format or special chars as / , # , .
           or non ascii such as chineses , japanes .....
           => Java provide this two classes that encode url  and decode it  ex: #  => %23

     */
}
