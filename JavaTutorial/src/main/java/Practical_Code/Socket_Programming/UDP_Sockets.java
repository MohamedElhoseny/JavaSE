package Practical_Code.Socket_Programming;

/**
 * Created by Elhosany on 9/2/2016.
 */
public class UDP_Sockets
{
       /* The Reason of  UDP Transmission Protocol */
    // Quick delivery of data is more important than correct and ordered delivery of data , since TCP always try to recover error or lost data frame
    // it fails to deliver data quickly in the presence of error
    //      SO , TCP IS NOT SUITABLE SOLUTION FOR REAL TIME APPLICATIONS

             /* UDP Sockets IN JAVA*/

    //UDP Style of communication : no connection with ServerSocket  instead , two DatagramSocket Objects are created and data is send and received
    // through a container called (Datagram) which will be represented by DatagramPacket Objects

    //VIP NOTES :
    //  The Packet may be lost on its way or some error may occur in the packet (payload) (Datagram) , Since recovering this packet may take Long time
    //  UDP doesn't try to recover the Packet it only Concentrates on delivering Other Packets
    //  Since Datagram may traverse in different paths so there is no guarantee they will reach in the ordered way they send
    //    => This Style of communication is desired in some situation as Real Time Applications

    // Java Classes Used :
    // 1) DatagramSocket => is used to send and receive Data using its methods
    // 2) DatagramPacket => is a container (called:Packet) of data to be send and to be received

     /* Pref Steps of Creating UDP Socket */
                  //Receiver
    //    1- Create a DatagramSocket specifying port number
    //    2- Create a buffer (byte array) to hold the received data
    //    3- Create a DatagramPacket with this buffer to put packet in it
    //    4- Calls Receive method in DatagramSocket object and passing DatagramPacket through it  (y3ne bcall el method w bb3t el 7aga 2le htt7t feha)

                //Sender
    //    1- Create a DatagramSocket and bint to it port and address
    //    2- Create a buffer to hold data to be send
    //    3- Create a DatagramPacket object specifying the buffer containing data and socket address of DatagramSocket object in the server
    //    4- Call Send method in DatagramSocket object and passing DatagramPacket object as an argument
    //


    /*DatagramSocket Constructors*/
    //DatagramSocket socket = new DatagramSocket(int port);
    //DatagramSocket socket = new DatagramSocket(InetAddress addrs , int port);   //if have multiple ip

    /*DatagramPacket Constructors*/
    // DatagramPacket(byte[] data , int size );        For receiver
    // DatagramPacket(byte[] data , int size , InetAddress addrs , int port)   For sender
    // DatagramPacket(byte[] data , int size , SocketAddress s)  same as previous


}
