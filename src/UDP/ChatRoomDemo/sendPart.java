package UDP.ChatRoomDemo;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

// chat room can be set in idea:
// sendPart -> edit configuration
// modify option -> allow multiple instances
// open multiple send part and each part can send message to receive part
public class sendPart {
  public static void main(String[] args) throws IOException {
    DatagramSocket ds = new DatagramSocket();

    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Please input what u wanna said(input quit if you want to quit)");
      String s = sc.nextLine();

      if ("quit".equals(s)) {
        break;
      }

      byte[] arr = s.getBytes();

      InetAddress address = InetAddress.getByName("127.0.0.1");
      int port = 10086;
      DatagramPacket dp = new DatagramPacket(arr, arr.length, address, port);

      ds.send(dp);
    }
    ds.close();
  }
}
