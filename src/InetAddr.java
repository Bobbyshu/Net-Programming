import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddr {
  public static void main(String[] args) throws UnknownHostException {

    InetAddress address = InetAddress.getByName("192.168.1.157");
    InetAddress obj = InetAddress.getByName("DESKTOP-H67QOU3");
    System.out.println(obj);
    System.out.println(obj.getHostAddress());
    System.out.println(obj.getHostName());
  }
}
