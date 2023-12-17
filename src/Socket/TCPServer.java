package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(50001);
    System.out.println("Server run in port 50001, wait for connect");

    Socket soc = serverSocket.accept();
//    System.out.println("socket = " + soc.getClass());

    InputStream inputStream = soc.getInputStream();
    byte[] buffer = new byte[1024];
    int readLen = 0;
    while ((readLen = inputStream.read(buffer)) != -1) {
      System.out.println(new String(buffer, 0, readLen));
      break;
    }

    OutputStream outputStream = soc.getOutputStream();
    outputStream.write("Hello, client".getBytes());
    soc.shutdownOutput();

    inputStream.close();
    outputStream.close();
    soc.close();
    serverSocket.close();
  }
}
