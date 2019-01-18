package Practical_Code.Intro_Network;
/**
 * Created by ElHosany on 8/23/2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import static java.net.HttpURLConnection.*;

public class Access_Network
{
    public static void main(String[] args) throws IOException
    {
           /******      URL CLASS          ********/

        // [1]Creating URL
        URL url = new URL("http://www.google.com");   //http = protocol  www.google.com = host    default port = 80  no param
        URL url2 = new URL(new URL("http://www.google.com/"),"id=5");  //http://www.google.com/id=5

       // [2] Parsing URL (methods)
        System.out.println("Protocol = "+url.getProtocol());
        System.out.println("Authority = "+url.getAuthority());
        System.out.println("Host = "+url.getHost());
        System.out.println("Path = "+url.getPath());
        System.out.println("File = "+url.getFile());
        System.out.println("Port = "+url.getPort());
        System.out.println("Query = "+url.getQuery());
        System.out.println("Ref = "+url.getRef());

        //Making connection with webserver using socket is problematic when client computer connected to network using Proxy network that doesnt support this socket
        //Java provide Classes used for accessing HTTP servers Only
        // openStream method = > used to establish an HTTP socket connection , Return inputStream object which used to read data from HTTP socket Connection



        // [3] WebPage Retrieval
            InputStream obj = url.openStream();
            int c;
            while ((c = obj.read()) != -1)
            {
                System.out.print((char)c);
            }
            obj.close();


        //VIP NOTE = URL doesnt allow us to apply other parts of the http protocol as accessing header
        //    Class URLCONNECTION provide mechanism to access content also inspect properties of resource



        /******     URLCONNECTION CLASS   ********/

        /*
            URLConnection Class  represent an HTTP connection , method openConnection on url object
            establish an http socket to web server and return a URLConnection object that represent el connection
            method getInputStream  in URLConnection object also return webpage data

         */

        // [1] establish connection
        url = new URL("http://www.yahoo.com");
        URLConnection conn = url.openConnection();   //establish HTTP socket Connection

       // URLConnection x = new URL("http://www.yahoo.com").openConnection();    introduction to Code Simplest

        obj = conn.getInputStream();
        while ((c = obj.read()) != -1)
        {
            System.out.print((char)c);
        }
        obj.close();

        //Now Connection to remote server establish we need to inspect to properties of resource before transporting locally
        System.out.println(conn.getContentType());
        System.out.println(conn.getContentEncoding());
        System.out.println(conn.getContentLength());
        System.out.println(conn.getConnectTimeout());
        System.out.println(conn.getDate());
        System.out.println(conn.getExpiration());


        /********    HTTPURLConnection ********/
        //used to set http parameters and general request properties before making the connection
        //One of the useful task = Automatic redirection

        HttpURLConnection con =(HttpURLConnection) url.openConnection();
        System.out.println("Request URL .. "+url);
        int code = con.getResponseCode();  //by3rfne lma tlbt el request rad 3lya be 2eh

        if ((code != HTTP_OK) && (code == HTTP_MOVED_TEMP || code == HTTP_MOVED_PERM || code == HTTP_SEE_OTHER))
        {
            System.out.println("Response Code ..."+code);
            // code = 301 mean = Moved Permanently
            // code = 302 mean = Temporary Redirect
        }

        //get redirect url from "location" header field
        URL newurl = new URL(con.getHeaderField("Location"));   //conn.getHeaderField("Location")  redirect url
        con =(HttpURLConnection) newurl.openConnection();
        System.out.println("Redirect to ....."+newurl);

        //read data and store in StringBuffer
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuffer htmlstr = new StringBuffer();
        while ((line = in.readLine()) != null)
        {
            htmlstr.append(line);
        }
        in.close();

        System.out.println("Content ....\n"+htmlstr);
    }
}
