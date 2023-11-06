package UDP.ChatRoomDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class receivePart {
  public static void main(String[] args) throws IOException {
    DatagramSocket ds = new DatagramSocket(10086);

    byte[] arr = new byte[1024];

    DatagramPacket dp = new DatagramPacket(arr, arr.length);

    while (true) {
      ds.receive(dp);
      byte[] data = dp.getData();
      int len = dp.getLength();
      String ip = dp.getAddress().getHostAddress();
      String name = dp.getAddress().getHostName();

      System.out.println("ip: " + ip + " name: " + name + " send message: " + new String(data, 0, len));
    }

  }
}
