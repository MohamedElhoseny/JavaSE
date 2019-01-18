package Practical_Code.Intro_Network;

import java.io.IOException;
import java.net.*;
import java.util.List;

/**
 * Created by ElHosany on 8/23/2016.
 */
public class Access_Proxy_Network
{
    public static void main(String[] args) throws IOException, URISyntaxException {
        /*
          To Address security issue network administrator install special component called proxy server
          that manage connection between internet with internal network
         */

        //Java provide three ways to work with proxy (lma yb2a feh user byst5dm proxy 2zay a5le Application ysht8l 3ade m3 proxy)

        //Ex : if the proxy process run at port 8080 in machine having ip address 172.16.15.8

        /**   Using System properties **/

        System.setProperty("http.proxyHost","172.16.15.8");
        System.setProperty("http.proxyPort","8080");
        //if proxy neeed authentication
        System.setProperty("http.proxyUser","user");
        System.setProperty("http.proxyPassword","password");

        /**   using Proxy Class **/
        URL url = new URL("http://www.facebook.com");
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.15.8",8080));
        URLConnection conn =  url.openConnection(proxy);

        /**   PROXYSELECTOR  CLASS  **/

        //this class used if info about proxy is unknown or there are many proxies and we cant know anyone to use
        // this class provide => decide if a proxy should be used or not for a url being used
        // select one or more to be used ,  Manage failure when connecting to proxy server
        //getDefault()  return system-wide proxy selector


        System.setProperty("java.net.useSystemProxies","true"); //to use system proxy selector must set this property
        String u = "http://www.google.com";
         url = new URL(u);

        ProxySelector ps = ProxySelector.getDefault();  //return system proxy selector
        List<Proxy> proxies = ps.select(new URI(u));    //list of all proxy that we can select one to use

        System.out.println(proxies);  //lw shelt el property bta3t proxyhost msh  hla2e wla wa7d w hyktble direct

        //to select proxy first one and use it
        Proxy p = proxies.get(0);
        URLConnection con = url.openConnection(p);



        /**  perfect thinking */
        Proxy perfect = ProxySelector.getDefault().select(new URI(u)).iterator().next();
        con = url.openConnection(perfect);
    }

}
