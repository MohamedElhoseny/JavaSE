package Practical_Code.Socket_Programming.Multicasting;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by Elhosany on 9/6/2016.
 */
public class Receiver
{
    public static void main(String[] args) throws Exception
    {
        //Now this is as people who connect to beinSport and ready to receive Packets Send from BeinSport
        MulticastSocket socket = new MulticastSocket(6001);
        socket.joinGroup(InetAddress.getByName("224.0.0.1")); //join this group and receive packet sent to it

       while (true)
       {
           byte[] rdata = new byte[256];
           DatagramPacket packet = new DatagramPacket(rdata, rdata.length);
           socket.receive(packet);
           String rmsg = new String(rdata, 0, packet.getLength());
           System.out.println(rmsg);
       }
    }
}
