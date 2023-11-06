package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class receiveMessage {
  public static void main(String[] args) throws IOException {
    // same port as send one
    DatagramSocket ds = new DatagramSocket(10086);

    // receive
    byte[] arr = new byte[1024];
    DatagramPacket dp = new DatagramPacket(arr, arr.length);

    // congested one
//    System.out.println("congested");
    ds.receive(dp);
//    System.out.println("end congested");

    // analyse data
    byte[] data = dp.getData();
    int len = dp.getLength();
    InetAddress sendAddress = dp.getAddress();
    int sendPort = dp.getPort();

    System.out.println("Received data: " + new String(data, 0, len));
    System.out.println("Address is " + sendAddress + " and Port is " + sendPort);

    // free
    ds.close();
  }
}
