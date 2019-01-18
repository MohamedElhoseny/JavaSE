package Practical_Code.Intro_Network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Getting_Interface_Addresses
{
   public static void main(String[] args) throws SocketException
   {
       System.setProperty("Java.net.preferIPv4Stack","true");

       Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
       while (interfaces.hasMoreElements())
       {
           NetworkInterface intf = interfaces.nextElement();
           Enumeration<InetAddress> addresses = intf.getInetAddresses();
           if (addresses.hasMoreElements())
           {
               System.out.println("Name = "+intf.getName());
               System.out.println("Display Name = "+intf.getDisplayName());
               /** NetworkAddress has sereral methods to get info about network Properties */
               System.out.println("is Up : "+intf.isUp());
               System.out.println("is Loopback : "+intf.isLoopback());
               System.out.println("is PointToPoint : "+intf.isPointToPoint());
               System.out.println("is Virtual : "+intf.isVirtual());
               System.out.println("SupportMultiCast : "+intf.supportsMulticast());

               while (addresses.hasMoreElements())    //one network interface can assign more than one address
               {
                   InetAddress add = addresses.nextElement();
                   System.out.println("Address = " +add.getAddress()  + "OR" +add); //add tmam
                   System.out.println("Canonical Host Name = "+add.getCanonicalHostName());
                   System.out.println("Host Name = "+add.getHostName());
                   System.out.println("Host Address = "+add.getHostAddress());  //tmam
               }

           }

       }
   }
}
