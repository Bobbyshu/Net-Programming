package UDP;

import java.io.IOException;
import java.net.*;

public class sendMessage {
  public static void main(String[] args) throws IOException {
    // input parameter: current port
    // default constructor: pick random one in available port
    DatagramSocket ds = new DatagramSocket();

    // package data
    String s = "Hello UDP!";
    byte[] arr = s.getBytes();
    InetAddress address = InetAddress.getByName("127.0.0.1");
    int port = 10086;

    DatagramPacket dp = new DatagramPacket(arr, arr.length, address, port);

    // send data
    ds.send(dp);

    // free resource
    ds.close();
  }
}
