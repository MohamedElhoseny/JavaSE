package Practical_Code.Socket_Programming.UDP_SOCKET;

import java.io.IOException;
import java.net.*;

/**
 * Created by Elhosany on 9/6/2016.
 */
public class Advanced_Receiver
{
    public static void main(String[] args) throws IOException
    {
        //famous work
        InetAddress addrs = InetAddress.getByName("127.0.0.1");
        int port = 6001;
        InetSocketAddress socketAddress = new InetSocketAddress(addrs,port);

        DatagramSocket socket = new DatagramSocket(socketAddress); //if anyone will connect socket so must specify port
        System.out.println("Server Start at port "+port);

       while (true)
       {
           byte[] data = new byte[1024];
           DatagramPacket packet = new DatagramPacket(data,data.length);   /* hna ana Create el packet bs lesa fadya*/
          // System.out.println("New Packet Received on Server !");

           /* nset a3ml receive le data 2zaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaai*/
           socket.receive(packet);
           System.out.println("New Packet Received on Server !");

           new handler_packet(socket,packet);
           System.out.println("handling Packet ..");
       }

    }

    //inner class
    private static class handler_packet implements Runnable
    {
        DatagramSocket socket;
        DatagramPacket packet;

        public handler_packet(DatagramSocket s,DatagramPacket p)
        {
            this.socket = s;
            this.packet = p;
            new Thread(this).run();
        }
        @Override
        public void run()
        {
            try
            {
            System.out.println("Extracting Client Info ..");
            //extract Client info from packet
            InetAddress Sender_addrs = packet.getAddress();
            int Sender_port = packet.getPort();


            System.out.println("Extracting Packet Data ..");
            //extract data info from packet

             // Horrible Thinking ^|^
            /*
                byte[] b = packet.getData();
                String nn = b.toString();
                int n = Integer.parseInt(nn);
            */

            //Another Horrible _|_
            /*
                byte[] b = packet.getData();
                String data = new String(b,0,b.length);
            */
            String data = new String(packet.getData() , 0 ,packet.getLength());
            Integer n = Integer.parseInt(data);

            System.out.println("Working ....");
            long  fact = 1;
            for (int i= 2; i<= n;i++)
            {
                fact*=i;
            }

            System.out.println("Encapsulating New Packet ..");
            byte[] sdata = String.valueOf(fact).getBytes();  /*to get any variable or object bytes */
            DatagramPacket spacket = new DatagramPacket(sdata,sdata.length,Sender_addrs,Sender_port);

                socket.send(spacket);

              //  socket.close();
                System.out.println("Packet Sent ..");

            }catch (IOException e)
            {
                System.out.println("Error While Sending Response Packet !");
            }

        }
    }
}
