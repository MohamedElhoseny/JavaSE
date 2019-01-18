package Practical_Code.Socket_Programming.UDP_SOCKET;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver
{
    public static void main(String[] args) throws IOException
    {
        byte[] send_buffer = new byte[1024] ,
               receiver_buffer = new byte[1024];
        //Create a Server Socket at port 6001
        DatagramSocket socket = new DatagramSocket(6001);
        System.out.println("Server Ready ..");
        DatagramPacket receive_packet = new DatagramPacket(receiver_buffer,receiver_buffer.length);  //for receiver
        socket.receive(receive_packet);  //Start Listening
        System.out.println("Packet received From Client !");

        /* extract data from packet and also get Sender or Client info to use them to Send Packet to it again */
        System.out.println("Extracting Packet Data ..");
        String data = new String(receive_packet.getData(),0,receive_packet.getLength());

        //first method in DatagramPacket .;. getData() => return byte[] of Data in the Packet
        //String Constructor get array of byte and offsets(from , to)

        System.out.println("Extracting Client info ..");
        InetAddress addr = receive_packet.getAddress();  //ip
        int port = receive_packet.getPort(); //port

        System.out.println("Working ..");
        int n = Integer.parseInt(data);  //l2n ana 3rf 2ne sh8al w bgeb el factorial
        int factorial = getfactorial(n);

        send_buffer = String.valueOf(factorial).getBytes();      /* very important String method*/
        //getbyte of anytype  int,double ,char[] ,..

        /*ReCreating New Packet to Send it to Client "Sender" */
        DatagramPacket send_packet = new DatagramPacket(send_buffer,send_buffer.length,addr,port);  //for Sender
        System.out.println("Packetizing New Data Packet to Send to Client");
        socket.send(send_packet);
        System.out.println("Data Packet send to Client ..");

        /*Final word => To Send packet we must specify SocketAddress of Receiver , To Receive packet we can not Specify SocketAddress only port or no port*/
    }

    private static int getfactorial(int n)
    {
        int fact = 1 , N = n;
        for (int i= 2; i<=N ;i++)
            fact *= i;
        return  fact;
    }
}
