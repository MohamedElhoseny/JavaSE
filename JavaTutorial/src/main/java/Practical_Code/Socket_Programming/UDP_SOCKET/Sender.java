package Practical_Code.Socket_Programming.UDP_SOCKET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by Elhosany on 9/4/2016.
 */
public class Sender
{
    public static void main(String[] args) throws IOException
    {
        byte[] sbuff = new byte[1024] , rbuff = new byte[1024];
        DatagramSocket socket = new DatagramSocket();

        System.out.println("Enter Number to Get its factorial : ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        int fact = Integer.parseInt(input);
        sbuff = String.valueOf(fact).getBytes();

        /* How to get InetAddress object ?  the answer of this question was  InetAddress.getByName()*/
        DatagramPacket packet = new DatagramPacket(sbuff,sbuff.length, InetAddress.getByName("localhost"),6001);  //for sender
        socket.send(packet);
        System.out.println("Packet encapsulated and Sent to Server !");

        //Create another packet to receive responsing packet
        DatagramPacket rpacket = new DatagramPacket(rbuff,rbuff.length);   //for receiver
        socket.receive(rpacket);
        System.out.println("Received a Packet from  Server !");

        System.out.println("decapsulating Received Packet ..");
        //String output = rbuff.toString();     Not Correct
       // String output = new String(rbuff,0,rbuff.length);   Correct
        String output = new String(rpacket.getData(), 0 , rpacket.getLength());  //Responsive  as i read all data found not all 1024 in array as previous
        System.out.println("Result Received = "+output);

    }
}
