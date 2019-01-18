package Practical_Code.Intro_Network;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Getting_Network_Interface
{
    public static  void main (String[] args) throws SocketException
    {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();  //return NICs

        while (interfaces.hasMoreElements())
        {
            NetworkInterface intf = interfaces.nextElement();   //lazem a3ml reference mn no3 el NetwrokInterface 3shan access el methos
            System.out.println(intf.getName());
            System.out.println(intf.getDisplayName());

            List<NetworkInterface> wireless = new ArrayList<>();   //list of wireless drivers by me
            if(intf.getName().startsWith("wlan"))
            {
                System.out.println("Wireless NIC found !");
                wireless.add(intf);
            }

        Enumeration<NetworkInterface> subintf = intf.getSubInterfaces();
        for (NetworkInterface i: Collections.list(subintf))
        {
            System.out.println(i.getName());
            System.out.println(i.getDisplayName());
        }
    }

    }
}
