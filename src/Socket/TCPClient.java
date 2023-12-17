package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
  public static void main(String[] args) throws IOException {
    Socket soc = new Socket(InetAddress.getLocalHost(), 50001);
    System.out.println("Get returned socket: " + soc.getClass());

    OutputStream outputStream = soc.getOutputStream();
    outputStream.write("Hello server".getBytes());
    soc.shutdownOutput();

    InputStream inputStream = soc.getInputStream();
    byte[] buffer = new byte[1024];
    int readLen = 0;
    while ((readLen = inputStream.read(buffer)) != -1) {
      System.out.println(new String(buffer, 0, readLen));
    }

    outputStream.close();
    inputStream.close();
    soc.close();
  }
}
