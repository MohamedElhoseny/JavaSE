package Practical_Code.Socket_Programming.UDP_SOCKET;

import Practical_Code.Collection_Framework.Student;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Elhosany on 9/6/2016.
 */

     //Sending Object
public class Advanced_Receiver2
{
    public static void main(String[] args) throws IOException
    {
        while (true) {

            DatagramSocket socket = new DatagramSocket(6001);
            byte[] rdata = new byte[1024];
            DatagramPacket packet = new DatagramPacket(rdata, rdata.length);
            socket.receive(packet);
            System.out.println("New Packet Received !");
            new handler(socket, packet);
        }
    }

    private static class handler implements Runnable
    {
        DatagramSocket socket;
        DatagramPacket packet;

        public handler(DatagramSocket s, DatagramPacket p)
        {
            this.socket = s;
            this.packet = p;
            new Thread(this).run();
        }

        @Override
        public void run()
        {
            try {
                    System.out.println("Start Decapsulate new Received Packet ..");

                    //i will not resend another packet so i will not create byte[] and i will not create a new packet also
                    ByteArrayInputStream read_byte_obj = new ByteArrayInputStream(packet.getData());
                    ObjectInputStream obj = new ObjectInputStream(read_byte_obj);
                    Student x = (Student) obj.readObject();
                    System.out.println("Object Data : ");
                    System.out.println("Student Age = " + x.getage());

                    socket.close();
                } catch (Exception e) {

                }
        }
    }
}
