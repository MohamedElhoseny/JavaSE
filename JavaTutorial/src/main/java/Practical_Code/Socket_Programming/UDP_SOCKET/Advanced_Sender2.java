package Practical_Code.Socket_Programming.UDP_SOCKET;

import Practical_Code.Collection_Framework.Student;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Elhosany on 9/6/2016.
 */
public class Advanced_Sender2
{
    public static void main(String[] args) throws IOException
    {
        DatagramSocket socket = new DatagramSocket();  /* No Port Specification let System Specify it as i will not receive anythins*/

        //Create Object
        Student x = new Student(1006,17,"omda");

        //Create DatagramPacket to Store this object and send to Server
        byte[] sdata = new byte[1024];

        /* Now i want to Store a Serializable Object in this byte Array to Set this as a Payload in Packet*/
        // InputStream => read
        //OutputStream => write
        ByteArrayOutputStream write_byte_obj = new ByteArrayOutputStream();
        ObjectOutputStream obj = new ObjectOutputStream(write_byte_obj);  //write object in this ByteArray
        /* nset a write el object*/
        obj.writeObject(x); //el obj byro7 yktb el object fe el 7aga 2le 3ndo fe ay no3 OutputStream l2ma file , ByteArray ,...

        //rg3t b2a a2ra 2le
        sdata = write_byte_obj.toByteArray();   //Write byte array of ByteArray Object



        DatagramPacket packet = new DatagramPacket(sdata,sdata.length, InetAddress.getByName("localhost"),6001);

        //Send Packet to Server
        socket.send(packet);
    }
}
